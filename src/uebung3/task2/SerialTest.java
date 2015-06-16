package uebung3.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This testfile tests the functionality of class Serial.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class SerialTest {

    /**
     * Test the getOhm() function for serial circuits.
     *
     * @throws Exception
     */
    @Test
    public void testGetOhm() throws Exception {
        Resistor r = new Resistor(25);
        Resistor r1 = new Resistor(30);
        Serial s = new Serial(r, r1);
        assertEquals(55, s.getOhm(), 0.0);

        r = new Resistor(-2384);
        r1 = new Resistor(-39494);
        s = new Serial(r, r1);
        assertEquals(0.0, s.getOhm(), 0.0);

        r = new Resistor(-9483);
        r1 = new Resistor(50);
        s = new Serial(r, r1);
        assertEquals(50.0, s.getOhm(), 0.0);
    }
}