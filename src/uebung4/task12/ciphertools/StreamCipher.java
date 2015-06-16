package uebung4.task12.ciphertools;

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
     * Uses the stream cipher algorithm for encryption. The key is used as seed for the Random keygenerator. 0 is a valid
     * key when used with this cipher.
     *
     * @param plainbytes bytes to encrypt
     * @param key        key to use for encryption
     * @throws IllegalArgumentException when input bytes are null
     * @return the encrypted bytes
     *
     */
    @Override
    public byte[] encrypt(byte[] plainbytes, int key) throws IllegalArgumentException {
        return doXor(plainbytes, key, true);
    }

    /**
     * Uses the stream cipher algorithm for decryption. The key is used as seed for the Random keygenerator. 0 is a valid
     * key when used with this cipher.
     *
     * @param cryptbytes bytes to decrypt
     * @param key        key to use for decryption
     * @throws IllegalArgumentException when input bytes are null
     * @return the decrypted bytes/plaintext
     *
     */
    @Override
    public byte[] decrypt(byte[] cryptbytes, int key) throws IllegalArgumentException {
        return doXor(cryptbytes, key, false);
    }

    /**
     * Does the actual encryption/decryption.
     * @param bytes         input bytes to decrypt/encrypt
     * @param key           key to use as seed for the Random generator
     * @param doEncryption  <code>true</code> to do the encryption
     *                      <code>false</code> to do the decryption
     * @return              the decrypted/encrypted bytes
     * @throws IllegalArgumentException when the input bytes are null
     */
    private byte[] doXor(byte[] bytes, int key, boolean doEncryption) throws IllegalArgumentException {
        if (bytes == null) {
            throw new IllegalArgumentException("Error: given bytes are wrong!");
        }
        XorSub xor = new XorSub();
        byte[] result = new byte[bytes.length];
        Random generator = new Random();
        generator.setSeed(key);
        for (int i = 0; i < bytes.length; i++) {
            byte[] temp = new byte[1];
            temp[0] = bytes[i];
            if (doEncryption) {
                result[i] = xor.encrypt(temp, generator.nextInt())[0];
            } else {
                result[i] = xor.decrypt(temp, generator.nextInt())[0];
            }
        }
        return result;
    }
}
