package uebung3.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests more complex circuits and checks whether or not the functionality still works.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class CompoundCircuitTest {

    /**
     * Short test whether or not the function works
     *
     * @throws Exception
     */
    @Test
    public void testNumberOfResistors() throws Exception {
        Resistor r = new Resistor(10);
        Resistor r1 = new Resistor(100);
        CompoundCircuit cc = new Serial(r, r1);
        assertEquals(2, cc.numberOfResistors(), 0.0);
    }

    /**
     * Tests more complex circuits. The circuits are given in the paper.
     *
     * @throws Exception
     */
    @Test
    public void testComplexCircuits() throws Exception {
        //test the 1st example circuit
        Resistor r1 = new Resistor(100);
        Resistor r2 = new Resistor(300);
        Parallel p1 = new Parallel(r1, r2);

        Resistor r3 = new Resistor(200);
        Serial s1 = new Serial(p1, r3);

        Resistor r4 = new Resistor(400);
        Resistor r5 = new Resistor(500);
        Serial s2 = new Serial(r4, r5);

        Parallel p2 = new Parallel(s1, s2);

        Resistor r6 = new Resistor(600);

        Parallel p3 = new Parallel(p2, r6);

        assertEquals(155.905512, p3.getOhm(), 0.000001);

        //test the 2nd example circuit
        r1 = new Resistor(100);
        r2 = new Resistor(200);
        p1 = new Parallel(r1, r2);

        r3 = new Resistor(300);
        r4 = new Resistor(400);
        p2 = new Parallel(r3, r4);

        s1 = new Serial(p1, p2);
        assertEquals(238.095238, s1.getOhm(), 0.000001);


        //test the 3rd example circuit
        r1 = new Resistor(100);
        r2 = new Resistor(200);
        s1 = new Serial(r1, r2);

        r3 = new Resistor(300);
        r4 = new Resistor(400);
        s2 = new Serial(r3, r4);

        p1 = new Parallel(s1, s2);
        assertEquals(209.999999, p1.getOhm(), 0.000001);
    }
}