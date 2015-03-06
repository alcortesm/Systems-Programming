import java.util.NoSuchElementException;

class PrimeGenerator {
    private int max;
    private int last;
    private static final int SLEEP_MS = 100;

    public PrimeGenerator(int max) {
        if (max <= 1) {
            throw new IllegalArgumentException();
        }
        this.max = max;
        this.last = 1; // first non prime minus 1.
    }

    private boolean isPrime(int n) {
        for (int div=2; (div*div)<=n; div++) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }

    public int next() throws NoSuchElementException, InterruptedException {
        for (int current=last+1; current<=max; current++) {
            Thread.sleep(SLEEP_MS);
            if (isPrime(current)) {
                last = current;
                return current;
            }
        }
        throw new NoSuchElementException();
    }
}
