import java.awt.Color;

class Circle extends GraphicalShape {
    private double radius;

    public Circle(double radius, Point center, Color color) {
        super(center, color);
        if (radius <= 0D) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    public String toString() {
        return "Circle(radius=" + this.radius +
            ", center=" + this.getCenter() +
            ", color=" + this.getColor() +
            ")";
    }
}
