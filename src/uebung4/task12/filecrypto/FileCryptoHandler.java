package uebung4.task12.filecrypto;

import uebung4.task12.ciphertools.Cipher;

import java.io.*;

/**
 * This class handles a given path to a file for encryption/decryption.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public abstract class FileCryptoHandler {

    protected int key;
    protected Cipher cipher;

    /**
     * Handles the file to encrypt/decrypt.
     * The file extension for encryption has to be .txt. After the encryption a new file with the same file name is
     * created. It has the extension .enc.
     * The file extension for decryption has to be .enc. After the decryption a new file with the same file name is
     * created. It has the extension .dec
     * It is also possible to provide the path to a directory. All files in this directory which comply with the given
     * extension rules will be encrypted/decrypted. Subfolders are ignored!
     *
     * @param inputPath Path to file with .txt/.enc extension or path to directory
     * @throws IllegalArgumentException when the file/directory does not exist
     */
    protected void pathHandling(final String inputPath) throws IllegalArgumentException{
        File f = new File(inputPath);
        if (!f.exists()) {
            throw new IllegalArgumentException("Error: File/Directory does not exist!");
        }
        if (f.isDirectory()) {
            handleDirectory(f);
        } else {
            handleFile(f);
        }
    }

    /**
     * Method to apply a decryption/encryption to a given file with the right extension.
     * @throws IllegalArgumentException when the given file has no extension
     * @param f     file object to apply crypto on
     */
    protected void handleFile(File f) throws IllegalArgumentException{
        String newPath;
        String inputPath = f.getAbsolutePath();
        int i = inputPath.lastIndexOf('.');     //get index of extension
        if (i > 0) { //extension found
            String ext = inputPath.substring(i + 1);    //extract the extension
            if (getValidExtension().equals(ext)) {
                ext = ext.replace(getValidExtension(), getNewExtension());
            } else {
                throw new IllegalArgumentException("Error: File extension is not suitable for specified crypto task!");
            }
            newPath = inputPath.substring(0, i + 1);    //create new path for output file
            newPath += ext;
        } else {
            throw new IllegalArgumentException("Error: Given file has no file extension!");
        }
        FileInputStream in;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File does not exist!");
            return;
        }
        byte input[] = new byte[(int) f.length()];
        FileOutputStream out;
        try {
            out = new FileOutputStream(newPath);
            in.read(input);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Not able to create output file!");
            return;
        } catch (IOException e) {
            System.out.println("Error: Not able to read input file!");
            return;
        }
        try {
            out.write(doCrypto(input));
        } catch (IOException e) {
            System.out.println("Error: Not able to write to output file!");
            return;
        }
    }

    /**
     * Method to try to apply encryption/decryption to all files in the given directory
     * @param d     the file object which is an directory
     */
    protected void handleDirectory(File d) {
        if(d == null) {
            return;
        }
        for (final File fileEntry : d.listFiles()) {
            if (fileEntry.isFile()) {   //we got a file here so check it
                handleFile(fileEntry);
            }
        }
    }

    /**
     * Execute the cryptographic task on the bytes given.
     *
     * @param input bytes
     * @return the bytes with applied crypto
     */
    protected abstract byte[] doCrypto(byte[] input);

    /**
     * Get the valid file extension for which the crypto task can be applied.
     * @return  file extension
     */
    protected abstract String getValidExtension();

    /**
     * Get the new file extension for the new file after the crypto task is applied
     * @return  file extension
     */
    protected abstract String getNewExtension();
}
