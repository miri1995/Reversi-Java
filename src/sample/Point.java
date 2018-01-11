package sample;

public class Point {
    private double x;
    private double y;

    /**
     * @param x = the value x of the point.
     * @param y = the value y of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the value of x.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the value of y.
     */
    public double getY() {
        return this.y;
    }


    /**
     * @param other another point.
     * @return distance between 2 points.
     */
    double distanceTo(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));

    }

    /**
     * @param other = another point.
     * @return true if the 2 points are equal and false if not.
     */

    public boolean equals(Point other) {
        Point p1 = new Point(this.x, this.y);
        Point p2 = new Point(other.getX(), other.getY());
        return (this.x == other.x && this.y == other.y);
    }
}
