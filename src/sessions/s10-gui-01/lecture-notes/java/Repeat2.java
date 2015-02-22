import java.util.ArrayList;

class Repeat2 {
    static Person alberto = new Person("Alberto", 25);
    static ArrayList<Person> bag = new ArrayList<Person>();

    private static void repeat(Runnable r, int n) {
        for (int i=0; i<n; i++) {
            r.run();
        }
    }

    static class PrintFunctor implements Runnable {
        public void run() {
            System.out.println("hello");
        }
    }

    static class AddOneYearFunctor implements Runnable {
        public void run() {
            alberto.addOneYear();
        }
    }

    static class AddAlbertoToBagFunctor implements Runnable {
        public void run() {
            bag.add(alberto);
        }
    }

    public static void main(String[] args) {
        // prints "hello" 5 Times();
        repeat(new PrintFunctor(), 5);

        // adds 10 years to Alberto
        repeat(new AddOneYearFunctor(), 10);
        System.out.println(alberto);

        // adds alberto to the bag 10 times
        repeat(new AddAlbertoToBagFunctor(), 3);
        System.out.println(bag.size());
    }
}
