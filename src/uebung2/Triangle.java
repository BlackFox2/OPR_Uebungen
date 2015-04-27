package uebung2;

/**
 * Created by @author
 */
public class Triangle {
    Point[] points = new Point[3];

    Triangle(Point a, Point b, Point c) {
        points[0] = a;
        points[1] = b;
        points[3] = c;
    }

    double perimeter() {
        double peri = 0.0;
        peri += points[0].distance(points[1]);
        peri += points[1].distance(points[2]);
        peri += points[2].distance(points[0]);
        return peri;
    }

    double area() {
        double[] sides = new double[3];
        sides[0] = points[0].distance(points[1]);
        sides[1] = points[1].distance(points[2]);
        sides[2] = points[2].distance(points[0]);
        double s = (sides[0] + sides[1] + sides[2])/2;
        return Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
    }

    boolean isSame(Triangle t, double within) {
        if(points[0].isSame(t.points[0], within) || points[0].isSame(t.points[1], within) || points[0].isSame(points[2], within)) {
            return false;
        }
        if(points[1].isSame(t.points[0], within) || points[0].isSame(t.points[1], within) || points[0].isSame(points[2], within)) {
            return false;
        }
        if(points[2].isSame(t.points[0], within) || points[0].isSame(t.points[1], within) || points[0].isSame(points[2], within)) {
            return false;
        }
        return true;
    }

    Triangle moved(double dx, double dy) {
        return new Triangle(points[0].moved(dx, dy), points[1].moved(dx, dy), points[2].moved(dx, dy));
    }

    Triangle zoomed(double f) {
        Point a = new Point(points[0].getX()*f, points[0].getY()*f);
        Point b = new Point(points[1].getX()*f, points[1].getY()*f);
        Point c = new Point(points[2].getX()*f, points[2].getY()*f);
        return new Triangle(a, b, c);
    }



}
