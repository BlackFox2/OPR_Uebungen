package uebung2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitTest for testing the uebung2.Point class and it's functionality
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class PointTest {

    /**
     * Test the distance method
     * @throws Exception
     */
    @Test
    public void testDistance() throws Exception {
        Point p1 = new Point(2,2);
        Point p2 = new Point(3,3);
        Double res = p1.distance(p2);
        double res2 = p2.distance(p1);
        assertEquals(1.41421356237, res, 0.00000000001);
        assertEquals(res, res2, 0.0);

        p1 = new Point(1,1);
        p2 = new Point(100, 120);
        res = p1.distance(p2);
        res2 = p2.distance(p1);
        assertEquals(154.79664079, res, 0.00000001);
        assertEquals(res, res2, 0.0);

    }

    /**
     * Tests the isSame method
     * @throws Exception
     */
    @Test
    public void testIsSame() throws Exception {
        Point p1 = new Point(2,2);
        Point p2 = new Point(3,3);
        double within = 1.0;
        boolean res = p1.isSame(p2, within);
        assertTrue(res);
        within = 0.1;
        res = p1.isSame(p2, within);
        assertFalse(res);

        res = p2.isSame(p1, within);
        assertFalse(res);

        res = p2.isSame(p2, within);
        assertTrue(res);

    }

    /**
     * Tests the moved method
     * @throws Exception
     */
    @Test
    public void testMoved() throws Exception {
        Point p1 = new Point(2,2);
        double moveX = 10;
        double moveY = 10;
        Point p2 = p1.moved(moveX, moveY);

        assertEquals(p1.getX()+moveX, p2.getX(), 0.0);
        assertEquals(p1.getY()+moveY, p2.getY(), 0.0);

        moveX = -5;
        moveY = -12.57;
        p2 = p1.moved(moveX, moveY);

        assertEquals(p1.getX()+moveX, p2.getX(), 0.0);
        assertEquals(p1.getY()+moveY, p2.getY(), 0.0);

        assertNull(p1.moved(null, null));

    }
}