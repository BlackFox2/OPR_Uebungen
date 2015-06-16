package uebung4.task12.filecrypto;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;

/**
 * This jUnit-Test checks the FileDecrypter/FileEncrypter implementations
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class FileCryptoTest {

    @Test(expected = IllegalArgumentException.class)
    public void additiveSubTest() throws Exception {
        String path = "additive.txt";
        FileEncrypter fe = new FileEncrypter(5, "AdditiveSubstitution");
        FileDecrypter fd = new FileDecrypter(5, "AdditiveSubstitution");
        byte[] expected = {54, 53, 55, 53, 125, 53, 57, 53, 58, 53, 59, 53, 50, 55, 53, 54, 55, 60};
        byte[] plain = {49, 48, 50, 48, 120, 48, 52, 48, 53, 48, 54, 48, 45, 50, 48, 49, 50, 55};

        fe.encrypt(path);
        FileInputStream in = new FileInputStream(new File("additive.enc"));
        byte[] result = new byte[18];
        in.read(result);

        assertArrayEquals(expected, result);

        fd.decrypt("additive.enc");
        in = new FileInputStream(new File("additive.dec"));
        result = new byte[18];
        in.read(result);

        assertArrayEquals(plain, result);

        // put in separate test method
        path="additive.dec";
        fe.encrypt(path);

        path="additive.txt";
        fd.decrypt(path);

    }

    @Test(expected = IllegalArgumentException.class)
    public void xorSubTest() throws Exception {
        String path = "xor.txt";
        FileEncrypter fe = new FileEncrypter(5, "XORSubstitution");
        FileDecrypter fd = new FileDecrypter(5, "XORSubstitution");
        byte[] expected = {52, 53, 55, 53, 54, 53, 49, 53, 48, 53, 51, 53, 40, 55, 53, 52, 55, 50};
        byte[] plain = {49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 45, 50, 48, 49, 50, 55};

        fe.encrypt(path);
        FileInputStream in = new FileInputStream(new File("xor.enc"));
        byte[] result = new byte[18];
        in.read(result);

        assertArrayEquals(expected, result);

        fd.decrypt("xor.enc");
        in = new FileInputStream(new File("xor.dec"));
        result = new byte[18];
        in.read(result);

        assertArrayEquals(plain, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void streamCipherTest() throws Exception {
        String path = "stream.txt";
        FileEncrypter fe = new FileEncrypter(5, "StreamCipher");
        FileDecrypter fd = new FileDecrypter(5, "StreamCipher");

        byte[] plain = {49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 45, 50, 48, 49, 50, 55};

        fe.encrypt(path);

        /* the encryption step is hard to test because of the random generator, so I just test if at the end, the output
           is the same plain text as the input */

        fd.decrypt("stream.enc");
        FileInputStream in = new FileInputStream(new File("stream.dec"));
        byte[] result = new byte[18];
        in.read(result);

        assertArrayEquals(plain, result);
    }
}