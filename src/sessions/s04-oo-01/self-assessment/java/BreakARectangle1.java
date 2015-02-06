class BreakARectangle1 {
    public static void main(String args[]) {
        try {
            Rectangle1 r = new Rectangle1(1D, 3D);
            r.width = -1D;
            System.out.println(r);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

