class StringComparator {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.err.println("ERROR: this program" +
                    "requires exactly two arguments");
            return;
        }

        if (args[0].compareTo(args[1]) == 0) {
            System.out.println(args[0] +
                    " is alphabetically EQUAL as " +
                    args[1]);
        } else if (args[0].compareTo(args[1]) > 0) {
            System.out.println(args[0] +
                    "is alphabetically BIGGER than " +
                    args[1]);
        } else {
            System.out.println(args[0] +
                    " is alphabetically SMALLER than " +
                    args[1]);
        }
    }
}
