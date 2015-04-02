class IsPalindromeRecursive {

    private static final String USAGE =
        "USAGE: java IsPalindromeRecursive string";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(USAGE);
            return;
        }
        System.out.println(isPalindrome(args[0]));
    }

    private static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        } else {
            return (s.charAt(0) == s.charAt(s.length()-1))
                && isPalindrome(s.substring(1,s.length()-1));
        }
    }
}
