class Rectangle1TestException {
    public static void main(String args[]) {
        try {
            Rectangle1 r = new Rectangle1(-1D, 3D);
        } catch (Exception ex) {
            System.out.println("Exception caught!");
            return;
        }
        System.out.println("The exception was not caught");
    }
}
