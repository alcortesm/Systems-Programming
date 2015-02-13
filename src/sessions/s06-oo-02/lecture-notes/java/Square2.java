class Square2 {
    // this is called a "HAS-A" relationship
    // Points HAS two integers
    // Triangles HAS three points
    // Square3 HAS A rectangle1
    private Rectangle1 rect;

    public Square2(double side) {
        this.rect = new Rectangle1(side);
    }

    public Rectangle1 getRectangle() { return rect; }

    public String toString() {
        return "Square( " + this.rect.getWidth() + ")";
    }
}
