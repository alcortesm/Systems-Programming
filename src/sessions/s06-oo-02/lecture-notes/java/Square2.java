class Square2 {

    private double side;

    public Square2(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException(
                    "ERROR: negative dimensions not allowed");
        }
        this.side = side;
    }

    public double area() {
        return this.side * this.side;
    }

    public String toString() {
        return "Square( " + this.side + ")";
    }
}
