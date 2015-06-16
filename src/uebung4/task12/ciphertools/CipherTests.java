package uebung4.task12.ciphertools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This jUnit-Test checks the classes AddSub
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class CipherTests {

    /**
     * Test the implementation of algorithm additive substitution in class AddSub
     *
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddSub() throws Exception {
        byte[] plain = {10, 20, 30, 40, 50, 60, -20, 127};
        byte[] cipher = {15, 25, 35, 45, 55, 65, -15, -124};
        byte[] result;
        int key = 5;
        //test with valid parameters
        AddSub as = new AddSub();
        result = as.encrypt(plain, key);
        assertArrayEquals(cipher, result);
        //test if decryption gives the plaintext as result
        result = as.decrypt(cipher, key);
        assertArrayEquals(plain, result);
        //test with invalid key 0
        key = 0;
        result = as.encrypt(plain, key);
        //test with invalid parameter plaintext
        key = 5;
        plain = null;
        result = as.encrypt(plain, key);
        //test with a more complex input (overflows etc.)
        byte[] complex = {123, 28, -54, 65, -24, 29, 47, 38, -59, 127, -128, 0};
        key = 12874;
        result = as.encrypt(complex, key);
        assertArrayEquals(complex, as.decrypt(result, key));

    }

    /**
     * Test the implementation of algorithm XOR-Substitution in class XorSub
     *
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testXorSub() throws Exception {
        byte[] plain = {10, 20, 30, 40, 50, 60, -20, 127};
        byte[] cipher = {0, 30, 20, 34, 56, 54, -26, 117};
        byte[] result;
        int key = 10;
        //test with valid parameters
        XorSub xs = new XorSub();
        result = xs.encrypt(plain, key);
        assertArrayEquals(cipher, result);
        //test if decryption gives the plaintext as result
        result = xs.decrypt(cipher, key);
        assertArrayEquals(plain, result);
        //test with invalid key 0
        key = 0;
        result = xs.encrypt(plain, key);
        //test with invalid parameter plaintext
        key = 10;
        plain = null;
        result = xs.encrypt(plain, key);
        //test with a more complex input (overflows etc.)
        byte[] complex = {123, 28, -54, 65, -24, 29, 47, 38, -59, 127, -128, 0};
        key = 1283;
        result = xs.encrypt(complex, key);
        assertArrayEquals(complex, xs.decrypt(result, key));
    }

    /**
     * Test the implementation of the stream cipher in class StreamCipher
     *
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testStreamCipher() throws Exception {
        byte[] plain = {10, 20, 30, 40, 50, 60, -20, 127};
        byte[] result;
        int key = 10;
        //test with valid parameters, result is checked with decryption
        StreamCipher sc = new StreamCipher();
        result = sc.encrypt(plain, key);
        assertArrayEquals(plain, sc.decrypt(result, key));
        //test with key 0
        key = 0;
        result = sc.encrypt(plain, key);
        assertArrayEquals(plain, sc.decrypt(result, key));
        //test with invalid parameter plaintext
        plain = null;
        result = sc.encrypt(plain, key);

    }
}