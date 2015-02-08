class Max1 {
    private static Rectangle1 max(Rectangle1[] input) {
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
        Rectangle1[] array = new Rectangle1[3];
        array[0] = new Rectangle1(3D, 2D);
        array[1] = new Rectangle1(2D);
        array[2] = new Rectangle1(1D, 7D);
        Rectangle1 max = max(array);
        System.out.println(max);
    }
}
