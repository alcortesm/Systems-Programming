class AddWithOverflowDetection {
    private static int addWithOverflowDetection(int a, int b) throws Exception {
        int result = a + b;
        if ((a > 0 && b > 0 && result < 0)
                || (a < 0 && b < 0 && result > 0)) {
            throw new Exception();
        }
        return result;
    }

    public static void main(String args[]) {
        try {
            int result = addWithOverflowDetection(Integer.MAX_VALUE, 1);
            System.err.println(
                "ERROR: Integer.MAX_VALUE plus 1 did NOT throw an exception");
        } catch (Exception e) {
            System.out.println(
                "OK: Integer.MAX_VALUE plus 1 throws an exception");
        }

        try {
            int result = addWithOverflowDetection(Integer.MAX_VALUE, -1);
            System.out.println(
                "OK: Integer.MAX_VALUE plus -1 is " + result);
        } catch (Exception e) {
            System.err.println(
                "ERROR: Integer.MAX_VALUE plus -1 throws an exception");
        }

        try {
            int result = addWithOverflowDetection(Integer.MIN_VALUE, +1);
            System.out.println(
                "OK: Integer.MIN_VALUE plus 1 is " + result);
        } catch (Exception e) {
            System.err.println(
                "ERROR: Integer.MIN_VALUE plus -1 throws an exception");
        }

        try {
            int result = addWithOverflowDetection(Integer.MIN_VALUE, -1);
            System.err.println(
                "ERROR: Integer.MIN_VALUE plus -1 did NOT throw an exception");
        } catch (Exception e) {
            System.out.println(
                "OK: Integer.MIN_VALUE plus -1 throws an exception");
        }

        try {
            int result = addWithOverflowDetection(1000111222, 2000111222);
            System.err.println(
                "ERROR: 1000111222 plus 2000111222 did NOT throw an exception");
        } catch (Exception e) {
            System.out.println(
                "OK: 1000111222 plus 2000111222 throws an exception");
        }
    }
}

