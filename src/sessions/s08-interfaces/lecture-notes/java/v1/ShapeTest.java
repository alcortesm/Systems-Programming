import java.util.ArrayList;

class ShapeTest {

    private static Shape biggest(ArrayList<Shape> inputs) {
        if (inputs == null || inputs.size() == 0) {
            throw new IllegalArgumentException();
        }
        Shape biggest = inputs.get(0);
        for (int i=1; i<inputs.size(); i++) {
            if (inputs.get(i).area() > biggest.area()) {
                biggest = inputs.get(i);
            }
        }
        return biggest;

    }

    public static void main(String args[]) {
        ArrayList<Shape> bag = new ArrayList<Shape>();
        bag.add(new Rectangle(1D, 4D));
        bag.add(new Square(3D));
        bag.add(new Circle(1D));
        bag.add(new Triangle(2D, 3D));
        Shape biggest = biggest(bag);
        System.out.println(biggest);
    }
}
