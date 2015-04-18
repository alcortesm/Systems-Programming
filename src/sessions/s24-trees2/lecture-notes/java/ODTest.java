class ODTest {
    private static final String ARG_UL = "UL";
    private static final String ARG_SL = "SL";
    private static final String ARG_BST = "BST";
    private static final String ARG_ALL = "ALL";

    private static final String UL = "UNSORTED LIST";
    private static final String SL = "SORTED LIST";
    private static final String BST = "BINARY SEARCH TREE";
    private static final String ALL = "ALL";

    private static final String SEPARATOR = "=========== ";

    public static void main(String args[]) {
        String implementation;
        if (args.length == 1) {
            switch (args[0]) {
                case ARG_UL:
                    implementation = UL;
                    break;
                case ARG_SL:
                    implementation = SL;
                    break;
                case ARG_BST:
                    implementation = BST;
                    break;
                case ARG_ALL:
                    implementation = ALL;
                    break;
                default:
                    usage();
                    System.exit(1);
                    return;
            }
        } else {
            usage();
            System.exit(1);
            return;
        }

        try {
            boolean pass;
            if (implementation.equals(ALL)) {
                pass = test(UL);
                pass = test(SL) && pass;
                pass = test(BST) && pass;
            } else {
                pass = test(implementation);
            }
            System.out.println();
            System.out.print(SEPARATOR);
            System.out.println(pass ? "OK" : "ERROR");
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println();
            System.out.println(SEPARATOR + "ERROR");
            System.out.println();
        }
    }

    private static void usage() {
        System.out.println("usage:");
        System.out.println("\tODTest [ UL | SL | BST | ALL]");
        System.out.println();
        System.out.println("\tTest an Ordered Dictionary using a sorted list, an unsorted list,");
        System.out.println("\ta binary search tree or all three versions.");
    }

    private static <K extends Comparable<K>, I> OrderedDictionary<K, I> createOD(String implementation) {
        OrderedDictionary<K, I> od;
        switch (implementation) {
            case UL:
                od = new ODUnsortedList<K, I>();
                break;
            case SL:
                od = new ODSortedList<K, I>();
                break;
            case BST:
                od = new BST<K, I>();
                break;
            default:
                throw new RuntimeException("Unsupported implementation: " + implementation);
        }
        return od;
    }

    private static boolean test(String implementation) {
        System.out.println();
        System.out.println(SEPARATOR + "Testing " + implementation);

        { // test empty od
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            if (od.size() != 0) {
                throw new TestException("001");
            }
            if (! od.isEmpty()) {
                throw new TestException("002");
            }
            if (! od.toString().equals("")) {
                throw new TestException("003 : " + od.toString());
            }
        }

        { // test insert
            OrderedDictionary<Integer, Integer> od = createOD(implementation);

            od.insert(1, 1);
            if (od.size() != 1) {
                throw new TestException("004");
            }
            if (od.isEmpty()) {
                throw new TestException("005");
            }
            if (! od.toString().equals("(1,1)")) {
                throw new TestException("006 : " + od.toString());
            }

            od.insert(1, 1);
            if (od.size() != 2) {
                throw new TestException("007");
            }
            if (od.isEmpty()) {
                throw new TestException("008");
            }
            if (! od.toString().equals("(1,1), (1,1)")) {
                throw new TestException("009 : " + od.toString());
            }

            od.insert(1, 1);
            if (od.size() != 3) {
                throw new TestException("010");
            }
            if (od.isEmpty()) {
                throw new TestException("011");
            }
            if (! od.toString().equals("(1,1), (1,1), (1,1)")) {
                throw new TestException("012 : " + od.toString());
            }

            od.insert(4, 3);
            if (od.size() != 4) {
                throw new TestException("011");
            }
            if (od.isEmpty()) {
                throw new TestException("012");
            }
            if (! od.toString().equals("(1,1), (1,1), (1,1), (4,3)")) {
                throw new TestException("013 : " + od.toString());
            }
        }

        { // test clear
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("014");
            }
            if (! od.isEmpty()) {
                throw new TestException("015");
            }
            if (! od.toString().equals("")) {
                throw new TestException("016 : " + od.toString());
            }

            od.insert(1, 1);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("017");
            }
            if (! od.isEmpty()) {
                throw new TestException("018");
            }
            if (! od.toString().equals("")) {
                throw new TestException("019 : " + od.toString());
            }

            od.insert(1, 1);
            od.insert(1, 1);
            od.insert(2, 3);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("020");
            }
            if (! od.isEmpty()) {
                throw new TestException("021");
            }
            if (! od.toString().equals("")) {
                throw new TestException("022 : " + od.toString());
            }

            od.insert(1, 1);
            od.insert(2, 1);
            od.insert(3, 1);
            od.insert(4, 1);
            od.insert(5, 1);
            od.insert(6, 1);
            od.insert(7, 1);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("023");
            }
            if (! od.isEmpty()) {
                throw new TestException("024");
            }
            if (! od.toString().equals("")) {
                throw new TestException("025 : " + od.toString());
            }

            od.clear();
            if (od.size() != 0) {
                throw new TestException("026");
            }
            if (! od.isEmpty()) {
                throw new TestException("027");
            }
            if (! od.toString().equals("")) {
                throw new TestException("028 : " + od.toString());
            }
        }

        return true;
    }
}
