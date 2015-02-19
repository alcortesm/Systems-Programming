import java.awt.Color;

class WarehouseTest {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.add(new Jacket(Color.RED));
        warehouse.add(new Jacket(Color.GREEN));
        warehouse.add(new Pants(Pants.SMALL));
        warehouse.add(new Pants(Pants.BIG));
        System.out.println(warehouse);
    }
}
