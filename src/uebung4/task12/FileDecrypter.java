package uebung4.task12;

import java.io.*;

/**
 * This class handles the decryption of a file.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class FileDecrypter {
    private int key;
    private final String decExt = "dec";
    private Cipher cipher;

    /**
     * Create an object with the given dedryption method
     * @param key       key with which the decryption works
     * @param cipher    decryption method
     */
    public FileDecrypter(int key, Cipher cipher) {
        this.key = key;
        this.cipher = cipher;
    }

    /**
     * Create an object with the default decryption method
     * @param key   key with which the decryption works
     */
    public FileDecrypter(int key) {
        this(key, CipherFactory.getInstance());
    }

    /**
     * Decrypt the file given by the path. The decrypted file will be stored in the same directory and has the same
     * name just with .dec extension.
     * Only .enc files are allowed for decryption. Given another file the method will do nothing at all.
     *
     * @param inputPath     Path to file with .enc extension
     * @throws FileNotFoundException    when path provided is not an existing file
     * @throws IOException              in case the file cannot be read or the output file cannot be written
     */
    public void decrypt(final String inputPath) throws  FileNotFoundException, IOException{
        String ext = "";
        int i  = inputPath.lastIndexOf('.');
        if(i > 0) {
            ext = inputPath.substring(i+1);
        }
        if(ext.equals("enc")) {
            File f = new File(inputPath);
            if (!f.exists()) {
                throw new FileNotFoundException("Error: File not found.");
            }
            FileInputStream in = new FileInputStream(f);
            byte input[] = new byte[(int)f.length()];
            ext = ext.replace("enc", decExt);
            String newPath = inputPath.substring(0, i);
            newPath += ext;
            FileOutputStream out = new FileOutputStream(newPath);
            in.read(input);
            out.write(cipher.decrypt(input, key));
        }
    }
}
