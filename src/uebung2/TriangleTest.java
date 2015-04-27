package uebung2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by @author
 */
public class TriangleTest {

    @Test
    public void testPerimeter() throws Exception {
        Triangle t = new Triangle(new Point(1,1), new Point(3,1), new Point(3,2));
        double res = t.perimeter();
        assertEquals(5.2360679775, res, 0.0000000001);


    }

    @Test
    public void testArea() throws Exception {
        Triangle t = new Triangle(new Point(1,1), new Point(3,1), new Point(3,2));
        double res = t.area();
        assertEquals(1.0 , res, 0.0);

    }

    @Test
    public void testIsSame() throws Exception {
        Triangle t = new Triangle(new Point(1,1), new Point(3,1), new Point(3,2));
        Triangle t1 = new Triangle(new Point(2,2), new Point(4,2), new Point(4,3));
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

        t1 = new Triangle(new Point(4,3), new Point(2,2), new Point(4,2));
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

    @Test
    public void testMoved() throws Exception {
        Triangle t = new Triangle(new Point(1,1), new Point(3,1), new Point(3,2));
        double movedX = 10;
        double movedY = 10;
        Triangle t1 = t.moved(movedX, movedY);
        //TODO finish this test and testZoomed
    }

    @Test
    public void testZoomed() throws Exception {

    }
}