package uebung4.task12;

import java.io.*;

/**
 * This class handles the decryption of a file.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class FileDecrypter extends FileCryptoHandler{
    private int key;
    private final String decExt = "dec";
    private Cipher cipher;

    /**
     * Create an object with the given dedryption method
     * @param key       key with which the decryption works
     * @param cipher    decryption method
     */
    public FileDecrypter(int key, String cipher) {
        this.key = key;
        this.cipher = CipherFactory.getInstance(cipher);
    }

    /**
     * Create an object with the default decryption method
     * @param key   key with which the decryption works
     */
    public FileDecrypter(int key) {
        this(key, CipherFactory.defaultCipher);
    }

    /**
     * Decrypt the file given by the path. The decrypted file will be stored in the same directory and has the same
     * name just with .dec extension.
     * Only .enc files are allowed for decryption. Given another file the method will do nothing at all.
     *
     * @param inputPath     Path to file with .enc extension
     */
    public void decrypt(final String inputPath) {
        fileHandling(inputPath);
    }

    /**
     * @see FileCryptoHandler
     */
    @Override
    protected byte[] doCrypto(byte[] input) {
        return cipher.decrypt(input, key);
    }
}
