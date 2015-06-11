package uebung4.task1;

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
     * Test the implementation of algorithmus additive substitution in class AddSub
     * @throws Exception
     */
    @Test
    public void testAddSub() throws Exception {
        byte[] plain = {10, 20, 30, 40, 50, 60, -20, 127};
        byte[] cipher = {15, 25,35, 45, 55, 65, -15, -124};
        byte[] result;
        int key = 5;

        AddSub as = new AddSub();
        result = as.encrypt(plain, key);

        assertArrayEquals(cipher, result);

        result = as.decrypt(cipher, key);
        assertArrayEquals(plain, result);

        key = 0;
        result = as.encrypt(plain, key);
        assertEquals(null, result);

        key = 5;
        plain = null;
        result = as.encrypt(plain, key);
        assertEquals(null, result);

        byte[] complex = {123,28,-54, 65, -24, 29, 47, 38, -59, 127, -128, 0};
        key = 12874;
        result = as.encrypt(complex, key);
        assertArrayEquals(complex, as.decrypt(result, key));

    }

    /**
     * Test the implementation of algorithm XOR-Substitution in class XorSub
     * @throws Exception
     */
    @Test
    public void testXorSub() throws Exception {
        byte[] plain = {10, 20, 30, 40, 50, 60, -20, 127};
        byte[] cipher = {0, 30, 20, 34, 56, 54, -26, 117};
        byte[] result;
        int key = 10;

        XorSub xs = new XorSub();
        result = xs.encrypt(plain, key);
        assertArrayEquals(cipher, result);

        result = xs.decrypt(cipher, key);
        assertArrayEquals(plain, result);

        key = 0;
        result = xs.encrypt(plain, key);
        assertEquals(null, result);

        key = 10;
        plain = null;
        result = xs.encrypt(plain, key);
        assertEquals(null, result);

        byte[] complex = {123,28,-54, 65, -24, 29, 47, 38, -59, 127, -128, 0};
        key = 1283;
        result = xs.encrypt(complex, key);
        assertArrayEquals(complex, xs.decrypt(result, key));
    }

    /**
     * Test the implementation of the stream cipher in class StreamCipher
     * @throws Exception
     */
    @Test
    public void testStreamCipher() throws Exception {
        byte[] plain = {10, 20, 30, 40, 50, 60, -20, 127};
        byte[] result;
        int key = 10;
        StreamCipher sc = new StreamCipher();
        result = sc.encrypt(plain, key);
        assertArrayEquals(plain, sc.decrypt(result, key));

        key = 0;
        result = sc.encrypt(plain, key);
        assertArrayEquals(plain, sc.decrypt(result,key));

        plain = null;
        result = sc.encrypt(plain, key);
        assertArrayEquals(plain, sc.decrypt(result, key));

    }
}