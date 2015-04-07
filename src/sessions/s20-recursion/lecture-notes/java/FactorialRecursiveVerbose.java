class FactorialRecursiveVerbose {

    // the factorial of numbers bigger than
    // 12 is too big to fit into an Java int.
    private static final int MAX = 12;
    private static final String INDENT = "|  ";

    private static final String USAGE =
        "USAGE: java FactorialRecursive number"
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
            int output = fact(input, 0);
            System.out.println(output);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    private static int fact(int n, int indentLevel) {
        // ugly hack to repeat an string n times in Java
        String indent = new String(new char[indentLevel]).replace("\0", INDENT);
        System.out.println(indent + "calling fact(" + n + ")");
        int answer;
        if (n == 0) {
            answer = 1;
        } else {
            answer = n * fact(n - 1, indentLevel+1);
        }
        System.out.println(indent + "returning " + answer);
        return answer;
    }
}
