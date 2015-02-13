class Max4 {
    private static Rectangle4 biggest(Rectangle4[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException(
                    "null or zero-size array");
        }
        Rectangle4 max = null;
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
        Rectangle4[] array = new Rectangle4[4];
        array[0] = new Rectangle4(3D, 2D);
        array[1] = new Rectangle4(1D, 7D);
        array[2] = new Square4(3D);
        array[3] = new Square4(2D);
        Rectangle4 biggest = biggest(array);
        System.out.println(biggest);
    }
}
