import java.awt.Color;

abstract class Garment {
    private Color color;

    private void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public Garment(Color color) {
        setColor(color);
    }

    public Color getColor() {
        return this.color;
    }

    public abstract int getPrice();
}
