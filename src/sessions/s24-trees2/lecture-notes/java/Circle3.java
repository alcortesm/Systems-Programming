class Circle3 implements Comparable<Circle3> {

    private double radius;

    Circle3(double radius) {
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

    public int compareTo(Circle3 other) {
        if (this.radius > other.radius) {
            return 1;
        } else if (this.radius < other.radius) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String args[]) {
        Circle3 a = new Circle3(2D);
        Circle3 b = new Circle3(3D);
        Circle3 c = new Circle3(2D);
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("a.compareTo(c) = " + a.compareTo(c));
        System.out.println("b.compareTo(a) = " + b.compareTo(a));
        System.out.println("c.compareTo(c) = " + c.compareTo(c));
    }
}
