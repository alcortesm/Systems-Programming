class Square3 {

    private Rectangle1 rect;

    public Square3(double side) {
        this.rect = new Rectangle1(side);
    }

    public double area() { return this.rect.area(); }

    public Rectangle1 getRectangle() { return rect; }

    public String toString() {
        return "Square( " + this.rect.getWidth() + ")";
    }
}
