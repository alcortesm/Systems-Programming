class CountDice {
    public static void main(String args[]) {
        try {
            System.out.println(Die.howMany());
            Die d = new Die();
            d = new Die();
            d = new Die();
            System.out.println(Die.howMany());
            d = new Die();
            System.out.println(Die.howMany());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
