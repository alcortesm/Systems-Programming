import java.util.NoSuchElementException;

class PrimesTui {
    private static final int MAX = 100;

    public static void main(String args[]) {
        PrimeGenerator pg = new PrimeGenerator(MAX);
        try {
            while(true) {
                System.out.println(pg.next());
            }
        } catch (NoSuchElementException ex) {
        } catch (InterruptedException ex) {
            System.err.println("Interrupted!");
        }
    }
}
