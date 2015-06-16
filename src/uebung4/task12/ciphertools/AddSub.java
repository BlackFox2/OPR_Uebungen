package uebung4.task12.ciphertools;

/**
 * This class implements the additive substitution algorithm for encryption. The algorithm is applied to a given array
 * of bytes.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class AddSub implements Cipher {

    /**
     * Uses the additive substitution algorithm for the encryption process.
     * @see Cipher
     */
    @Override
    public byte[] encrypt(byte[] plainbytes, int key) throws IllegalArgumentException {
        if (plainbytes == null) {
            throw new IllegalArgumentException("Error: given bytes are wrong!");
        }
        if (key == 0) {
            throw new IllegalArgumentException("Error: Encryption with key 0 is not an encryption! So you should already have the plaintext");
        }
        byte[] cipher = new byte[plainbytes.length];
        for (int i = 0; i < plainbytes.length; i++) {
            cipher[i] = (byte) (plainbytes[i] + key);
        }
        return cipher;
    }

    /**
     * Uses the additive substitution algorithm for the decryption process.
     * @see Cipher
     */
    @Override
    public byte[] decrypt(byte[] cryptbytes, int key) throws IllegalArgumentException {
        if (cryptbytes == null) {
            throw new IllegalArgumentException("Error: given bytes are wrong!");
        }
        if (key == 0) {
            throw new IllegalArgumentException("Error: Encryption with key 0 is not an encryption! So you should already have the plaintext");
        }
        byte[] plain = new byte[cryptbytes.length];
        for (int i = 0; i < cryptbytes.length; i++) {
            plain[i] = (byte) (cryptbytes[i] - key);
        }
        return plain;
    }
}
