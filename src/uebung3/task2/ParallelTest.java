package uebung3.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This testfile tests the functionality of class Parallel.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class ParallelTest {

    @Test
    public void testGetOhm() throws Exception {
        Resistor r = new Resistor(50);
        Resistor r1 = new Resistor(25);
        Parallel p = new Parallel(r, r1);
        assertEquals(16.666666666, p.getOhm(), 0.00000001);

        r = new Resistor(-4939);
        r1 = new Resistor(-30949);
        p = new Parallel(r, r1);
        assertEquals(0, p.getOhm(), 0.0);

        // when one resistor is 0 all the current flows over this part of the circuit, so the resistance circuit's
        // resistance is also 0
        r = new Resistor(-394983);
        r1 = new Resistor(58);
        p = new Parallel(r, r1);
        assertEquals(0.0, p.getOhm(), 0.0);
    }
}