public abstract class Shape {

    // Name of the shape
    private String name;

    // Constructor of the shape with a name
    public Shape(String name) {

    }

    // Calculates the area of a shape
    abstract public double area();

    // Indicates if the shape is regular or not
    abstract public boolean isRegular();

    // Gets the name of the shape
    protected String getName(){

    }

    // Sets the name of the shape
    protected void setName(String name){

    }

}
