class TriangularRecursive {

    // the triangular number of numbers bigger than
    // 65_535 is too big to fit into an Java int.
    private static final int MAX = 65_535;

    private static final String USAGE =
        "USAGE: java TriangularIterative number"
        + System.lineSeparator()
        + "     number: integer from 1 to " + MAX ;

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(args[0]);
            if (input < 1 || input > MAX) {
                throw new IllegalArgumentException();
            }
            int output = triangular(input);
            System.out.println(output);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    // for n bigger than 9924 there is a stack overflow
    // in my laptop.
    //
    // A stack of 4520k should be enough for the biggest
    // calculation (TriangularRecursive of 65_535).
    //
    // You can change the stack size of the JVM using
    // the -Xss argument, for example:
    //
    // java -Xss4520k TriangularRecursive 65535
    private static int triangular(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangular(n - 1);
        }
    }
}
