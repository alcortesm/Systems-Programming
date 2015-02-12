class Rectangle5 {

    protected double width;
    protected double height;

    public Rectangle5(double width, double height) {
        if (width == 0 || height == 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle5(double side) { this(side, side); }

    public double area() { return this.width * this.height; }

    public String toString() {
        return "Rectangle(" + this.width + ", "
            + this.height + ")";
    }
}
