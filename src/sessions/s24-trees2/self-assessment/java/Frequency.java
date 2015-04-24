class Frequency {
    private static void usage() {
        System.err.println("This program needs exactly one argument");
    }

    public static void main(String args[]) {
        if (args.length != 1) {
            usage();
            System.exit(1);
        }
        String sentence = args[0];

        OrderedDictionary<Character, Integer> od = new Bst<Character, Integer>();
        int count;
        Character rune;
        for (int i=0; i<sentence.length(); i++) {
            rune = sentence.charAt(i);
            try {
                count = od.find(rune);
                count ++;
            } catch (java.util.NoSuchElementException ex) {
                count = 1;
            }
            od.insert(rune, count);
        }

        System.out.println(od);
    }
}
