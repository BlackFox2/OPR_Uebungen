package uebung4.task1;

/**
 * This class implements the additive substition algorithm for encryption. The algorithm is applied to a given array
 * of bytes.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class AddSub implements Cipher {
    /**
     * @see Cipher
     * Uses the additive substitution algorithm for the encryption process.
     *
     * @param plainbytes bytes to encrypt
     * @param key        key to use for encryption
     * @return the encrypted bytes
     */
    @Override
    public byte[] encrypt(byte[] plainbytes, int key) {
        if(plainbytes == null) {
            System.out.println("Error: given parameters are wrong.");
            return null;
        }
        if(key == 0) {
            System.out.println("Error: Encryption with key 0 is not an encryption!");
            return null;
        }
        byte[] cipher = new byte[plainbytes.length];
        for(int i = 0; i < plainbytes.length; i++) {
            cipher[i] = (byte) (plainbytes[i] + key);
        }
        return cipher;
    }

    /**
     * @see Cipher
     * Uses the additive substitution algorithm for the cdecryption process.
     *
     * @param cryptbytes bytes to decrypt
     * @param key        key to use for decryption
     * @return the decrypted bytes/plaintext
     */
    @Override
    public byte[] decrypt(byte[] cryptbytes, int key) {
        if(cryptbytes == null) {
            System.out.println("Error: given parameters are wrong.");
            return null;
        }
        if(key == 0) {
            System.out.println("Error: Encryption with key 0 is not an encryption! So you should already have the plaintext");
            return null;
        }
        byte[] plain = new byte[cryptbytes.length];
        for(int i = 0; i < cryptbytes.length; i++) {
            plain[i] = (byte) (cryptbytes[i] - key);
        }
        return plain;
    }
}
