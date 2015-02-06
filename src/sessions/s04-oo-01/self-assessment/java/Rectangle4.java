class Rectangle4 {
    private double width;
    private double height;

    public Rectangle4(double width, double height) throws Exception {
        setWidth(width);
        setHeight(height);
    }

    public Rectangle4(double side) throws Exception {
        this(side, side);
    }

    public Rectangle4() throws Exception {
        this(1D);
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
}
