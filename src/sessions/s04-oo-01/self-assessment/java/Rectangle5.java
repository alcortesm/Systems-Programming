class Rectangle5 {
    private double width;
    private double height;

    public Rectangle5(double width, double height) throws Exception {
        setWidth(width);
        setHeight(height);
    }

    public Rectangle5(double side) throws Exception {
        this(side, side);
    }

    public Rectangle5() throws Exception {
        this(1D);
    }

    public Rectangle5(Rectangle5 other) throw Exception {
        this(other.width, other.height);
    }

    public void setWidth(double width) throws Exception {
        if (width <= 0) {
            throw new Exception("ERROR: width must be > 0");
        }
        this.width = width;
    }

    public void setHeight(double height) throws Exception {
        if (height <= 0) {
            throw new Exception("ERROR: height must be > 0");
        }
        this.height = height;
    }

    public String toString() {
        return "Rectangle with width = " + width + " and height = "
            + height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2*width + 2*height;
    }

    public double invert() throws Exception {
        setWidth(height);
        setHeight(width);
    }

    public double equals(Rectangle5 other) {
        return (this.width == other.width) &&
                (this.height == other.height);
    }
}
