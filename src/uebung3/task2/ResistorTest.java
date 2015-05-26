package uebung3.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This testfile tests the functionality of class Resistor.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class ResistorTest {

    /**
     * Tests the getOhm() funtion.
     * @throws Exception
     */
    @Test
    public void testGetOhm() throws Exception {
        Resistor r = new Resistor(10.0);
        assertEquals(10.0, r.getOhm(), 0.0);
        //no values below zero allowed
        r = new Resistor(-5);
        assertEquals(0.0, r.getOhm(), 0.0);
        r = new Resistor(45.405984);
        assertEquals(45.405984, r.getOhm(), 0.0);
    }

    /**
     * Should always return 1
     * @throws Exception
     */
    @Test
    public void testNumberOfResistors() throws Exception {
        Resistor r = new Resistor(34.7);
        assertEquals(1, r.numberOfResistors(), 0.0);
    }
}