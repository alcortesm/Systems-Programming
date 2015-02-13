class Rectangle1 {

    private double width;
    private double height;

    public Rectangle1(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle1(double side) { this(side, side); }

    public double area() { return this.width * this.height; }

    public String toString() {
        return "Rectangle(" + this.width + ", "
            + this.height + ")";
    }

    public double getWidth() { return this.width; }
}
