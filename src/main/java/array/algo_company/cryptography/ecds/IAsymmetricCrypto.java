package array.algo_company.cryptography.ecds;

import java.util.Base64;

public interface IAsymmetricCrypto {

    /**
     * @return Algorithm-Name used in implementation
     */
    default String getAlgorithmName(){
        return null;
    }

    /**
     * Implement in class where required
     * @return Encoding-Used used in implementation
     */
    default Base64.Encoder getEncoder() {
        return null;
    }

    /**
     * Implement in class where required
     * @return Corresponding Decoder-used in encoding implementation
     */
    default Base64.Decoder getDecoder(){
        return null;
    }
}
