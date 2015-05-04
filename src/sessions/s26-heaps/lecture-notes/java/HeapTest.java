import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Collections;

class HeapTest {

    private static void test(Heap<Integer, String> heap, int size, String expected, String error) {
        if ( ! expected.equals(heap.toString())) {
            System.err.println("ERROR " + error + " (toString)");
            System.out.println("    should be : " + expected);
            System.out.println("    but it is : " + heap.toString());
            System.exit(1);
        }
        if (heap.size() != size) {
            System.err.println("ERROR " + error + " (size)");
            System.out.println("    should be : " + size);
            System.out.println("    but it is : " + heap.size());
            System.exit(1);
        }
        if (heap.isEmpty() != (size == 0)) {
            System.err.println("ERROR " + error + " (isEmpty)");
            System.out.println("    should be : " + (size == 0));
            System.out.println("    but it is : " + heap.isEmpty());
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        {
            Heap<Integer, String> heap;
            int size;
            String expected;

            heap = new Heap<Integer, String>();
            size = 0;
            expected = "{(max)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "000");

            heap = new Heap<Integer, String>();
            size = 1;
            expected = "{(max) (1, 1)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "001");

            heap = new Heap<Integer, String>();
            size = 2;
            expected = "{(max) (2, 2) (1, 1)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "002");

            heap = new Heap<Integer, String>();
            size = 3;
            expected = "{(max) (3, 3) (1, 1) (2, 2)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "003");

            heap = new Heap<Integer, String>();
            size = 4;
            expected = "{(max) (4, 4) (3, 3) (2, 2) (1, 1)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "004");

            heap = new Heap<Integer, String>();
            size = 5;
            expected = "{(max) (5, 5) (4, 4) (2, 2) (1, 1) (3, 3)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "005");

            heap = new Heap<Integer, String>();
            size = 6;
            expected = "{(max) (6, 6) (4, 4) (5, 5) (1, 1) (3, 3) (2, 2)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "006");

            heap = new Heap<Integer, String>();
            size = 7;
            expected = "{(max) (7, 7) (4, 4) (6, 6) (1, 1) (3, 3) (2, 2) (5, 5)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "007");

            heap = new Heap<Integer, String>();
            size = 8;
            expected = "{(max) (8, 8) (7, 7) (6, 6) (4, 4) (3, 3) (2, 2) (5, 5) (1, 1)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "008");

            heap = new Heap<Integer, String>();
            size = 15;
            expected = "{(max) (15, 15) (10, 10) (14, 14) (7, 7) (9, 9) (11, 11) (13, 13) (1, 1) (4, 4) (3, 3) (8, 8) (2, 2) (6, 6) (5, 5) (12, 12)}";
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }
            test(heap, size, expected, "015");
        }

        {
            Heap<Integer, String> heap;
            int size;
            String expected;
            String result;
            String expectedString;

            heap = new Heap<Integer, String>();
            size = 15;
            for (int i=1; i<=size; i++) {
                heap.insert(i, "" + i);
            }

            expected = "15";
            expectedString = "{(max) (14, 14) (10, 10) (13, 13) (7, 7) (9, 9) (11, 11) (12, 12) (1, 1) (4, 4) (3, 3) (8, 8) (2, 2) (6, 6) (5, 5)}";
            size = 14;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 100 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "100");

            expected = "14";
            expectedString = "{(max) (13, 13) (10, 10) (12, 12) (7, 7) (9, 9) (11, 11) (5, 5) (1, 1) (4, 4) (3, 3) (8, 8) (2, 2) (6, 6)}";
            size = 13;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 101 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "101");

