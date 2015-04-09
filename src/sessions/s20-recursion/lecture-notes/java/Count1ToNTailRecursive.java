class Count1ToNTailRecursive {

    private static final String USAGE =
        "USAGE: java Count1ToNTailRecursive number"
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
        count1ToNTailRecursive(n, 1);
    }

    private static void count1ToNTailRecursive(int n, int c) {
        System.out.println(c);
        if (c == n) {
            return;
        } else {
            count1ToNTailRecursive(n, ++c);
        }
    }
}
