class MagicNumbers {
    public static void main(String args[]) {
        int h = 0;
        for (int d=0; d<7; d++) {
            if (d == 0) {
                h += 0;
            } else if (d < 5) {
                h += 8;
            } else if (d == 5) {
                h += 7;
            } else {
                h += 0;
            }
        }
        System.out.println(h);
    }
}
