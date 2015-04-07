class Count1ToNRecursiveVerbose {

    private static final String USAGE =
        "USAGE: java Count1ToNRecursiveVerbose number"
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
            count1ToN(input, 0);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    private static void count1ToN(int n, int indentLevel) {
        // ugly hack to repeat an string n times in Java
        String indent = new String(new char[indentLevel]).replace("\0", INDENT);
        System.out.println(indent + "calling countNTo1(" + n + ")");
        if (n > 1) {
            count1ToN(n-1, ++indentLevel);
        }
        System.out.println(n);
        System.out.println(indent + "returning");
    }
}
