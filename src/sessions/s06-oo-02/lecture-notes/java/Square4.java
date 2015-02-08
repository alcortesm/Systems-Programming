class Square4 extends Rectangle1 {

    // attributes are inherited from the super class
    // but we can not access them because they are private:
    //   width
    //   height

    // constructors are not inherited
    public Square4(double side) {
        super(side);
    }

    // all methods are inherited, no need to redefine:
    //   area()
    //   getWidth()
    //   getHeight()

    // We also inherited toString(), but we want our own version
    // so it writes "Square..." instead of "Rectangle(...".
    // This is called OVERRIDING a method.
    public String toString() {
        return "Square(" + this.getWidth() + ")";
    }
}

