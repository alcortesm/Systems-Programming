class CountNTo1Iterative {

    private static final String USAGE =
        "USAGE: java CountNTo1Iterative number"
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
        for (int i=n; i>0; i--) {
            System.out.println(i);
        }
    }
}
