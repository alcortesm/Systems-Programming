import java.awt.Color;

class Pants extends Garment {
    private boolean isSmall;
    private static final int BASE_PRICE = 7;
    private static final Color COLOR = Color.BLACK;
    public static final boolean SMALL = true;
    public static final boolean BIG = false;

    public Pants(boolean isSmall) {
        super(COLOR);
        this.isSmall = isSmall;
    }

    public int getPrice() {
        if (isSmall) {
            return BASE_PRICE;
        } else {
            return 2*BASE_PRICE;
        }
    }

    public String toString() {
        String size = (isSmall) ? "small" : "big";
        return "Pants(color=" + this.getColor() +
            ", size=" + size +
            ", price=" + getPrice() +
            ")";
    }

    public static void main(String[] args) {
        Pants p1 = new Pants(true);
        Pants p2 = new Pants(false);
        System.out.println(p1);
        System.out.println(p2);
    }
}
