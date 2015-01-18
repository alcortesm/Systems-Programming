class PrimesUntilSlow {
    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);
        for (int i=2; i<=n; i++) {
            if (IsPrimeSlow.isPrimeSlow(i)) {
                System.out.println(i);
            }
        }
    }
}
