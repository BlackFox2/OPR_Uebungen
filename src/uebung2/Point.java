package uebung2;

/**
 * Point objects have x and y coordinates.
 * The class provides methods to calculate the distance between two points and a check with two points are the same
 * within a delta.
 * Provides functionality to create a new Point from an existing one with given deviation.
 *
 * @author Markus Marihart
 * @version 1.0
 */
public class Point {
    double x;
    double y;

    /**
     * Constructor. Simply sets the variables
     * @param x     x coordinate
     * @param y     y coordinate
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate from the point.
     * @return  x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate from the point.
     * @return  y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the distance between the 2 points
     * @param p Point to calculate distance
     * @return  distance on success
     *          0.0 on failure
     */
    double distance(Point p) {
        if(p == null) {
            return 0.0;
        }
        return Math.hypot(this.x - p.getX(), this.y - p.getY());
    }

    /**
     * Returns whether or not two points are the same within a given range regarding their x and y coordinates.
     * @param p         Point object to compare with
     * @param within    delta
     * @return          true if points have the same x and y coordinates within the delta
     *                  else false
     */
    boolean isSame(Point p, double within) {
        if(this.x > p.getX()+within || this.x < p.getX()-within) {
            return false;
        }
        if(this.y > p.getY()+within || this.y < p.getY()-within) {
            return false;
        }
        return true;
    }

    /**
     * Returns a new Point object. The coordinates of the new object are altered according to the given values.
     * @param x     value to change x coordinate
     * @param y     value to change y coordinate
     * @return      Point object on success
     *              null on failure
     */
    Point moved(Double x, Double y) {
        if(x == null || y == null ) {
            return null;
        }
        return new Point(this.x + x, this.y + y);
    }
}
