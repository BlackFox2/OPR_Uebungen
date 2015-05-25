package uebung3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This jUnit-Test checks the classes CrossTotal, SingleCrossTotal and AlternatingCrossTotal.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class ChecksumTests {

    @Test
    public void testCrossTotal() throws Exception {
        CrossTotal c = new CrossTotal();
        String input = "Hallo Welt!";
        int check = c.checksum(input);
        assertEquals(91, check, 0.0);

        input = "!\"$%&/()=?-.,:;'#*+~|";
        //33 + 34 + 36 + 37 + 38 + 47 + 40 +41 + 61 + 63 + 45 + 46 + 44 + 58 + 59 + 39 + 35 + 42 + 43 + 126 + 124
        check = c.checksum(input);
        assertEquals(182 , check, 0.0);
    }

    @Test
    public void testSingleCrossTotal() throws Exception {
        SingleCrossTotal sc = new SingleCrossTotal();
        String input = "Hallo Welt!";
        int check = sc.checksum(input);
        assertEquals(1, check, 0.0);

        input = "!\"$%&/()=?-.,:;'#*+~|";
        //33 + 34 + 36 + 37 + 38 + 47 + 40 +41 + 61 + 63 + 45 + 46 + 44 + 58 + 59 + 39 + 35 + 42 + 43 + 126 + 124
        check = sc.checksum(input);
        assertEquals(2 , check, 0.0);
    }

    @Test
    public void testAlternatingCrossTotal() throws Exception {
        AlternatingCrossTotal ac = new AlternatingCrossTotal();
        String input = "Hallo Welt!";
        int check = ac.checksum(input);
        assertEquals(7, check, 0.0);

        input = "!\"$%&/()=?-.,:;'#*+~|";
        //33 + 34 + 36 + 37 + 38 + 47 + 40 +41 + 61 + 63 + 45 + 46 + 44 + 58 + 59 + 39 + 35 + 42 + 43 + 126 + 124
        check = ac.checksum(input);
        assertEquals(-14 , check, 0.0);

        input = "!\"$%&/()=?-.,:;'#*+~\t|";
        //33 + 34 + 36 + 37 + 38 + 47 + 40 +41 + 61 + 63 + 45 + 46 + 44 + 58 + 59 + 39 + 35 + 42 + 43 + 126 + 9 + 124
        check = ac.checksum(input);
        assertEquals(-17 , check, 0.0);
    }
}