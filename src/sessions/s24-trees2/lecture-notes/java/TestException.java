class TestException extends RuntimeException {
    public TestException(String msg) {
        super("ERROR " + msg);
    }
}
