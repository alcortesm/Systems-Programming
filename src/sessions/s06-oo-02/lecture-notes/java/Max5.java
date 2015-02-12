class Max5 {
    private static Rectangle5 biggest(Rectangle5[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException(
                    "null or zero-size array");
        }
        Rectangle5 max = null;
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
        Rectangle5[] array = new Rectangle5[4];
        array[0] = new Rectangle5(3D, 2D);
        array[1] = new Rectangle5(1D, 7D);
        array[2] = new Square5(3D);
        array[3] = new Square5(2D);
        Rectangle5 biggest = biggest(array);
        System.out.println(biggest);
    }
}
