package uebung2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnitTest for testing the uebung2.Triangle class and it's functionality
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class TriangleTest {

    /**
     * Test the perimeter method
     *
     * @throws Exception
     */
    @Test
    public void testPerimeter() throws Exception {
        Triangle t = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 2));
        double res = t.perimeter();
        assertEquals(5.2360679775, res, 0.0000000001);


    }

    /**
     * Test the area method
     *
     * @throws Exception
     */
    @Test
    public void testArea() throws Exception {
        Triangle t = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 2));
        double res = t.area();
        assertEquals(1.0, res, 0.0);

    }

    /**
     * Test the isSame method
     *
     * @throws Exception
     */
    @Test
    public void testIsSame() throws Exception {
        Triangle t = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 2));
        Triangle t1 = new Triangle(new Point(2, 2), new Point(4, 2), new Point(4, 3));
        double within = 1.0;
        boolean res = t.isSame(t1, within);
        assertTrue(res);
        res = t1.isSame(t, within);
        assertTrue(res);

        within = 0.5;
        res = t.isSame(t1, within);
        assertFalse(res);
        res = t1.isSame(t, within);
        assertFalse(res);

        t1 = new Triangle(new Point(4, 3), new Point(2, 2), new Point(4, 2));
        within = 1.0;
        res = t.isSame(t1, within);
        assertTrue(res);
        res = t1.isSame(t, within);
        assertTrue(res);

        within = 0.754;
        res = t.isSame(t1, within);
        assertFalse(res);
        res = t1.isSame(t, within);
        assertFalse(res);

    }

    /**
     * Test the moved method
     *
     * @throws Exception
     */
    @Test
    public void testMoved() throws Exception {
        Triangle t = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 2));
        double movedX = 10;
        double movedY = 10;
        Triangle t1 = t.moved(movedX, movedY);

        for (int i = 0; i < t.points.length; i++) {
            assertEquals(t.points[i].getX() + movedX, t1.points[i].getX(), 0.0);
            assertEquals(t.points[i].getY() + movedY, t1.points[i].getY(), 0.0);
        }

        movedX = -5;
        movedY = -39.6;
        t1 = t.moved(movedX, movedY);

        for (int i = 0; i < t.points.length; i++) {
            assertEquals(t.points[i].getX() + movedX, t1.points[i].getX(), 0.0);
            assertEquals(t.points[i].getY() + movedY, t1.points[i].getY(), 0.0);
        }

        movedX = 0.0;
        movedY = 0.0;
        t1 = t.moved(movedX, movedY);

        for (int i = 0; i < t.points.length; i++) {
            assertEquals(t.points[i].getX() + movedX, t1.points[i].getX(), 0.0);
            assertEquals(t.points[i].getY() + movedY, t1.points[i].getY(), 0.0);
        }
    }

    /**
     * Test the zoomed method
     *
     * @throws Exception
     */
    @Test
    public void testZoomed() throws Exception {
        Triangle t = new Triangle(new Point(1, 1), new Point(3, 1), new Point(3, 2));
        double f = 3.0;
        Triangle t1 = t.zoomed(f);
        Point center = new Point(0, 0);

        double[] distancesOrig = new double[3];
        distancesOrig[0] = t.points[0].distance(center);
        distancesOrig[1] = t.points[1].distance(center);
        distancesOrig[2] = t.points[2].distance(center);

        double[] distancesZoom = new double[3];
        distancesZoom[0] = t1.points[0].distance(center);
        distancesZoom[1] = t1.points[1].distance(center);
        distancesZoom[2] = t1.points[2].distance(center);

        assertEquals(distancesOrig[0] * Math.sqrt(f * f), distancesZoom[0], 0.000000000001);
        assertEquals(distancesOrig[1] * Math.sqrt(f * f), distancesZoom[1], 0.000000000001);
        assertEquals(distancesOrig[2] * Math.sqrt(f * f), distancesZoom[2], 0.000000000001);

        f = -0.5;
        t1 = t.zoomed(f);

        distancesZoom[0] = t1.points[0].distance(center);
        distancesZoom[1] = t1.points[1].distance(center);
        distancesZoom[2] = t1.points[2].distance(center);

        assertEquals(distancesOrig[0] * Math.sqrt(f * f), distancesZoom[0], 0.000000000001);
        assertEquals(distancesOrig[1] * Math.sqrt(f * f), distancesZoom[1], 0.000000000001);
        assertEquals(distancesOrig[2] * Math.sqrt(f * f), distancesZoom[2], 0.000000000001);

    }
}