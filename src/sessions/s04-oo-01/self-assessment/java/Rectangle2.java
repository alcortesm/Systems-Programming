class Rectangle2 {
    private double width;
    private double height;

    public Rectangle2(double width, double height) throws Exception {
        if (width <= 0 || height <= 0) {
            throw new Exception("ERROR: Dimensions must be > 0");
        }
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return "Rectangle: width = " + width + " and height = "
            + height;
    }
}
