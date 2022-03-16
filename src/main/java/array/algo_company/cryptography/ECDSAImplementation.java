package array.algo_company.cryptography;

import array.algo_company.cryptography.ecds.ECDSASender;
import array.algo_company.cryptography.ecds.ECDSAReceiver;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class ECDSAImplementation {

    public static String PLAIN_TEXT = "VIJAY DEENA-NATH CHAUHAN";

    public static void main(String... args) {
        System.out.println("Java Version: " + getJavaVersion());
        System.out.println("Java Version: " + getJavaVersion());
        System.out.println("Java Version: " + getJavaVersion());
        System.out.println("Java Version: " + getJavaVersion());
        implementECDAS();
    }

    private static void implementECDAS() {
        try {
            ECDSASender sender = new ECDSASender();
            byte[] data = sender.getSignedMyData(PLAIN_TEXT);

            ECDSAReceiver receiver = new ECDSAReceiver();
            boolean verified = receiver.verifySignedData(data, PLAIN_TEXT);
            System.out.println("Verified:" + verified);

        } catch (NoSuchAlgorithmException | SignatureException
                | InvalidKeyException | InvalidKeySpecException
                | InvalidAlgorithmParameterException
                | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static String getJavaVersion() {
        String[] javaVersionElements = System.getProperty("java.runtime.version").split("\\.|_|-b");
        String main = "", major = "", minor = "", update = "", build = "";
        int elementsSize = javaVersionElements.length;
        if (elementsSize > 0) {
            main = javaVersionElements[0];
        }
        if (elementsSize > 1) {
            major = javaVersionElements[1];
        }
        if (elementsSize > 2) {
            minor = javaVersionElements[2];
        }
        if (elementsSize > 3) {
            update = javaVersionElements[3];
        }
        if (elementsSize > 4) {
            build = javaVersionElements[4];
        }
        return "main: " + main + " major: " + major + " minor: " + minor + " update: " + update + " build: " + build;
    }
}
