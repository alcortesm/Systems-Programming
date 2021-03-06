class Circle1 {

    private double radius;

    Circle1(double radius) {
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
}
