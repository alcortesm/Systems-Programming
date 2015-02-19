class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        if (base <= 0D || height <= 0D) {
            throw new IllegalArgumentException();
        }
        this.base = base;
        this.height = height;
    }

    public double area() {
        return this.base * this.height * 0.5D;
    }

    public String toString() {
        return "Triangle(" + this.base + ", " + this.height + ")";
    }
}
