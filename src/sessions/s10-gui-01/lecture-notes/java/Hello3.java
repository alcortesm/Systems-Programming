class Hello3 {
    public static void main(String[] args) {
        Runnable runMe = new PrintFunctor();
        runMe.run();
    }
}
