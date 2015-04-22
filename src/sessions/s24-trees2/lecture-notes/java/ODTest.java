import java.util.NoSuchElementException;

class ODTest {
    private static final String ARG_UAL = "UAL";
    private static final String ARG_ULL = "ULL";
    private static final String ARG_SAL = "SAL";
    private static final String ARG_SLL = "SLL";
    private static final String ARG_BST = "BST";
    private static final String ARG_ALL = "ALL";

    private static final String UAL = "UNSORTED ARRAY LIST";
    private static final String ULL = "UNSORTED LINKED LIST";
    private static final String SAL = "SORTED ARRAY LIST";
    private static final String SLL = "SORTED LINKED LIST";
    private static final String BST = "BINARY SEARCH TREE";
    private static final String ALL = "ALL";

    private static final String SEPARATOR = "=========== ";

    private static final Integer[] KEYS = { 27,  44,  38,  48,   8,  49,
        7,   9,  28,  26,  42,  21,   4,  43,  11,  12,   3,  36,  18,  37,
        1,  22,  50,  41,  24,  51,  23,  10,  25,  52,  15,  46,  35,  47,
       14,  29,  30,   5,   6,  39,  40,  17,  16,  33,  31,   2,  32,  34,
       45,  19,  20,  13};
    private static final String[] INFO =  {"a", "b", "c", "d", "e", "f",
      "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
      "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
      "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
      "W", "X", "Y", "Z"};

    public static void main(String args[]) {
        String implementation;
        if (args.length == 1) {
            switch (args[0]) {
                case ARG_UAL:
                    implementation = UAL;
                    break;
                case ARG_ULL:
                    implementation = ULL;
                    break;
                case ARG_SAL:
                    implementation = SAL;
                    break;
                case ARG_SLL:
                    implementation = SLL;
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
                pass = test(UAL);
                pass = test(ULL) && pass;
                pass = test(SAL) && pass;
                pass = test(SLL) && pass;
                pass = test(BST) && pass;
            } else {
                pass = test(implementation);
            }
            System.out.println();
            System.out.print(SEPARATOR);
            System.out.println(pass ? "OK" : "ERROR");
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println();
            System.out.println(SEPARATOR + "ERROR");
            System.out.println();
        }
    }

    private static void usage() {
        System.out.println("usage:");
        System.out.println("\tODTest [ UAL | ULL | SAL | SLL | BST | ALL]");
        System.out.println();
        System.out.println("\tTest an Ordered Dictionary using:");
        System.out.println("\t\t" + ARG_UAL + " : " + UAL);
        System.out.println("\t\t" + ARG_ULL + " : " + ULL);
        System.out.println("\t\t" + ARG_SAL + " : " + SAL);
        System.out.println("\t\t" + ARG_SLL + " : " + SLL);
        System.out.println("\t\t" + ARG_BST + " : " + BST);
        System.out.println("\t\t" + ARG_ALL + " : all 5 implementations");
    }

    private static <K extends Comparable<K>, I>
        OrderedDictionary<K, I> createOD(String implementation) {
        OrderedDictionary<K, I> od;
        switch (implementation) {
            case UAL:
                od = new ODUnsortedArrayList<K, I>();
                break;
            case ULL:
                od = new ODUnsortedLinkedList<K, I>();
                break;
            case SAL:
                od = new ODSortedArrayList<K, I>();
                break;
            case SLL:
                od = new ODSortedLinkedList<K, I>();
                break;
            case BST:
                od = new Bst<K, I>(Bst.PREDECESSOR_UNBALANCING);
                // od = new Bst<K, I>(Bst.SUCCESSOR_UNBALANCING);
                // od = new Bst<K, I>(Bst.RANDOM_UNBALANCING);
                break;
            default:
                throw new RuntimeException(
                        "Unsupported implementation: " + implementation);
        }
        return od;
    }

