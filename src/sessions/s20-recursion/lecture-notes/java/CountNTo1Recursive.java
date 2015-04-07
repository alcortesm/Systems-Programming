class CountNTo1Recursive {

    private static final String USAGE =
        "USAGE: java CountNTo1Recursive number"
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
            countNTo1(input);
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }

    private static void countNTo1(int n) {
        System.out.println(n);
        if (n > 1) {
            countNTo1(n-1);
        }
    }
}
