class IsEvenlyDivisible {
    public static void main(String args[]) {
        int dividend = Integer.parseInt(args[0]);
        int divisor  = Integer.parseInt(args[1]);

        System.out.println(dividend % divisor == 0);
    }
}
