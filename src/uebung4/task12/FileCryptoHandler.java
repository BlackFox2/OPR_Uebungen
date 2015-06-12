package uebung4.task12;

import java.io.*;

/**
 * This class handles a given path to a file for encryption/decryption.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public abstract class FileCryptoHandler {

    private int key;
    private Cipher cipher;
    private final String encExt = "enc";
    private final String decExt = "dec";
    private final String plainExt = "txt";


    /**
     * Handles the file to encrypt/decrypt.
     * The file extension for encryption has to be .txt. After the encryption a new file with the same file name is
     * created. It has the extension .enc.
     * The file extension for decryption has to be .enc. After the decryption a new file with the same file name is
     * created. It has the extension .dec
     *
     * @param inputPath     Path to file with .txt/.enc extension
     */
    private void fileHandling(final String inputPath) {
        String ext = "";
        int i  = inputPath.lastIndexOf('.');
        if(i > 0) {
            ext = inputPath.substring(i+1);
        }
        String newPath;
        if(ext.equals(encExt)) {    //do decryption
            ext = ext.replace(encExt, decExt);
            newPath = inputPath.substring(0, i);
            newPath += ext;
        } else if(ext.equals(plainExt)) {   //do encryption
            ext = ext.replace(plainExt, encExt);
            newPath = inputPath.substring(0, i);
            newPath += ext;
        } else {
            return;
        }
        File f = new File(inputPath);
        if (!f.exists()) {
            System.out.println("Error: File does not exist!");
            return;
        }
        FileInputStream in;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File does not exist!");
            return;
        }
        byte input[] = new byte[(int)f.length()];
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
            //out.write(cipher.decrypt(input, key));
            out.write(doCrypto(input));
        } catch (IOException e) {
            System.out.println("Error: Not able to write to output file!");
            return;
        }

    }

    public abstract byte[] doCrypto(byte[] input);
    //public abstract void doDecryption();

}
