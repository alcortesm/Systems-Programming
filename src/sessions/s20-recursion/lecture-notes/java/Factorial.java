class Factorial {

    private static final String USAGE =
        "ERROR: one argument required: "
        + "an integer between 1 and 12 "
        + "(both included)";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(USAGE);
            return;
        }
        try {
            int input = Integer.parseInt(args[0]);
            int output = factI(input);
//            int output = factR(input);
            System.out.println(output);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    // Iterative version:
    // this method returns wrong values for n>12
    // due to int overflows.
    static int factI(int n) {
        if (n < 1 || n > 12) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        for (int i=n; i>0; i--) {
            result *= i;
        }
        return result;
    }

    // Recursive version:
    // this method returns wrong values for n>12
    // due to int overflows.
    static int factR(int n) {
        if (n < 1 || n > 12) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        } else {
            return n * factR(n-1);
        }
    }
}
