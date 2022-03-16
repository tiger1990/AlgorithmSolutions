package array.algo_company.cryptography.ecds;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * Receiver will verify the signed data
 */
public class ECDSAReceiver implements IAsymmetricCrypto {

    /**
     * @param data is Base64 Encoded and decoded one is in format -> Counter_SignedData_SignedPublicKey_AlgoName
     * @return true is signature verified
     */
    public boolean verifySignedData(byte[] data, String actualData) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException, UnsupportedEncodingException {

        String signData = new String(getDecoder().decode(data));
        if (!signData.contains("_")) return false;

        List<String> signedParts = Arrays.asList(signData.split("_"));
        String signedData = signedParts.get(1);
        String signedPublicKey = signedParts.get(2);
        String algoUsedBySender = signedParts.get(3);

        Signature signatureVerifier = Signature.getInstance(algoUsedBySender);
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(getDecoder().decode(signedPublicKey));
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        signatureVerifier.initVerify(publicKey);
        signatureVerifier.update(actualData.getBytes(StandardCharsets.UTF_8));

        return signatureVerifier.verify(getDecoder().decode(signedData));
    }

    @Override
    public Base64.Decoder getDecoder() {
        return Base64.getDecoder();
    }
}
