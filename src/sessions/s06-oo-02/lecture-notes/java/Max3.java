class Max3 {
    private static Rectangle1 bigger(Rectangle1[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException();
        }
        Rectangle1 max = input[0];
        for (int i=1; i<input.length; i++) {
            if (input[i].area() > max.area()) {
                max = input[i];
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Rectangle1[] array = new Rectangle1[4];
        array[0] = new Rectangle1(3D, 2D);
        array[1] = new Rectangle1(1D, 7D);
        array[2] = new Square3(3D).getRectangle();
        array[3] = new Square3(2D).getRectangle();
        Rectangle1 max = bigger(array);
        System.out.println(max);
    }
}
