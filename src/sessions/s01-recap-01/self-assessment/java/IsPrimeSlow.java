class IsPrimeSlow {
    public static void main(String args[]) {
        int target = Integer.parseInt(args[0]);
        System.out.println(isPrimeSlow(target));
    }

    static boolean isPrimeSlow(int n) {
         // all primes are greater than 1
         if (n < 2) {
            return false;
        }

        // if n has no divisors between 2 and n-1 then,
        // n is a prime.
        for (int div=2; div<n; div++) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }
}
