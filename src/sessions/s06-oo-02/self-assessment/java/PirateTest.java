class PirateTest {
    public static void main(String args[]) {
        Pirate cotton = new Pirate("Cotton", "English", "Cotton's parrot");
        System.out.println(cotton);
        System.out.println(cotton.getParrot().talk());
    }
}
