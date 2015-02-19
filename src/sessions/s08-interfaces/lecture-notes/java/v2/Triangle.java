import java.awt.Color;

class Triangle extends GraphicalShape {
    private double base;
    private double height;

    public Triangle(double base, double height, Point center, Color color) {
        super(center, color);
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
        return "Triangle(base=" + this.base +
            ", height=" + this.height +
            ", center=" + this.getCenter() +
            ", color=" + this.getColor() +
            ")";
    }
}
