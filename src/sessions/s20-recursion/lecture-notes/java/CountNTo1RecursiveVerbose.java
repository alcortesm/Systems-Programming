class CountNTo1RecursiveVerbose {

    private static final String USAGE =
        "USAGE: java CountNTo1Recursive number"
        + System.lineSeparator()
        + "     number: integer bigger than 0";
    private static final String INDENT = "|  ";

    public static void main(String args[]) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(args[0]);
            if (input < 1) {
                throw new IllegalArgumentException();
            }
            countNTo1(input, 0);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    private static void countNTo1(int n, int indentLevel) {
        // ugly hack to repeat an string n times in Java
        String indent = new String(new char[indentLevel]).replace("\0", INDENT);
        System.out.println(indent + "calling countNTo1(" + n + ")");
        System.out.println(n);
        if (n > 1) {
            countNTo1(n-1, ++indentLevel);
        }
        System.out.println(indent + "returning");
    }
}
