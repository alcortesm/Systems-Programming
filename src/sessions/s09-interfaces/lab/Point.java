public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the string representation of the point.
     *
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns the distance to the origin.
     *
     */
    public double distance() {
        Point origin = new Point(0.0, 0.0);
        return distance(origin);
    }

    /**
     * Returns the x coordinate of the point.
     *
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the point.
     *
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the distance to another point.
     *
     */
    public double distance(Point anotherPoint) {
        return Math.sqrt(Math.pow(x - anotherPoint.getX(), 2) +
                         Math.pow(y - anotherPoint.getY(), 2));
    }

    /**
     * Returns the quadrant in which the point is.
     *
     */
    public int quadrant() {
        if (x > 0.0 && y > 0.0) {
            return 1;
        } else if (x < 0.0 && y > 0.0) {
            return 2;
        } else if (x < 0.0 && y < 0.0) {
            return 3;
        } else if (x > 0.0 && y < 0.0) {
            return 4;
        } else {
            // (x==0.0 || y==0.0)
            return 0;
        }
    }

    /**
     * Returns the nearest point of the array in the parameter, or
     * null if array is empty.
     *
     */
    public Point nearest(Point[] otherPoints) {
        Point nearestPoint = null;
        double minDistance = Double.MAX_VALUE;
        double currentDistance;

        for (int i=0; i<otherPoints.length; i++) {
            currentDistance = this.distance(otherPoints[i]);
            if (currentDistance <= minDistance) {
                minDistance = currentDistance;
                nearestPoint = otherPoints[i];
            }
        }
        return nearestPoint;
    }
}
