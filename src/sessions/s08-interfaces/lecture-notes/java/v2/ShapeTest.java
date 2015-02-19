import java.util.ArrayList;
import java.awt.Color;

class ShapeTest {

    private static Shape biggest(ArrayList<Shape> inputs) {
        if (inputs == null) {
            throw new IllegalArgumentException();
        }
        if (inputs.size() == 0) {
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
        bag.add(new Rectangle(1D, 4D, new Point(0D, 0D), Color.RED));
        bag.add(new Square(3D, new Point(3D, 4D), Color.BLUE));
        bag.add(new Circle(10D, new Point(5D, 3D), Color.GREEN));
        bag.add(new Triangle(2D, 3D, new Point(2D, 4D), Color.BLACK));
        Shape biggest = biggest(bag);
        System.out.println(biggest);
    }
}
