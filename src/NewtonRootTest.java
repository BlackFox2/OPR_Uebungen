import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitTest for testing the NewtonRoot class and it's functionality.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class NewtonRootTest {

    /**
     * Checks the squareRoot function from NewtonRoot class with different inputs.
     * @throws Exception
     */
    @Test
    public void testSquareRoot() throws Exception {
        double n = 49;
        double result;
        NewtonRoot nR = new NewtonRoot();
        result = nR.squareRoot(n);
        assertEquals(Math.sqrt(n), result, 0.000001);

        n = 0.5;
        result = nR.squareRoot(n);
        assertEquals(Math.sqrt(n), result, 0.000001);

        n = 0.1;
        result = nR.squareRoot(n);
        assertEquals(Math.sqrt(n), result, 0.000001);

        n = 0.0005;
        result = nR.squareRoot(n);
        assertEquals(Math.sqrt(n), result, 0.000001);

    }

    /**
     * Checks the cubicRoot function from NewtonRoot class with different inputs.
     * @throws Exception
     */
    @Test
    public void testCubicRoot() throws Exception {
        double n = 34;
        double result;
        NewtonRoot nR = new NewtonRoot();
        result = nR.cubicRoot(n);
        assertEquals(Math.cbrt(n),result, 0.000001);

        n = 0.5;
        result = nR.cubicRoot(n);
        assertEquals(Math.cbrt(n), result, 0.000001);

        n = 0.1;
        result = nR.cubicRoot(n);
        assertEquals(Math.cbrt(n), result, 0.000001);

        n = 0.0005;
        result = nR.cubicRoot(n);
        assertEquals(Math.cbrt(n), result, 0.000001);
    }
}