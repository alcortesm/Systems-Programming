class DieTest {
    final static private int NUM_ROLLS = 5;

    private static void test(int sides) {
        try {
            System.out.println("Rolling a dice of " + sides +
                    " sides " + NUM_ROLLS + " times in a row:");
            Die die = new Die(sides);
            for (int i=0; i<NUM_ROLLS; i++) {
                System.out.println(die.roll());
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void main(String args[]) {
        test(-3);
        test(1);
        test(2);
        test(6);
        test(1000);
    }
}
