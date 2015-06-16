package uebung4.task12.ciphertools;

/**
 * This class represents a serial circuit of 2 parts. These parts can be objects implementing the Circuit-Interface.
 *
 * @author Markus Marihart
 * @version 1.0
 * @see Cipher
 */
public class XorSub implements Cipher {
    /**
     * Encrypts the given plainbytes with Xor-Substitution algorithm. The given key is used to XOR the plainbytes
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
            cipher[i] = (byte) (plainbytes[i] ^ key);
        }
        return cipher;
    }

    /**
     * Decrypts the given bytes with the provided key.
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
        byte plain[] = new byte[cryptbytes.length];
        for (int i = 0; i < cryptbytes.length; i++) {
            plain[i] = (byte) (cryptbytes[i] ^ key);
        }
        return plain;
    }
}
