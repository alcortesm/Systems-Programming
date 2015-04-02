class TriangularIterative {

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

    static int triangular(int n) {
        int result = 0;
        for (int i=1; i<=n; i++) {
            result += i;
        }
        return result;
    }
}
