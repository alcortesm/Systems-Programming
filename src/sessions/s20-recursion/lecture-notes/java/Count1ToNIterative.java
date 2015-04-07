class Count1ToNIterative {

    private static final String USAGE =
        "USAGE: java Count1ToNIterative number"
        + System.lineSeparator()
        + "     number: integer bigger than 0";

    public static void main(String args[]) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(args[0]);
            if (input < 1) {
                throw new IllegalArgumentException();
            }
            count1ToN(input);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    private static void count1ToN(int n) {
        for (int i=1; i<=n; i++) {
            System.out.println(i);
        }
    }
}
