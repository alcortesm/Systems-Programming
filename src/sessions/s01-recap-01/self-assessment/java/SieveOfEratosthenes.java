class SieveOfEratosthenes {
    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);

        if (n < 2) {
            return;
        }

        // To start, we assume all numbers over 2 are primes, i.e, not
        // composites
        boolean isComposite[] = new boolean[n+1];
        isComposite[0] = true;
        isComposite[1] = true;

        // mark all multiples of prime numbers as composites
        for (int i=2; i*i<=n; i++) {
            if (! isComposite[i]) {
                int multiplier = 2;
                while (true) {
                    int multiple = i*multiplier;
                    if (multiple > n) {
                        break;
                    }
                    isComposite[multiple] = true;
                    multiplier++;
                }
            }
        }

        // print the primes
        for (int i=2; i<=n; i++) {
            if (! isComposite[i]) {
                System.out.println(i);
            }
        }
    }
}
