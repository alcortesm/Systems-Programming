class Hello5 {
    public static void main(String[] args) {
        // FUNCTOR implemented as an anonymous class
        Runnable runMe = new Runnable() {
            public void run() {
                System.out.println("Hello");
            }
        };
        runMe.run();
    }
}
