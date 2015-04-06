class TriangularFormula {

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

    // Sum_{i=1}^n i = n * (n + 1) / 2
    //
    // We are using ints internally in this method for simplicity, but we
    // should use BigDecimal as n * (n - 1) gets bigger than ints and
    // longs pretty quickly.
    //
    // For example, this methods returns wrong values for n > 46340.
    private static int triangular(int n) {
        return n * (n + 1) / 2;
    }
}
