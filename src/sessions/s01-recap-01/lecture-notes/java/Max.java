class Max {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = max(a, b);
        System.out.println(c);
    }

    static int max(int x, int y) {
        if (x >= y) {
            return x;
        } else {
            return y;
        }
    }
}
