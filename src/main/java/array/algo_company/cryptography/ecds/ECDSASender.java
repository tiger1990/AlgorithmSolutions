package array.algo_company.cryptography.ecds;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

public class ECDSASender implements IAsymmetricCrypto {

    private PublicKey mPublicKey;
    private PrivateKey mPrivateKey;
    private int SignCounter = 0;

    public ECDSASender() throws NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {
        generateKeyPair();
    }

    private void generateKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("secp256r1");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(ecGenParameterSpec, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        mPublicKey = keyPair.getPublic();
        mPrivateKey = keyPair.getPrivate();
    }

    /**
     * Helper function to sign plainText data
     *
     * @param plainText plain text that need to be signed
     * @return String with Counter_SignedData_SignedPublicKey_AlgoName
     */
    public byte[] getSignedMyData(String plainText) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, UnsupportedEncodingException {

        Signature ecdsa = Signature.getInstance(getAlgorithmName());
        ecdsa.initSign(mPrivateKey);
        ecdsa.update(plainText.getBytes(StandardCharsets.UTF_8));
        byte[] signature = ecdsa.sign();

        String encodePublicKey = getEncoder().encodeToString(mPublicKey.getEncoded());
        String encodedSignedData = getEncoder().encodeToString(signature);
        SignCounter++;
        String signedData = SignCounter +
                "_" +
                encodedSignedData +
                "_" +
                encodePublicKey +
                "_" +
                getAlgorithmName();
        return getEncoder().encode(signedData.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getAlgorithmName() {
        return "SHA256withECDSA";
    }

    @Override
    public Base64.Encoder getEncoder() {
        return Base64.getEncoder();
    }
}