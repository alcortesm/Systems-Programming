import java.awt.Color;

class Rectangle extends GraphicalShape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height, Point center, Color color) {
        super(center, color);
        if (width <= 0D || height <= 0D) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side, Point center, Color color) {
        this(side, side, center, color);
    }

    public double area() {
        return this.width * this.height;
    }

    public String toString() {
        return "Rectangle(width=" + this.width +
            ", height=" + this.height +
            ", center=" + this.getCenter() +
            ", color=" + this.getColor() +
            ")";
    }
}
