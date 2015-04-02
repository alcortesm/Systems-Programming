class FactorialIterative {

    // the factorial of numbers bigger than
    // 12 is too big to fit into an Java int.
    private static final int MAX = 12;

    private static final String USAGE =
        "USAGE: java FactorialIterative number"
        + System.lineSeparator()
        + "     number: integer from 0 to " + MAX ;

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(args[0]);
            if (input < 0 || input > MAX) {
                throw new IllegalArgumentException();
            }
            int output = fact(input);
            System.out.println(output);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    private static int fact(int n) {
        int result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }
}
