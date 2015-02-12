class Square4 extends Rectangle1 {
    // private double width;
    // private double height;
    // public double area() { ... }
    // public double getWidth() {...}

    // Constructors are not inherited
    // We build the SUPERclass part first
    // then the SUBclass part (in this case nothing)
    public Square4(double side) {
        super(side);
    }

    // This is called OVERRIDING a method.
    public String toString() {
        return "Square(" + this.getWidth() + ")";
    }
}

