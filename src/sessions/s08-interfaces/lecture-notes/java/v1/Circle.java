class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0D) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    public String toString() {
        return "Circle(" + this.radius + ")";
    }
}
