class Rectangle1 {
    public double width;
    public double height;

    public Rectangle1(double width, double height) throws Exception {
        if (width <= 0 || height <= 0) {
            throw new Exception("ERROR: Dimensions must be > 0");
        }
        this.width = width;
        this.height = height;
    }

    // answer to exercise 1.C
    public String toString() {
        return "Rectangle: width = " + width + " and height = "
            + height;
    }
}
