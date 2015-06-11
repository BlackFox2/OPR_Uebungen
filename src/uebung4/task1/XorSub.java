package uebung4.task1;

import uebung3.task2.Circuit;

/**
 * This class represents a serial circuit of 2 parts. These parts can be objects implementing the Circuit-Interface.
 *
 * @see Cipher
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class XorSub implements Cipher {
    /**
     * Encrypts the given plainbytes with Xor-Substitution algorithm. The given key is used to XOR the plainbytes
     *
     * @param plainbytes bytes to encrypt
     * @param key        key to use for encryption, must be != 0
     * @return           the encrypted bytes on success
     *                   null on failure;
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
        for(int  i = 0; i < plainbytes.length; i++) {
            cipher[i] = (byte) (plainbytes[i] ^ key);
        }
        return cipher;
    }

    /**
     * Decrypts the given bytes with the provided key.
     *
     * @param cryptbytes bytes to decrypt
     * @param key        key to use for decryption, must be != 0
     * @return           the decrypted bytes on success
     *                   null on failure
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
        byte plain[] = new byte[cryptbytes.length];
        for(int i = 0; i < cryptbytes.length; i++) {
            plain[i] = (byte) (cryptbytes[i] ^ key);
        }
        return plain;
    }
}
