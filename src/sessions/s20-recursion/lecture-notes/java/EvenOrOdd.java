// Very bad example of mutual recursion.
//
// This is extremely inefficient, must look for better, real life example.
class EvenOrOdd {

    private static final String USAGE =
        "USAGE: java EvenOrOdd number"
        + System.lineSeparator()
        + "     number: integer number bigger than 0";

    private static boolean isEven(int n) {
        if (n == 0) {
            return true;
        } else {
            return isOdd(n-1);
        }
    }

    private static boolean isOdd(int n) {
        if (n == 0) {
            return false;
        } else {
            return isEven(n-1);
        }
    }

    public static void main(String args[]) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException();
            }
            int input = Integer.parseInt(args[0]);
            if (input < 0) {
                throw new IllegalArgumentException();
            }
            System.out.println(isEven(input) ? "EVEN" : "ODD");
        } catch (Exception ex) {
            System.err.println(USAGE);
            return;
        }
    }
}
