import java.util.NoSuchElementException;

class PrimesTui {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("ERROR: this program need one argument");
            return;
        }
        try {
            PrimeGenerator pg = new PrimeGenerator(Integer.parseInt(args[0]));
            while(true) {
                System.out.println(pg.next());
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Finished!");
        } catch (InterruptedException ex) {
            System.err.println("ERROR: Interrupted!");
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: Bad argument: it must be an integer");
        } catch (IllegalArgumentException ex) {
            System.err.println("ERROR: Bad argument: the number must be greater than 1");
        }
    }
}
