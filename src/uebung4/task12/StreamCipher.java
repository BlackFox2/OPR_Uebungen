package uebung4.task12;

import java.util.Random;

/**
 * This class implements the a stream cipher for encryption. The algorithm is applied to a given array
 * of bytes.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class StreamCipher implements Cipher {
    /**
     * @see Cipher
     * Uses the stream cipher algorithm for encryption. The key is used as seed for the Random keygenerator.
     *
     * @param plainbytes bytes to encrypt
     * @param key        key to use for encryption
     * @return the encrypted bytes
     */
    @Override
    public byte[] encrypt(byte[] plainbytes, int key) {
        return doXor(plainbytes, key, true);
    }

    /**
     * @see Cipher
     * Uses the stream cipher algorithm for decryption. The key is used as seed for the Random keygenerator.
     *
     * @param cryptbytes bytes to decrypt
     * @param key        key to use for decryption
     * @return the decrypted bytes/plaintext
     */
    @Override
    public byte[] decrypt(byte[] cryptbytes, int key) {
        return doXor(cryptbytes, key, false);
    }

    private byte[] doXor(byte[] bytes, int key, boolean doEncryption) {
        if(bytes == null) {
            System.out.println("Error: given parameters are wrong.");
            return null;
        }
        XorSub xor = new XorSub();
        byte[] result = new byte[bytes.length];
        Random generator = new Random();
        generator.setSeed(key);
        for(int i = 0; i < bytes.length; i++) {
            byte[] temp = new byte[1];
            temp[0] = bytes[i];
            if(doEncryption) {
                result[i] = xor.encrypt(temp, generator.nextInt())[0];
            } else {
                result[i] = xor.decrypt(temp, generator.nextInt())[0];
            }
        }
        return result;
    }
}
