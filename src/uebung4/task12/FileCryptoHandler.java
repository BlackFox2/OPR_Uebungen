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
    protected void pathHandling(final String inputPath) {
        File f = new File(inputPath);
        if (!f.exists()) {
            System.out.println("Error: File/Directory does not exist!");
            return;
        }
        if(f.isDirectory()) {
            handleDirectory(f);
        } else {
            handleFile(f);
        }
    }

    protected void handleFile(File f) {
        String ext = "";
        String newPath = "";
        String inputPath = f.getAbsolutePath();
        int i  = inputPath.lastIndexOf('.');
        if(i > 0) {
            ext = inputPath.substring(i+1);
            switch (ext) {
                case encExt:     //do decryption
                    ext = ext.replace(encExt, decExt);
                    newPath = inputPath.substring(0, i);
                    newPath += ext;
                    break;
                case plainExt:    //do encryption
                    ext = ext.replace(plainExt, encExt);
                    newPath = inputPath.substring(0, i);
                    newPath += ext;
                    break;
                default:
                    return;
            }
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
            out.write(doCrypto(input));
        } catch (IOException e) {
            System.out.println("Error: Not able to write to output file!");
            return;
        }
    }

    protected void handleDirectory(File d) {
        for(final File fileEntry : d.listFiles()) {
            if(fileEntry.isFile()) {
                handleFile(fileEntry);
            }
        }
    }

    /**
     * Execute the cryptographic task on the bytes given.
     * @param input bytes
     * @return      the bytes with applied crypto
     */
    protected abstract byte[] doCrypto(byte[] input);
}
