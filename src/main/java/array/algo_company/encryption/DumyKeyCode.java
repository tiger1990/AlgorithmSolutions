package array.algo_company.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DumyKeyCode {

    public static void main(String[] args) throws IOException {
//        String rawData = doPadding(getMasterCardRequestData());
//        System.out.println("Original Data =" + rawData);
//        String desKey = generateDESKey();
//        System.out.println("DES Key=" + desKey);
//        String encryptedData = encryptDES(rawData);
//        System.out.println("data =" + encryptedData);
//        String initializationVector = "99999999999999999999999999999999";
//        String encodedASNData = "302C0418" + desKey + "0410" + initializationVector;
//        System.out.println("Encryted ASN Data =" + encodedASNData);
//        String rsaEncryptedData = encryptRSAData(encodedASNData);
//        System.out.println("encKey =" + rsaEncryptedData);


        String abc = "111111111111111211111111111111131111111111111111";

"b58d4befec1c421e6202aabfe09040c3131bc2b7c545f1f9da0dd9a6a66761f132152560b4f11ebb28024b6a4590d23636b9cc70da0f36236b6e5c7ccfdbd32c".toUpperCase();

        String abv = abc.substring(0,16);
        String abv2 = abc.substring(16,32);


        try {

//            encryptDES("ABCD45FGSDI56FFFGFDSERTYUFGDSH5F",abc);


        } catch (Exception  e) {
            e.printStackTrace();
        }

    }

//    private static String encryptDES(String hexKey,String message) {
//        try {
//            final Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
//            SecretKeySpec keySpec = new SecretKeySpec(bytesToHex(hexKey.getBytes()).toCharArray(), "DES");
//            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//            final byte[] plainTextBytes = message.getBytes("utf-8");
//            final byte[] cipherText = cipher.doFinal(plainTextBytes);
////            char cha[] = Hex.encodeHex(cipherText);
////            final byte[] encodedCipherText = Base64.encodeBase64(cipherText);
//          //  return new String(encodedCipherText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


//    /**
//     * @return Data corresponding to a user
//     */
//    private static String getMasterCardRequestData() {
////        JSONObject obj = new JSONObject();
////        try {
////            obj.put(Keys.accountNumber, "1000058478");
////            obj.put(Keys.mobileNumber, "9971253965");
////            obj.put(Keys.timeStamp, System.currentTimeMillis());
////        } catch (JSONException e) {
////        }
//
//        //return obj.toString();
//        return "";
//    }
//
//    /**
//     * @param masterCardData
//     * @return Data after doing padding
//     */
//    private static String doPadding(String masterCardData) {
//        if (masterCardData == null) {
//            return null;
//        }
//        char[] initialArray = masterCardData.toCharArray();
//        int paddingBits = initialArray.length % 8;
//        char[] paddeddata = new char[initialArray.length + 8 - paddingBits];
//        System.arraycopy(initialArray, 0, paddeddata, 0, initialArray.length);
//        for (int i = initialArray.length; i < paddeddata.length; i++) {
//            paddeddata[i] = 'F';
//        }
//        return new String(paddeddata);
//    }
//
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
//
//    private static SecretKey secretKey = null;
//    private static String hexKey = null;
//
//    /**
//     * @return Generates DES Key
//     */
//
//    private static String generateDESKey() {
//        try {
//            KeyGenerator generator = KeyGenerator.getInstance("DESede");
//            generator.init(168);
//            secretKey = generator.generateKey();
//            return hexKey = new String(Hex.encodeHex(secretKey.getEncoded(), false)).toUpperCase();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * @param message
//     * @return Code for encryting the data with DES
//     */
//
//    private static String encryptDES(String message) {
//        try {
//            final Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding");
//            SecretKeySpec keySpec = new SecretKeySpec(Hex.decodeHex(hexKey.toCharArray()), "DESede");
//            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//            final byte[] plainTextBytes = message.getBytes("utf-8");
//            final byte[] cipherText = cipher.doFinal(plainTextBytes);
//            char cha[] = Hex.encodeHex(cipherText);
//            final byte[] encodedCipherText = Base64.encodeBase64(cipherText);
//            return new String(encodedCipherText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * @param data
//     * @return
//     */
//
//    public static String encryptRSAData(String data) {
//        try {
//            Cipher oaepFromAlgo = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
//            oaepFromAlgo.init(Cipher.ENCRYPT_MODE, readPublicKey());
//            byte[] initial = org.apache.commons.codec.binary.Hex.decodeHex(data.toCharArray());
//            System.out.println("Initial Before RSA " + new String(initial));
//            byte[] ct = oaepFromAlgo.doFinal(initial);
//            String request = new String(org.apache.commons.codec.binary.Base64.encodeBase64(ct));
//            return request;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * Key in the String form sent from the server
//     */
//
//    private static String readMasterCardPublicKey;
//
//    public static PublicKey readPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
//        X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(readMasterCardPublicKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        return keyFactory.generatePublic(publicSpec);
//    }
//
//
//    private interface Keys {
//
//        String accountNumber = "accountNumber";
//        String mobileNumber = "mobileNumber";
//        String timeStamp = "timeStamp";
//
//    }

}
