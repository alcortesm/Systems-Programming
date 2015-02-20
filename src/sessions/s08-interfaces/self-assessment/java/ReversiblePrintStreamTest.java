class ReversiblePrintStreamTest {
    public static void main(String[] args) {
        ReversiblePrintStream rps = new ReversiblePrintStream(System.out);

        rps.println("hello");

        rps.reverse();
        rps.println("h");
        rps.println("he");
        rps.println("hel");
        rps.println("hell");
        rps.println("hello");

        rps.reverse();
        rps.println("hello");
    }
}
