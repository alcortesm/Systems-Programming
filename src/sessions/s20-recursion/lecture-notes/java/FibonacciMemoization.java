class FibonacciMemoization {

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

    private static int fibo(int n) {
        Integer[] memo = new Integer[n+1];
        memo[0] = 0; memo[1] = 1;
        return fiboMemo(n, memo);
    }

    private static int fiboMemo(int n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        } else {
            return memo[n] =
                fiboMemo(n-1, memo) + fiboMemo(n-2, memo);
        }
    }
}
