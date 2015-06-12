package uebung4.task12;

import java.io.*;

/**
 * This class handles the encryption of a file.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class FileEncrypter {

    private int key;
    private Cipher cipher;
    private final String encExt = "enc";

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
        this.key = key;
        this.cipher = CipherFactory.getInstance();
    }


    /**
     * Encrypt the file given by the path. The encrypted file will be stored in the same directory and has the same
     * name just with .enc extension.
     * Only .txt files are allowed for encryption. Given another file the method will do nothing at all.
     *
     * @param inputPath     Path to file with .txt extension
     * @throws FileNotFoundException    when path provided is not an existing file
     * @throws IOException              in case the file cannot be read or the output file cannot be written
     */
    public void encrypt(final String inputPath) throws FileNotFoundException, IOException {
        String ext = "";
        int i  = inputPath.lastIndexOf('.');
        if(i > 0) {
            ext = inputPath.substring(i+1);
        }
        if(ext.equals("txt")) {
            File f = new File(inputPath);
            if (!f.exists()) {
                throw new FileNotFoundException("Error: File not found.");
            }
            FileInputStream in = new FileInputStream(f);
            byte input[] = new byte[(int)f.length()];
            String newPath = inputPath.replace("txt", encExt);
            FileOutputStream out = new FileOutputStream(newPath);
            in.read(input);
            out.write(cipher.encrypt(input, key));

        }
    }
}
