class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        if (width <= 0D || height <= 0D) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side) {
        this(side, side);
    }

    public double area() {
        return this.width * this.height;
    }

    public String toString() {
        return "Rectangle(" + this.width + ", " + this.height + ")";
    }
}
