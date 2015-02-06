class AreaOfCircle2 {
    public static void main(String args[]) {
        double radius = Double.parseDouble(args[0]);
        Circle circle = new Circle(radius);
        double area = circle.area();
        System.out.println(area);
    }
}
