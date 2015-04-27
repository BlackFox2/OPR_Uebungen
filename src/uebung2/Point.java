package uebung2;

/**
 * Created by @author
 */
public class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    double distance(Point p) {
        return Math.hypot(this.x - p.getX(), this.y - p.getY());
    }

    boolean isSame(Point p, double within) {
        if(this.x > p.getX()+within || this.x < p.getX()-within) {
            return false;
        }
        if(this.y > p.getY()+within || this.y < p.getY()-within) {
            return false;
        }
        return true;
    }

    Point moved(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }
}
