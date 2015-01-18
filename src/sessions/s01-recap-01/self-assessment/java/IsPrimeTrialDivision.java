class IsPrimeTrialDivision {
    public static void main(String args[]) {
        int target = Integer.parseInt(args[0]);
        System.out.println(isPrimeTrialDivision(target));
    }

    static boolean isPrimeTrialDivision(int n) {
        // all primes are greater than 1
        if (n < 2) {
            return false;
        }

        // if n has no divisors between 2 and sqrt(n) then,
        // n is prime
        for (int div=2; (div*div)<=n; div++) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }
}
