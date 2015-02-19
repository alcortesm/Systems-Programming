import java.util.ArrayList;

class Warehouse {
    private ArrayList<Garment> storage;

    public Warehouse() {
        storage = new ArrayList<Garment>();
    }

    public void add(Garment g) {
        storage.add(g);
    }

    private String items() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<storage.size(); i++) {
            sb.append(storage.get(i));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private int total_price() {
        int total = 0;
        for (int i=0; i<storage.size(); i++) {
            total += storage.get(i).getPrice();
        }
        return total;
    }

    public String toString() {
        return items() + "Total price = " + total_price();
    }
}
