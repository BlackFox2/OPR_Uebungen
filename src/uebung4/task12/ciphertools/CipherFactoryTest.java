package uebung4.task12.ciphertools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This jUnit-Test checks the CipherFactory
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class CipherFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstance() throws Exception {
        Cipher as = CipherFactory.getInstance("AdditiveSubstitution");
        assertTrue(as instanceof AddSub);
        Cipher xs = CipherFactory.getInstance("XORSubstitution");
        assertTrue(xs instanceof XorSub);
        Cipher sc = CipherFactory.getInstance("StreamCipher");
        assertTrue(sc instanceof StreamCipher);
        Cipher x = CipherFactory.getInstance("hallo");

    }

    @Test
    public void testGetInstance1() throws Exception {
        Cipher as = CipherFactory.getInstance();
        assertTrue(as instanceof AddSub);
    }
}