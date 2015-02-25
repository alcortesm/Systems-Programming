class Hello4 {
    public static void main(String[] args) {
        Hello4.PrintFunctor runMe = new Hello4.PrintFunctor();
        runMe.run();
    }

    // this is a FUNCTOR implemented as a NESTED CLASS
    static class PrintFunctor {
        public void run() {
            System.out.println("Hello");
        }
    }
}
