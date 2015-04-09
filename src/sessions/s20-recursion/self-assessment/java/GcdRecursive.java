class GcdRecursive {

    private static final String USAGE =
        "USAGE: java GcdRecursive number1 number2"
        + System.lineSeparator()
        + "     numbers: integers bigger than 0";

    public static void main(String args[]) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException();
            }
            int input1 = Integer.parseInt(args[0]);
            if (input1 < 1) {
                throw new IllegalArgumentException();
            }
            int input2 = Integer.parseInt(args[1]);
            if (input2 < 1) {
                throw new IllegalArgumentException();
            }
            int output = gcd(input1, input2);
            System.out.println(output);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    // Recursive version of Euclidean algorithm (c. 300 BC)
    //
    // 1) r <- m % n
    // 2) if r = 0, return n
    // 3) m <- n, n <- r
    private static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }
}
