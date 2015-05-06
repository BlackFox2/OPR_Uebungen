package uebung2;

/**
 * Triangle objects consist of three Point objects
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class Triangle {
    Point[] points = new Point[3];

    /**
     * Constructor puts the given Points into a array
     * @param a     First point of triangle
     * @param b     Second point of triangle
     * @param c     Third point of triangle
     */
    Triangle(Point a, Point b, Point c) {
        points[0] = a;
        points[1] = b;
        points[2] = c;
    }

    /**
     * Calculates the perimeter of the triangle
     * @return  perimeter of the triangle
     */
    double perimeter() {
        double peri = 0.0;
        peri += points[0].distance(points[1]);
        peri += points[1].distance(points[2]);
        peri += points[2].distance(points[0]);
        return peri;
    }

    /**
     * Calculates the area of the triangle
     * @return  area
     */
    double area() {
        double[] sides = new double[3];
        sides[0] = points[0].distance(points[1]);
        sides[1] = points[1].distance(points[2]);
        sides[2] = points[2].distance(points[0]);
        double s = (sides[0] + sides[1] + sides[2])/2;
        return Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
    }

    /**
     * Checks if the two Triangles are the same within a given delta
     * @return  true if they are the same
     *          else false
     */
    boolean isSame(Triangle t, double within) {
        if(!points[0].isSame(t.points[0], within)) {
            if (!points[0].isSame(t.points[1], within)) {
                if (!points[0].isSame(points[2], within)) {
                    return false;
                }
            }
        }
        if(!points[1].isSame(t.points[0], within)) {
            if (!points[0].isSame(t.points[1], within)) {
                if (!points[0].isSame(points[2], within)) {
                    return false;
                }
            }
        }
        if(!points[2].isSame(t.points[0], within)) {
            if (!points[0].isSame(t.points[1], within)) {
                if (!points[0].isSame(points[2], within)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns a new Triangle object which is moved by the given values
     * @param dx    movement in x direction
     * @param dy    movement in y direction
     * @return      new Triangle on success
     *              null on failure
     */
    Triangle moved(Double dx, Double dy) {
        if(dx == null || dy == null) {
            return null;
        }
        return new Triangle(points[0].moved(dx, dy), points[1].moved(dx, dy), points[2].moved(dx, dy));
    }

    /**
     * Creates a new Triangle object which is zoomed by the given factor.
     * Zooming means that the distance from every point to the origin is multiplied by the given factor.
     * @param f zoom factor (negative value mirrors the triangle at the origin)
     * @return  new Triangle on success
     *          null on failure
     */
    Triangle zoomed(Double f) {
        if(f == null) {
            return null;
        }
        Point a = new Point(points[0].getX()*f, points[0].getY()*f);
        Point b = new Point(points[1].getX()*f, points[1].getY()*f);
        Point c = new Point(points[2].getX()*f, points[2].getY()*f);
        return new Triangle(a, b, c);
    }



}
