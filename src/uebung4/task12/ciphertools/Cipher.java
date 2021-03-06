package uebung4.task12.ciphertools;

/**
 * This interface has methods for encryption and decryption.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public interface Cipher {


    /**
     * Encrypts the given plainbytes with the provided key.
     *
     * @param plainbytes bytes to encrypt
     * @param key        key to use for encryption
     * @throws IllegalArgumentException when input bytes are null or key is 0
     * @return the encrypted bytes
     */
    byte[] encrypt(byte[] plainbytes, int key) throws IllegalArgumentException;

    /**
     * Decrypts the given bytes with the provided key.
     *
     * @param cryptbytes bytes to decrypt
     * @param key        key to use for decryption
     * @throws IllegalArgumentException when input bytes are null or key is 0
     * @return the decrypted bytes/plaintext
     */
    byte[] decrypt(byte[] cryptbytes, int key) throws IllegalArgumentException;
}
