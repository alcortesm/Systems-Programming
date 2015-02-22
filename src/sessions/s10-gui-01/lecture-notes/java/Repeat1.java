import java.util.ArrayList;

class Repeat1 {
    static Person alberto = new Person("Alberto", 25);
    static ArrayList<Person> bag = new ArrayList<Person>();

    public static void main(String[] args) {
        // prints "hello" 5 Times();
        repeatHello5Times();

        // adds 10 years to Alberto
        repeatAddOneYearToAlberto10Times();
        System.out.println(alberto);

        // adds alberto to the bag 3 times
        repeatAddAlbertoToBag3Times();
        System.out.println(bag.size());
    }

    private static void repeatHello5Times() {
        for (int i=0; i<5; i++) {
            System.out.println("hello");
        }
    }

    private static void repeatAddOneYearToAlberto10Times() {
        for (int i=0; i<10; i++) {
            alberto.addOneYear();
        }
    }

    private static void repeatAddAlbertoToBag3Times() {
        for (int i=0; i<3; i++) {
            bag.add(alberto);
        }
    }
}
