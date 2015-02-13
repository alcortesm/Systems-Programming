class Square1 {

    private double side;

    public Square1(double side) {
        if (side <= 0) {
            // this is just like an ordinary exception
            // but especiallized for signaling illegal
            // input arguments to your methods
            // In adition, you don't have to declare
            // in your method that you are throwing this
            // type of exception.
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
