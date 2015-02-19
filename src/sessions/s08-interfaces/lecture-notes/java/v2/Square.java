import java.awt.Color;

class Square extends Rectangle {
    public Square(double side, Point center, Color color) {
        super(side, center, color);
    }

    public String toString() {
        return "Square(side=" + this.width +
            ", center=" + this.getCenter() +
            ", color=" + this.getColor() +
            ")";
    }
}
