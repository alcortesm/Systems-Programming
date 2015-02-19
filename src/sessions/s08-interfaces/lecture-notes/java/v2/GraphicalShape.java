import java.awt.Color;

abstract class GraphicalShape extends Shape {

    private Point center;
    private Color color;

    protected GraphicalShape(Point center, Color color) {
        setCenter(center);
        setColor(color);
    }

    public Point getCenter() {
        return this.center;
    }

    public Color getColor() {
        return this.color;
    }

    public void setCenter(Point center) {
        if (center == null) {
            throw new IllegalArgumentException();
        }
        this.center = center;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
    }
}
