class TriangularRecursiveVerbose {

    // the triangular number of numbers bigger than
    // 65_535 is too big to fit into an Java int.
    private static final int MAX = 65_535;

    private static final String USAGE =
        "USAGE: java TriangularIterative number"
        + System.lineSeparator()
        + "     number: integer from 1 to " + MAX ;

    private static final String INDENT = "  ";

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

    private static int triangular(int n) {
        return triangularVerbose(n, 1);
    }

    private static int triangularVerbose(int n, int indentLevel) {
        String indent = new String(new char[indentLevel]).replace("\0", INDENT);
        System.out.println(indent + "called traingular of " + n);
        int answer;
        if (n == 1) {
            answer = 1;
        } else {
            answer = n + triangularVerbose(n - 1, indentLevel + 1);
        }
        System.out.println(indent + "result = " + answer);
        return answer;
    }
}
