import java.util.ArrayList;

class Repeat3 {
    static Person alberto = new Person("Alberto", 25);
    static ArrayList<Person> bag = new ArrayList<Person>();

    private static void repeat(Runnable r, int n) {
        for (int i=0; i<n; i++) {
            r.run();
        }
    }

    public static void main(String[] args) {
        // prints "hello" 5 Times();
        repeat(new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        }, 5);

        // adds 10 years to Alberto
        repeat(new Runnable() {
            public void run() {
                alberto.addOneYear();
            }
        }, 10);
        System.out.println(alberto);

        // adds alberto to a bag 3 times
        repeat(new Runnable() {
            public void run() {
                bag.add(alberto);
            }
        }, 3);
        System.out.println(bag.size());
    }
}
