package uebung4.task12;

import java.io.*;

/**
 * This class handles the encryption of a file.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class FileEncrypter extends FileCryptoHandler {

    private int key;
    private Cipher cipher;

    /**
     * Create an object of this class and use the given encryption method.
     * @param key       key with which will be encrypted
     * @param cipher    encryption method
     */
    public FileEncrypter(int key, String cipher) {
        this.key = key;
        this.cipher = CipherFactory.getInstance(cipher);
    }

    /**
     * Create an object of this class and use the default encryption method.
     * @param key   key with which will be encrypted
     */
    public FileEncrypter(int key) {
        this(key, CipherFactory.defaultCipher);
    }


    /**
     * Encrypt the file given by the path. The encrypted file will be stored in the same directory and has the same
     * name just with .enc extension.
     * Only .txt files are allowed for encryption. Given another file the method will do nothing at all.
     *
     * @param inputPath     Path to file with .txt extension
     */
    public void encrypt(final String inputPath) {
        fileHandling(inputPath);
    }

    /**
     * @see FileCryptoHandler
     */
    @Override
    protected byte[] doCrypto(byte[] input) {
        return cipher.encrypt(input, key);
    }
}
