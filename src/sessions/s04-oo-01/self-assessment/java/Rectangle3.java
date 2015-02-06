class Rectangle3 {
    private double width;
    private double height;

    public Rectangle3(double width, double height) throws Exception {
        if (width <= 0 || height <= 0) {
            throw new Exception("ERROR: Dimensions must be > 0");
        }
        this.width = width;
        this.height = height;
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
