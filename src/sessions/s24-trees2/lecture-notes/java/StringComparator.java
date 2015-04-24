class StringComparator {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.err.println("ERROR: this program" +
                    "requires exactly two arguments");
            return;
        }

        int comp = args[0].compareTo(args[1]);
        System.out.print(args[0] + " is alphabetically");
        if (comp == 0) {
            System.out.println(" EQUAL to " + args[1]);
        } else if (comp > 0) {
            System.out.println(" BIGGER than " + args[1]);
        } else {
            System.out.println(" SMALLER than " + args[1]);
        }
    }
}
