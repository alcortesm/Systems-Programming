class Circle2 {
    private double radius;

    Circle2(double radius) {
        if (radius <= 0D) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public int compareTo(Circle2 other) {
        if (this.radius > other.radius) {
            return 1;
        } else if (this.radius < other.radius) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String args[]) {
        Circle2 a = new Circle2(2D);
        Circle2 b = new Circle2(3D);
        Circle2 c = new Circle2(2D);
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("a.compareTo(c) = " + a.compareTo(c));
        System.out.println("b.compareTo(a) = " + b.compareTo(a));
        System.out.println("c.compareTo(c) = " + c.compareTo(c));
    }
}
