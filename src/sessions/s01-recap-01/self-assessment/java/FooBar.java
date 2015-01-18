class FooBar {
    public static void main(String args[]) {
        int max = Integer.parseInt(args[0]);

        for (int i = 1; i<=max; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
            } else {
                if (i % 3 == 0) {
                    System.out.print("FOO");
                }
                if (i % 5 == 0) {
                    System.out.print("BAR");
                }
                System.out.println();
            }
        }
    }
}
