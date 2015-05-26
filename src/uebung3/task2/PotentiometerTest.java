package uebung3.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This testfile tests the functionality of class Potentiometer.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class PotentiometerTest {

    /**
     * Test if the setOhm() function is working properly.
     * @throws Exception
     */
    @Test
    public void testSetOhm() throws Exception {
        double max = 100;
        Potentiometer p = new Potentiometer(max);
        p.setOhm(10);
        assertEquals(10, p.getOhm(), 0.0);
        p.setOhm(-20);
        assertEquals(0.0, p.getOhm(), 0.0);
        p.setOhm(4999);
        assertEquals(max, p.getOhm(), 0.0);

        max = -100;
        p = new Potentiometer(max);
        p.setOhm(40);
        assertEquals(0.0, p.getOhm(), 0.0);
    }

    /**
     * Should always return 1.
     * @throws Exception
     */
    @Test
    public void testNumberOfResistors() throws Exception {
        Potentiometer p = new Potentiometer(10);
        assertEquals(1, p.numberOfResistors(), 0.0);
    }
}