class IsPalindromeRecursiveEfficient {

    private static final String USAGE =
        "USAGE: java IsPalindromeRecursiveEfficient string";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(USAGE);
            return;
        }
        System.out.println(isPalindrome(args[0]));
    }

    private static boolean isPalindrome(String s) {
        return isPalindromeEfficient(s, 0, s.length()-1);
    }

    private static boolean isPalindromeEfficient(String s, int first, int last) {
        if (first >= last) {
            return true;
        } else {
            return (s.charAt(first) == s.charAt(last))
                && isPalindromeEfficient(s, ++first, --last);
        }
    }
}
