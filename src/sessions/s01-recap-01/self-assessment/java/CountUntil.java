class CountUntil {
    public static void main(String args[]) {
        int last = Integer.parseInt(args[0]);
        for (int i=1; i<=10; i++) {
            System.out.println(i);
            if (i == last) {
                break;
            }
        }
    }
}