            expected = "13";
            expectedString = "{(max) (12, 12) (10, 10) (11, 11) (7, 7) (9, 9) (6, 6) (5, 5) (1, 1) (4, 4) (3, 3) (8, 8) (2, 2)}";
            size = 12;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 102 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "102");

            expected = "12";
            expectedString = "{(max) (11, 11) (10, 10) (6, 6) (7, 7) (9, 9) (2, 2) (5, 5) (1, 1) (4, 4) (3, 3) (8, 8)}";
            size = 11;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 103 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "103");

            expected = "11";
            expectedString = "{(max) (10, 10) (9, 9) (6, 6) (7, 7) (8, 8) (2, 2) (5, 5) (1, 1) (4, 4) (3, 3)}";
            size = 10;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 104 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "104");

            expected = "10";
            expectedString = "{(max) (9, 9) (8, 8) (6, 6) (7, 7) (3, 3) (2, 2) (5, 5) (1, 1) (4, 4)}";
            size = 9;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 105 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "105");

            expected = "9";
            expectedString = "{(max) (8, 8) (7, 7) (6, 6) (4, 4) (3, 3) (2, 2) (5, 5) (1, 1)}";
            size = 8;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 106 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "106");

            expected = "8";
            expectedString = "{(max) (7, 7) (4, 4) (6, 6) (1, 1) (3, 3) (2, 2) (5, 5)}";
            size = 7;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 107 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "107");

            expected = "7";
            expectedString = "{(max) (6, 6) (4, 4) (5, 5) (1, 1) (3, 3) (2, 2)}";
            size = 6;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 108 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "108");

            expected = "6";
            expectedString = "{(max) (5, 5) (4, 4) (2, 2) (1, 1) (3, 3)}";
            size = 5;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 109 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "109");

            expected = "5";
            expectedString = "{(max) (4, 4) (3, 3) (2, 2) (1, 1)}";
            size = 4;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 110 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "110");

            expected = "4";
            expectedString = "{(max) (3, 3) (1, 1) (2, 2)}";
            size = 3;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 111 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "111");

            expected = "3";
            expectedString = "{(max) (2, 2) (1, 1)}";
            size = 2;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 112 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "112");

            expected = "2";
            expectedString = "{(max) (1, 1)}";
            size = 1;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 113 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "113");

            expected = "1";
            expectedString = "{(max)}";
            size = 0;
            result = heap.removeMax();
            if ( ! result.equals(expected)) {
                System.err.println("ERROR 114 (result)");
                System.err.println("    should be : " + expected);
                System.err.println("    but it is : " + result);
                System.exit(1);
            }
            test(heap, size, expectedString, "114");

            expectedString = "{(max)}";
            size = 0;
            try {
                result = heap.removeMax();
                System.err.println("ERROR 115");
                System.exit(1);
            } catch (NoSuchElementException ex) {}
            test(heap, size, expectedString, "115");
        }

        // test the Heap agains a Java priority queue with random
        // inserts, and extracts.
        {
            int data_size = 1_000;
            int num_inserts = 1_000_000;
            Random rand = new Random();
            Heap<Integer, String> heap = new Heap<Integer, String>();
            java.util.PriorityQueue<Integer> java = new java.util.PriorityQueue<Integer>(
                    11, Collections.reverseOrder());

            int[] data = new int[data_size];
            for (int i=0; i<data_size; i++) {
                data[i] = i;
            }

            boolean mustRemove;
            for (int i=0; i<num_inserts; i++) {
                int random_data_index = rand.nextInt(data_size);
                int datum = data[random_data_index];
                heap.insert(datum, "" + datum);
                java.add(datum);

                mustRemove = rand.nextInt(100) < 30;
                if (mustRemove) {
                    String mine = heap.removeMax();
                    String official = "" + java.poll();
                    if ( ! mine.equals(official)) {
                        System.err.println("ERROR random:");
                        System.err.println("    java returned : " + official);
                        System.err.println("    mine returned : " + mine);
                        System.out.println(java);
                        System.out.println(heap);
                        System.exit(1);
                    }
                }
            }

            int size = java.size();
            for (int i=0; i<size; i++) {
                String mine = heap.removeMax();
                String official = "" + java.poll();
                if ( ! mine.equals(official)) {
                    System.err.println("ERROR random:");
                    System.err.println("    java returned : " + official);
                    System.err.println("    mine returned : " + mine);
                    System.out.println(java);
                    System.out.println(heap);
                    System.exit(1);
                }
            }

            if ( ! heap.isEmpty()) {
                System.err.println("ERROR not empty");
                System.out.println(java.size());
                System.out.println(heap.size());
                System.exit(1);
            }
        }
    }
}
