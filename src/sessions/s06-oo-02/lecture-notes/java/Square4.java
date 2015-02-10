class Square4 extends Rectangle1 {
    // Rectangle is called the superclass
    // Square4 is called the subclass
    // DIBUJAR CONJUNTOS Y DIAGRAMA UML SIMPLE

    // attributes are inherited from the superclass so there is
    // no need to re-define them again:
    // double width;
    // double height;

    // all methods are also inherited, so there is no need to re-define them
    // again:
    //   public double area() { ... }
    //   public double getWidth() {...}
    //   public String toString() {...}

    // But this time we want our own version of toString()
    // so it writes "Square..." instead of "Rectangle(...".
    // This is called OVERRIDING a method.
    public String toString() {
        return "Square(" + this.getWidth() + ")";
    }
    // this method is shadowing the Rectangle.toString().

    // Constructors are not inherited
    public Square4(double side) {
        super(side);
    }

}

