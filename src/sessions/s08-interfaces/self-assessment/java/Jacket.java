import java.awt.Color;

class Jacket extends Garment {
    private static final int PRICE = 10;

    public Jacket(Color color) {
        super(color);
    }

    public String toString() {
        return "Jacket(color=" + getColor() +
           ", price=" + getPrice() +
           ")";
    }

    public int getPrice() {
        return PRICE;
    }

    public static void main(String[] args) {
        Jacket myJacket = new Jacket(Color.RED);
        System.out.println(myJacket);
    }
}
