class FibonacciIterative {

    // Fibonacci of a number bigger than 46 is so big
    // that it does not fit into an int.
    private static final int MAX = 46;

    private static final String USAGE =
        "USAGE: java FibonacciRecursiveMemoization number"
        + System.lineSeparator()
        + "     number: integer from 0 to " + MAX;

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(args[0]);
            if (input < 0 || input > MAX) {
                throw new IllegalArgumentException();
            }
            int output = fibo(input);
            System.out.println(output);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    // Fn = Fn-1 + Fn-2
    // with F0 = 0 and F1 = 1.
    //
    // Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
    // 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393,
    // 196418, 317811, 514229, 832040...
    private static int fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            int fn_2 = 0;
            int fn_1 = 1;
            int fn = fn_1 + fn_2;
            for (int i=3; i<=n; i++) {
                fn_2 = fn_1;
                fn_1= fn;
                fn = fn_1 + fn_2;
            }
            return fn;
        }
        // a simpler version:
//        int a = 0;
//        int b = 1;
//        int c;
//        for (int i=0; i<n; i++) {
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return a;
    }
}
