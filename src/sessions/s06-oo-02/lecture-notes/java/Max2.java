class Max2 {
    private static Rectangle1 biggest(Rectangle1[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException(
                    "null or zero-size array");
        }
        Rectangle1 max = null;
        for (int i=0; i<input.length; i++) {
            if (input[i] == null ) {
                continue;
            } else if (max == null ||
                    input[i].area() > max.area()) {
                max = input[i];
            }
        }
        if (max == null) {
            throw new IllegalArgumentException(
                    "empty array");
        }
        return max;
    }

    public static void main(String args[]) {
        Rectangle1[] array = new Rectangle1[4];
        array[0] = new Rectangle1(3D, 2D);
        array[1] = new Rectangle1(1D, 7D);
        array[2] = new Square2(3D).getRectangle();
        array[3] = new Square2(2D).getRectangle();
        Rectangle1 biggest = biggest(array);
        System.out.println(biggest);
    }
}
