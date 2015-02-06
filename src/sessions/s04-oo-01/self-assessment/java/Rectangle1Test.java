class Rectangle1Test {
    public static void main(String args[]) {
        try {
            Rectangle1 r = new Rectangle1(1D, 3D);
            System.out.println(r);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
