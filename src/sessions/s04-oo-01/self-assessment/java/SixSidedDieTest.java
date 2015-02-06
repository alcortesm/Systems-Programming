class SixSidedDieTest {
    public static void main(String args[]) {
        SixSidedDie die = new SixSidedDie();
        for (int i=0; i<10; i++) {
            System.out.println(die.roll());
        }
    }
}
