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

    private static final Integer[] LONG_TEST_KEYS = { 27, 44, 38, 48, 8, 49, 7, 9, 28, 26, 42, 21, 4, 43, 11, 12, 3, 36, 18, 37, 1, 22, 50, 41, 24, 51, 23, 10, 25, 52, 15, 46, 35, 47, 14, 29, 30, 5, 6, 39, 40, 17, 16, 33, 31, 2, 32, 34, 45, 19, 20, 13};
    private static final String[] LONG_TEST_INFO = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

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

    private static <K extends Comparable<K>, I> OrderedDictionary<K, I> createOD(String implementation) {
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
                throw new TestException("001 : " + od.size());
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
                throw new TestException("004 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("005");
            }
            if (! od.toString().equals("(1,1)")) {
                throw new TestException("006 : " + od.toString());
            }

            od.insert(1, 1);
            if (od.size() != 2) {
                throw new TestException("007 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("008");
            }
            if (! od.toString().equals("(1,1), (1,1)")) {
                throw new TestException("009 : " + od.toString());
            }

            od.insert(1, 1);
            if (od.size() != 3) {
                throw new TestException("010 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("011");
            }
            if (! od.toString().equals("(1,1), (1,1), (1,1)")) {
                throw new TestException("012 : " + od.toString());
            }

            od.insert(4, 3);
            if (od.size() != 4) {
                throw new TestException("011 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("012");
            }
            if (! od.toString().equals("(1,1), (1,1), (1,1), (4,3)")) {
                throw new TestException("013 : " + od.toString());
            }

            od.insert(2, 5);
            if (! od.toString().equals("(1,1), (1,1), (1,1), (2,5), (4,3)")) {
                throw new TestException("013.01 : " + od.toString());
            }

            od.insert(-1, -1);
            if (! od.toString().equals("(-1,-1), (1,1), (1,1), (1,1), (2,5), (4,3)")) {
                throw new TestException("013.02 : " + od.toString());
            }

            od.insert(-1, -1);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (4,3)")) {
                throw new TestException("013.03 : " + od.toString());
            }

            od.insert(2, 5);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (4,3)")) {
                throw new TestException("013.04 : " + od.toString());
            }

            od.insert(100, 100);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (4,3), (100,100)")) {
                throw new TestException("013.05 : " + od.toString());
            }

            od.insert(25, 25);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (4,3), (25,25), (100,100)")) {
                throw new TestException("013.06 : " + od.toString());
            }

            od.insert(13, 13);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (4,3), (13,13), (25,25), (100,100)")) {
                throw new TestException("013.07 : " + od.toString());
            }

            od.insert(21, 21);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (4,3), (13,13), (21,21), (25,25), (100,100)")) {
                throw new TestException("013.08 : " + od.toString());
            }

            od.insert(20, 20);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (4,3), (13,13), (20,20), (21,21), (25,25), (100,100)")) {
                throw new TestException("013.09 : " + od.toString());
            }

            od.insert(3, 3);
            if (! od.toString().equals("(-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (25,25), (100,100)")) {
                throw new TestException("013.10 : " + od.toString());
            }

            od.insert(-10, -10);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (25,25), (100,100)")) {
                throw new TestException("013.11 : " + od.toString());
            }

            od.insert(24, 24);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (24,24), (25,25), (100,100)")) {
                throw new TestException("013.12 : " + od.toString());
            }

            od.insert(100, 100);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (24,24), (25,25), (100,100), (100,100)")) {
                throw new TestException("013.13 : " + od.toString());
            }

            od.insert(22, 22);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (22,22), (24,24), (25,25), (100,100), (100,100)")) {
                throw new TestException("013.14 : " + od.toString());
            }

            od.insert(21, 21);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (21,21), (22,22), (24,24), (25,25), (100,100), (100,100)")) {
                throw new TestException("013.15 : " + od.toString());
            }

            od.insert(50, 50);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (21,21), (22,22), (24,24), (25,25), (50,50), (100,100), (100,100)")) {
                throw new TestException("013.16 : " + od.toString());
            }

            od.insert(99, 99);
            if (! od.toString().equals("(-10,-10), (-1,-1), (-1,-1), (1,1), (1,1), (1,1), (2,5), (2,5), (3,3), (4,3), (13,13), (20,20), (21,21), (21,21), (22,22), (24,24), (25,25), (50,50), (99,99), (100,100), (100,100)")) {
                throw new TestException("013.17 : " + od.toString());
            }
            if (od.size() != 21) {
                throw new TestException("013.18 : " + od.size());
            }
            if (od.isEmpty()) {
                throw new TestException("013.19");
            }
        }

        { // test clear
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            od.clear();
            if (od.size() != 0) {
                throw new TestException("014 : " + od.size());
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
                throw new TestException("017 : " + od.size());
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
                throw new TestException("020 : " + od.size());
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
                throw new TestException("023 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("024");
            }
            if (! od.toString().equals("")) {
                throw new TestException("025 : " + od.toString());
            }

            od.clear();
            if (od.size() != 0) {
                throw new TestException("026 : " + od.size());
            }
            if (! od.isEmpty()) {
                throw new TestException("027");
            }
            if (! od.toString().equals("")) {
                throw new TestException("028 : " + od.toString());
            }
        }

        { // find
            OrderedDictionary<Integer, Integer> od = createOD(implementation);
            try {
                od.find(0);
                throw new TestException("029.01");
            } catch (NoSuchElementException ex) {
            }
            try {
                od.find(12);
                throw new TestException("029.02");
            } catch (NoSuchElementException ex) {
            }
            od.insert(50, 50);
            try {
                od.find(12);
                throw new TestException("029.03");
            } catch (NoSuchElementException ex) {
            }
            od.insert(10, 10);
            try {
                od.find(12);
                throw new TestException("029.04");
            } catch (NoSuchElementException ex) {
            }
            od.insert(12,12);
            Integer found;
            found = od.find(12);
            if (found.compareTo(12) != 0) {
                throw new TestException("029.05 : " + found);
            }
            try {
                od.find(-100);
                throw new TestException("029.06");
            } catch (NoSuchElementException ex) {
            }
            try {
                od.find(100);
                throw new TestException("029.07");
            } catch (NoSuchElementException ex) {
            }
            found = od.find(12);
            if (found.compareTo(12) != 0) {
                throw new TestException("029.08 : " + found);
            }
            od.insert(12,12);
            found = od.find(12);
            if (found.compareTo(12) != 0) {
                throw new TestException("029.09 : " + found);
            }
            try {
                od.find(-100);
                throw new TestException("029.10");
            } catch (NoSuchElementException ex) {
            }
            try {
                od.find(100);
                throw new TestException("029.11");
            } catch (NoSuchElementException ex) {
            }
            found = od.find(12);
            if (found.compareTo(12) != 0) {
                throw new TestException("029.12 : " + found);
            }

            OrderedDictionary<Integer, String> od2 = createOD(implementation);
            for (int i=0; i<LONG_TEST_KEYS.length; i++) {
                od2.insert(LONG_TEST_KEYS[i], LONG_TEST_INFO[i]);
            }
            String f;
            for (int i=LONG_TEST_KEYS.length-1; i>=0; i--) {
                f = od2.find(LONG_TEST_KEYS[i]);
                if (! f.equals(LONG_TEST_INFO[i])) {
                    throw new TestException("030 "  + i + ", " + f + ", " + LONG_TEST_INFO[i]);
                }
            }
            for (int i=0; i<LONG_TEST_KEYS.length; i++) {
                f = od2.find(LONG_TEST_KEYS[i]);
                if (! f.equals(LONG_TEST_INFO[i])) {
                    throw new TestException("031 "  + i + ", " + f + ", " + LONG_TEST_INFO[i]);
                }
            }
            od2.clear();
            try {
                for (int i=0; i<LONG_TEST_KEYS.length; i++) {
                    f = od2.find(LONG_TEST_KEYS[i]);
                    throw new TestException("032 "  + i + ", " + f);
                }
            } catch (NoSuchElementException ex) {
            }
            for (int i=0; i<LONG_TEST_KEYS.length; i++) {
                od2.insert(LONG_TEST_KEYS[i], LONG_TEST_INFO[i]);
            }
            for (int i=LONG_TEST_KEYS.length-1; i>=0; i--) {
                f = od2.find(LONG_TEST_KEYS[i]);
                if (! f.equals(LONG_TEST_INFO[i])) {
                    throw new TestException("033 "  + i + ", " + f + ", " + LONG_TEST_INFO[i]);
                }
            }
        }

        { // remove
            OrderedDictionary<Integer, String> od = createOD(implementation);
            for (int i=0; i<LONG_TEST_KEYS.length; i++) {
                od.insert(LONG_TEST_KEYS[i], LONG_TEST_INFO[i]);
            }
            String found;
            String removed;
            for (int i=0; i<LONG_TEST_KEYS.length; i++) {
                removed = od.remove(LONG_TEST_KEYS[i]);
                if (! removed.equals(LONG_TEST_INFO[i])) {
                    throw new TestException("034 "  + i + ", " + removed + ", " + LONG_TEST_INFO[i]);
                }
                for (int j=0; j<i; j++) {
                    try {
                        od.find(LONG_TEST_KEYS[j]);
                    } catch (NoSuchElementException ex) {
                    }
                }
            }
        }
        return true;
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