    private static <K extends Comparable<K>, I>
        void debugBst(OrderedDictionary<K, I> od) {
        if (od instanceof Bst) {
            Bst bst = (Bst) od;
            System.out.println(bst.toStringLevelOrder());
        }
    }
    private static boolean test(String implementation) {
        System.out.println();
        System.out.println(SEPARATOR + "Testing " + implementation);

        { // test empty od
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            if (od.size() != 0) {
                throw new TestException("001 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("002");
            }
        }

        { // test insert
            OrderedDictionary<Integer, Integer> od = createOD(implementation);

            od.insert(1, 1);
            if (od.size() != 1) {
                throw new TestException("004 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("005");
            }

            od.insert(1, 1);
            if (od.size() != 1) {
                throw new TestException("007 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("008");
            }

            od.insert(1, 1);
            if (od.size() != 1) {
                throw new TestException("010 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("011");
            }

            od.insert(4, 3);
            if (od.size() != 2) {
                throw new TestException("013 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("014");
            }

            od.insert(2, 5);
            od.insert(-1, -1);
            od.insert(-1, -1);
            od.insert(2, 5);
            od.insert(100, 100);
            od.insert(25, 25);
            od.insert(13, 13);
            od.insert(21, 21);
            od.insert(20, 20);
            od.insert(3, 3);
            od.insert(-10, -10);
            od.insert(24, 24);
            od.insert(100, 100);
            od.insert(22, 22);
            od.insert(21, 21);
            od.insert(50, 50);
            od.insert(99, 99);
            if (od.size() != 15) {
                throw new TestException("015 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("016");
            }
        }

        { // test clear
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("017 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("018");
            }

            od.insert(1, 1);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("020 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("021");
            }

            od.insert(1, 1);
            od.insert(1, 1);
            od.insert(2, 3);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("023 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("024");
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
                throw new TestException("026 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("027");
            }

            od.clear();
            if (od.size() != 0) {
                throw new TestException("029 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("030");
            }
        }

        { // find
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            try {
                od.find(0);
                throw new TestException("032.01");
            } catch (NoSuchElementException ex) {
            }
            try {
                od.find(12);
                throw new TestException("032.02");
            } catch (NoSuchElementException ex) {
            }
            od.insert(50, 50);
            try {
                od.find(12);
                throw new TestException("032.03");
            } catch (NoSuchElementException ex) {
            }
            od.insert(10, 10);
            try {
                od.find(12);
                throw new TestException("032.04");
            } catch (NoSuchElementException ex) {
            }
            od.insert(12,12);
            Integer found;
            found = od.find(12);
            if (found.compareTo(12) != 0) {
                throw new TestException("032.05 : " + found);
            }
            try {
                od.find(-100);
                throw new TestException("032.06");
            } catch (NoSuchElementException ex) {
            }
            try {
                od.find(100);
                throw new TestException("032.07");
            } catch (NoSuchElementException ex) {
            }
            found = od.find(12);
            if (found.compareTo(12) != 0) {
                throw new TestException("032.08 : " + found);
            }
            od.insert(12,15);
            found = od.find(12);
            if (found.compareTo(15) != 0) {
                throw new TestException("032.09 : " + found);
            }
            try {
                od.find(-100);
                throw new TestException("032.10");
            } catch (NoSuchElementException ex) {
            }
            try {
                od.find(100);
                throw new TestException("032.11");
            } catch (NoSuchElementException ex) {
            }
            found = od.find(12);
            if (found.compareTo(15) != 0) {
                throw new TestException("032.12 : " + found);
            }

            OrderedDictionary<Integer, String> od2 = createOD(implementation);
            for (int i=0; i<KEYS.length; i++) {
                od2.insert(KEYS[i], INFO[i]);
            }
            String f;
            for (int i=KEYS.length-1; i>=0; i--) {
                f = od2.find(KEYS[i]);
                if (! f.equals(INFO[i])) {
                    throw new TestException("033 "  + i + ", " + f + ", " + INFO[i]);
                }
            }
            for (int i=0; i<KEYS.length; i++) {
                f = od2.find(KEYS[i]);
                if (! f.equals(INFO[i])) {
                    throw new TestException("034 "  + i + ", " + f + ", " + INFO[i]);
                }
            }
            od2.clear();
            try {
                for (int i=0; i<KEYS.length; i++) {
                    f = od2.find(KEYS[i]);
                    throw new TestException("035 "  + i + ", " + f);
                }
            } catch (NoSuchElementException ex) {
            }
            for (int i=0; i<KEYS.length; i++) {
                od2.insert(KEYS[i], INFO[i]);
            }
            for (int i=KEYS.length-1; i>=0; i--) {
                f = od2.find(KEYS[i]);
                if (! f.equals(INFO[i])) {
                    throw new TestException("036 "  + i + ", " + f + ", " + INFO[i]);
                }
            }
        }

        { // remove
            OrderedDictionary<Integer, String> od = createOD(implementation);
            String removed;
            try {
                removed = od.remove(1);
                throw new TestException("050 : " + removed);
            } catch (NoSuchElementException ex) {};

            od.insert(50, "50");
            try {
                removed = od.remove(40);
                throw new TestException("051 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(49);
                throw new TestException("052 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(51);
                throw new TestException("053 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(60);
                throw new TestException("053 : " + removed);
            } catch (NoSuchElementException ex) {};
            removed = od.remove(50);
            if (! removed.equals("50")) {
                throw new TestException("054");
            }
            if (! od.isEmpty()) {
                throw new TestException("055");
            }
            if (od.size() != 0) {
                throw new TestException("056 : " + od.size());
            }

            od.insert(50, "50");
            od.insert(25, "25");
            try {
                removed = od.remove(20);
                throw new TestException("057 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(30);
                throw new TestException("058 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(60);
                throw new TestException("059 : " + removed);
            } catch (NoSuchElementException ex) {};
            removed = od.remove(25);
            if (! removed.equals("25")) {
                throw new TestException("060");
            }
            if (od.isEmpty()) {
                throw new TestException("061");
            }
            if (od.size() != 1) {
                throw new TestException("062 : " + od.size());
            }
            try {
                removed = od.remove(25);
                throw new TestException("063 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(40);
                throw new TestException("064 : " + removed);
            } catch (NoSuchElementException ex) {};
            removed = od.remove(50);
            if (! removed.equals("50")) {
                throw new TestException("065");
            }
            if (! od.isEmpty()) {
                throw new TestException("066");
            }
            if (od.size() != 0) {
                throw new TestException("067 : " + od.size());
            }

            od.clear();
            od.insert(25, "25");
            od.insert(50, "50");
            try {
                removed = od.remove(20);
                throw new TestException("068 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(30);
                throw new TestException("069 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(60);
                throw new TestException("070 : " + removed);
            } catch (NoSuchElementException ex) {};
            removed = od.remove(50);
            if (! removed.equals("50")) {
                throw new TestException("071");
            }
            if (od.isEmpty()) {
                throw new TestException("072");
            }
            if (od.size() != 1) {
                throw new TestException("073 : " + od.size());
            }
            try {
                removed = od.remove(50);
                throw new TestException("074 : " + removed);
            } catch (NoSuchElementException ex) {};
            try {
                removed = od.remove(40);
                throw new TestException("075 : " + removed);
            } catch (NoSuchElementException ex) {};
            removed = od.remove(25);
            if (! removed.equals("25")) {
                throw new TestException("076");
            }
            if (! od.isEmpty()) {
                throw new TestException("077");
            }
            if (od.size() != 0) {
                throw new TestException("078 : " + od.size());
            }


            od.clear();
            od.insert(50, "50");
            od.insert(25, "25");
            od.insert(75, "75");
            od.insert(12, "12");
            od.insert(35, "35");
            od.insert(60, "60");
            od.insert(80, "80");
            od.insert( 7,  "7");
            od.insert(15, "15");
            od.insert(27, "27");
            od.insert( 3,  "3");
            od.insert(13, "13");
            od.insert(12, "-12");
            od.insert(16, "16");
            od.insert(26, "26");
            od.insert(29, "29");
            // debugBst(od);
            // predecessor: 50, 25, 75, 12, 35, 60, 80, 7, 15, 27,
            // 3, 13, 16, 26, 29
            // successor: 50, 25, 75, 12, 35, 60, 80, 7, 15, 27,
            // 3, 13, 16, 26, 29
            removed = od.remove(50);
            if (! removed.equals("50")) {
                throw new TestException("079");
            }
            // debugBst(od);
            // predecessor: 35, 25, 75, 12, 27, 60, 80, 7, 15, 26,
            // 29, 3, 13, 16
            // successor: 60, 25, 75, 12, 35, 80, 7, 15, 27,
            // 3, 13, 16, 26, 29

            removed = od.remove(35);
            if (! removed.equals("35")) {
                throw new TestException("080");
            }
            // debugBst(od);
            // predecessor: 29, 25, 75, 12, 27, 60, 80, 7, 15, 26,
            // 3, 13, 16
            // successor: 60, 25, 75, 12, 27, 80, 7, 15, 26, 29, 3, 13, 16

            removed = od.remove(29);
            if (! removed.equals("29")) {
                throw new TestException("081");
            }
            // debugBst(od);
            // predecessor: 27, 25, 75, 12, 26, 60, 80, 7, 15, 3,
            // 13, 16
            // successor: 60, 25, 75, 12, 27, 80, 7, 15, 26, 3, 13, 16

            removed = od.remove(12);
            if (! removed.equals("-12")) {
                throw new TestException("082");
            }
            // debugBst(od);
            // predecessor: 27, 25, 75, 7, 26, 60, 80, 3, 15, 13, 16
            // successor: 60, 25, 75, 13, 27, 80, 7, 15, 26, 3, 16

            removed = od.remove(75);
            if (! removed.equals("75")) {
                throw new TestException("083");
            }
            // debugBst(od);
            // predecessor: 27, 25, 60, 7, 26, 80, 3, 15, 13, 16
            // successor: 60, 25, 80, 13, 27, 7, 15, 26, 3, 16

            removed = od.remove(25);
            if (! removed.equals("25")) {
                throw new TestException("084");
            }
            // debugBst(od);
            // predecessor: 27, 16, 60, 7, 26, 80, 3, 15, 13
            // successor: 60, 26, 80, 13, 27, 7, 15, 3, 16

            removed = od.remove(13);
            if (! removed.equals("13")) {
                throw new TestException("085");
            }
            // debugBst(od);
            // predecessor: 27, 16, 60, 7, 26, 80, 3, 15
            // successor: 60, 26, 80, 15, 27, 7, 16, 3

            removed = od.remove(27);
            if (! removed.equals("27")) {
                throw new TestException("086");
            }
            // debugBst(od);
            // predecessor: 26, 16, 60, 7, 80, 3, 15
            // successor: 60, 26, 80, 15, 7, 16, 3

            removed = od.remove(60);
            if (! removed.equals("60")) {
                throw new TestException("087");
            }
            // debugBst(od);
            // predecessor: 26, 16, 80, 7, 3, 15
            // successor: 80, 26, 15, 7, 16, 3

            removed = od.remove(80);
            if (! removed.equals("80")) {
                throw new TestException("088");
            }
            // debugBst(od);
            // predecessor: 26, 16, 7, 3, 15
            // successor: 26, 15, 7, 16, 3

            removed = od.remove(26);
            if (! removed.equals("26")) {
                throw new TestException("089");
            }
            // debugBst(od);
            // predecessor: 16, 7, 3, 15
            // successor: 15, 7, 16, 3

            removed = od.remove(7);
            if (! removed.equals("7")) {
                throw new TestException("090");
            }
            // debugBst(od);
            // predecessor: 16, 3, 15
            // successor: 15, 3, 16

            removed = od.remove(16);
            if (! removed.equals("16")) {
                throw new TestException("091");
            }
            // debugBst(od);
            // predecessor: 15, 3
            // successor: 15, 3

            removed = od.remove(15);
            if (! removed.equals("15")) {
                throw new TestException("092");
            }
            // debugBst(od);
            // predecessor: 3
            // successor: 3

            removed = od.remove(3);
            if (! removed.equals("3")) {
                throw new TestException("093");
            }
            // debugBst(od);
            // predecessor:
            // successor:

            od.clear();
            for (int i=0; i<KEYS.length; i++) {
                od.insert(KEYS[i], INFO[i]);
            }
            String found;
            for (int i=0; i<KEYS.length; i++) {
                removed = od.remove(KEYS[i]);
                if (! removed.equals(INFO[i])) {
                    throw new TestException("100 "  + i + ", " +
                            removed + ", " + INFO[i]);
                }
                for (int j=0; j<=i; j++) {
                    try {
                        found = od.find(KEYS[j]);
                        throw new TestException("101 : " + j +
                                ", " + found);
                    } catch (NoSuchElementException ex) {
                    }
                }
            }
        }
        return true;
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
