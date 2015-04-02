class IsPalindromeIterative {

    private static final String USAGE =
        "USAGE: java IsPalindromeIterative string";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(USAGE);
            return;
        }
        System.out.println(isPalindrome(args[0]));
    }

    private static boolean isPalindrome(String s) {
        for (int i=0; i<(s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
