class Rectangle3Test {
    public static void main(String args[]) {
        try {
            Rectangle3 r = new Rectangle3(1D, 3D);
            System.out.println(r);
            r.setWidth(5D);
            r.setHeight(7D);
            System.out.println(r);
            r.setHeight(-5D);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
