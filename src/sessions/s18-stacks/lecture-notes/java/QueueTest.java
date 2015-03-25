import java.util.NoSuchElementException;

class QueueTest {

    private static final String ARRAY_QUEUE = "A";
    private static final String LINKED_QUEUE = "L";
    private static String implementation;

    private static <E> Queue<E> newQueue(int capacity) {
        Queue<E> s;
        switch (implementation) {
            case ARRAY_QUEUE:
                s = new ArrayQueue<E>(capacity);
                break;
            case LINKED_QUEUE:
                s = new LinkedQueue<E>();
                break;
            default:
                throw new TypeNotPresentException(
                        "Unexpected implementation: " + implementation, null);
        }
        return s;
    }

    public static void main(String args[]) {
        if (args.length == 1
                && (args[0].equals(ARRAY_QUEUE)
                    || args[0].equals(LINKED_QUEUE))) {
            implementation = args[0];
        } else {
            System.err.println("ERROR: one argument expected (" +
                   ARRAY_QUEUE + " or " + LINKED_QUEUE + ")");
            System.exit(-1);
        }

        // ctor exception
        if (implementation.equals(ARRAY_QUEUE)) {
            try {
                Queue<Integer> s = newQueue(-1);
                System.out.println("ERROR -001");
            } catch (IllegalArgumentException ex) {
                // ok
            } catch (Exception ex) {
                System.out.println("ERROR 000");
            }

            // ctor exception again
            try {
                Queue<Integer> s = newQueue(0);
                System.out.println("ERROR 001");
            } catch (IllegalArgumentException ex) {
                // ok
            } catch (Exception ex) {
                System.out.println("ERROR 002");
            }
        }

        // enqueue and dequeue not full or empty queue
        try {
            Queue<Integer> s = newQueue(4);
            if (! s.isEmpty()) {
                System.out.println("ERROR 003");
            }

            s.enqueue(0);
            if (s.isEmpty()) {
                System.out.println("ERROR 004");
            }
            if (0 != s.front()) {
                System.out.println("ERROR 005");
            }

            s.enqueue(1);
            if (s.isEmpty()) {
                System.out.println("ERROR 006");
            }
            if (0 != s.front()) {
                System.out.println("ERROR 007");
            }

            s.enqueue(2);
            if (s.isEmpty()) {
                System.out.println("ERROR 008");
            }
            if (0 != s.front()) {
                System.out.println("ERROR 009");
            }

            s.enqueue(3);
            if (s.isEmpty()) {
                System.out.println("ERROR 010");
            }
            if (0 != s.front()) {
                System.out.println("ERROR 011");
            }

            Integer r = s.dequeue();
            if (s.isEmpty()) {
                System.out.println("ERROR 012");
            }
            if (1 != s.front()) {
                System.out.println("ERROR 013");
            }
            if (r != 0) {
                System.out.println("ERROR 014");
            }

            r = s.dequeue();
            if (s.isEmpty()) {
                System.out.println("ERROR 015");
            }
            if (2 != s.front()) {
                System.out.println("ERROR 016");
            }
            if (r != 1) {
                System.out.println("ERROR 017");
            }

            r = s.dequeue();
            if (s.isEmpty()) {
                System.out.println("ERROR 018");
            }
            if (3 != s.front()) {
                System.out.println("ERROR 019");
            }
            if (r != 2) {
                System.out.println("ERROR 020");
            }

            r = s.dequeue();
            if (! s.isEmpty()) {
                System.out.println("ERROR 021");
            }
            if (r != 3) {
                System.out.println("ERROR 022");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }


        // front on empty queue
        try {
            Queue<Integer> s = newQueue(4);
            s.front();
            System.out.println("ERROR 023");
        } catch (NoSuchElementException ex) {
            // OK
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        {
            Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.dequeue();
            try {
                s.front();
                System.out.println("ERROR 024");
            } catch (NoSuchElementException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.enqueue(0);
            s.dequeue();
            s.dequeue();
            try {
                s.front();
                System.out.println("ERROR 025");
            } catch (NoSuchElementException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
           Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.enqueue(0);
            s.enqueue(0);
            s.enqueue(0);
            s.dequeue();
            s.dequeue();
            s.dequeue();
            s.dequeue();
            try {
                s.front();
                System.out.println("ERROR 026");
            } catch (NoSuchElementException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        // dequeue on empty queue
        try {
            Queue<Integer> s = newQueue(4);
            s.dequeue();
            System.out.println("ERROR 027");
        } catch (NoSuchElementException ex) {
            // OK
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        {
            Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.dequeue();
            try {
                s.dequeue();
                System.out.println("ERROR 028");
            } catch (NoSuchElementException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.enqueue(0);
            s.dequeue();
            s.dequeue();
            try {
                s.dequeue();
                System.out.println("ERROR 029");
            } catch (NoSuchElementException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.enqueue(0);
            s.enqueue(0);
            s.enqueue(0);
            s.dequeue();
            s.dequeue();
            s.dequeue();
            s.dequeue();
            try {
                s.dequeue();
                System.out.println("ERROR 030");
            } catch (NoSuchElementException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        // test wraps
        {
            int expected;
            int extracted;
            Queue<Integer> s = newQueue(5);
            s.enqueue(0);
            s.enqueue(1);
            s.enqueue(2);
            s.enqueue(3);
            // 0 1 2 3 -
            expected = 0;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-a: extracted " +
                        extracted + " expected " + expected);
            }
            // - 1 2 3 -
            expected = 1;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-b: extracted " +
                        extracted + " expected " + expected);
            }
            // - - 2 3 -
            expected = 2;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-c: extracted " +
                        extracted + " expected " + expected);
            }
            // - - - 3 -
            s.enqueue(4);
            s.enqueue(5);
            s.enqueue(6);
            // 5 6 - 3 4
            expected = 3;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-e: extracted " +
                        extracted + " expected " + expected);
            }
            // 5 6 - - 4
            expected = 4;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-f: extracted " +
                        extracted + " expected " + expected);
            }
            // 5 6 - - -
            expected = 5;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-g: extracted " +
                        extracted + " expected " + expected);
            }
            // - 6 - - -
            s.enqueue(7);
            s.enqueue(8);
            s.enqueue(9);
            s.enqueue(10);
            // 10 6 7 8 9
            expected = 6;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-h: extracted " +
                        extracted + " expected " + expected);
            }
            // 10 - 7 8 9
            expected = 7;
            extracted = s.dequeue();
            if (extracted != expected) {
                System.out.println("ERROR 30-i: extracted " +
                        extracted + " expected " + expected);
            }
            // 10 - - 8 9
            s.enqueue(11);
            s.enqueue(12);
            // 10 11 12 8 9
            for (expected=8; expected<13; expected++) {
                extracted = s.dequeue();
                if (extracted != expected) {
                    System.out.println("ERROR 30-j: extracted " +
                            extracted + " expected " + expected);
                }
            }
            if (!s.isEmpty()) {
                System.out.println("ERROR 30-k");
            }
        }

        // stress test
        {
            int max = 120_000;
            if (max % 4 != 0) {
                System.err.println("ABORT max must be divisible by 4");
                System.exit(-1);
            }
            Queue<Integer> s = newQueue(max);
            // enqueue 0..max-1
            for (int i=0; i<max; i++) {
                s.enqueue(i);
            }
            // dequeue first half
            {
                int expected = 0;
                int extracted;
                for (int i=0; i<(max/2); i++) {
                    extracted = s.dequeue();
                    if (extracted != expected) {
                        System.out.println("ERROR 30-A: extracted " +
                                extracted + " expected " + expected);
                    }
                    //System.out.println("DEBUG 30-A: extracted " +
                    //        extracted + " expected " + expected);
                    expected++;
                }
            }
            // enqueue max..max+max/2-1
            for (int i=max; i<(max + max/2); i++) {
                s.enqueue(i);
            }
            // dequeue all
            {
                int expected = max/2;
                int extracted;
                while (! s.isEmpty()) {
                    extracted = s.dequeue();
                    if (extracted != expected) {
                        System.out.println("ERROR 30-B: extracted " +
                                extracted + " expected " + expected);
                    }
                    //System.out.println("DEBUG 30-B: extracted " +
                    //        extracted + " expected " + expected);
                    expected++;
                }
            }

            // enqueue 10..10+max-1
            for (int i=10; i<(10+max); i++) {
                s.enqueue(i);
            }
            // dequeue first half
            {
                int expected = 10;
                int extracted;
                for (int i=0; i<(max/2); i++) {
                    extracted = s.dequeue();
                    if (extracted != expected) {
                        System.out.println("ERROR 30-C: extracted " +
                                extracted + " expected " + expected);
                    }
                    //System.out.println("DEBUG 30-C: extracted " +
                    //        extracted + " expected " + expected);
                    expected++;
                }
            }
            // enqueue 10+max..10+max+max/2-1
            for (int i=10+max; i<(10 + max + max/2); i++) {
                s.enqueue(i);
            }
            // dequeue first quarter
            {
                int expected = 10+(max/2);
                int extracted;
                for (int i=0; i<(max/4); i++) {
                    extracted = s.dequeue();
                    if (extracted != expected) {
                        System.out.println("ERROR 30-D: extracted " +
                                extracted + " expected " + expected);
                    }
                    //System.out.println("DEBUG 30-D: extracted " +
                    //        extracted + " expected " + expected);
                    expected++;
                }
            }
            // enqueue 10 + max + max/2 .. 10 + max + max/2 + max/4
            for (int i=10+max+max/2; i<(10 + max + max/2 + max/4); i++) {
                s.enqueue(i);
            }
            // dequeue half
            {
                int expected = 10+(max/2)+(max/4);
                int extracted;
                for (int i=0; i<(max/2); i++) {
                    extracted = s.dequeue();
                    if (extracted != expected) {
                        System.out.println("ERROR 30-E: extracted " +
                                extracted + " expected " + expected);
                    }
                    //System.out.println("DEBUG 30-E: extracted " +
                    //        extracted + " expected " + expected);
                    expected++;
                }
            }
            // enqueue 10 + max + max/2 + max/4 .. 10 + max + max/2 + max/4 + max/2
            for (int i=10+max+max/2+max/4; i<(10 + max + max/2 + max/4 + max/2); i++) {
                s.enqueue(i);
            }
            // dequeue all
            {
                int expected = 10+(max/2)+(max/4)+(max/2);
                int extracted;
                while(! s.isEmpty()) {
                    extracted = s.dequeue();
                    if (extracted != expected) {
                        System.out.println("ERROR 30-F: extracted " +
                                extracted + " expected " + expected);
                    }
                    //System.out.println("DEBUG 30-F: extracted " +
                    //        extracted + " expected " + expected);
                    expected++;
                }
            }
        }


        // enqueue on full queue
        if (implementation.equals(ARRAY_QUEUE)) {
            {
                Queue<Integer> s = newQueue(4);
                s.enqueue(0);
                s.enqueue(0);
                s.enqueue(0);
                s.enqueue(0);
                try {
                    s.enqueue(0);
                    System.out.println("ERROR 031");
                } catch (IllegalStateException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
            {
                Queue<Integer> s = newQueue(4);
                s.enqueue(0);
                s.dequeue();
                s.enqueue(0);
                s.enqueue(0);
                s.enqueue(0);
                s.dequeue();
                s.enqueue(0);
                s.enqueue(0);
                s.dequeue();
                s.dequeue();
                s.dequeue();
                s.enqueue(0);
                s.dequeue();
                s.enqueue(0);
                s.enqueue(0);
                s.enqueue(0);
                try {
                    s.enqueue(0);
                    System.out.println("ERROR 032");
                } catch (IllegalStateException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }

        // toString
        {
            Queue<Integer> s = newQueue(4);
            // System.out.println(s);
            if (! "Queue {(front)}".equals(s.toString())) {
                System.out.println("ERROR 033");
            }
            s.enqueue(0);
            // System.out.println(s);
            if (! "Queue {0 (front)}".equals(s.toString())) {
                System.out.println("ERROR 034");
            }
            s.enqueue(1);
            // System.out.println(s);
            if (! "Queue {1, 0 (front)}".equals(s.toString())) {
                System.out.println("ERROR 035");
            }
            s.enqueue(2);
            // System.out.println(s);
            if (! "Queue {2, 1, 0 (front)}".equals(s.toString())) {
                System.out.println("ERROR 036");
            }
            s.enqueue(3);
            // System.out.println(s);
            if (! "Queue {3, 2, 1, 0 (front)}".equals(s.toString())) {
                System.out.println("ERROR 037");
            }
            s.dequeue();
            // System.out.println(s);
            if (! "Queue {3, 2, 1 (front)}".equals(s.toString())) {
                System.out.println("ERROR 038");
            }
            s.dequeue();
            // System.out.println(s);
            if (! "Queue {3, 2 (front)}".equals(s.toString())) {
                System.out.println("ERROR 039");
            }
            s.dequeue();
            // System.out.println(s);
            if (! "Queue {3 (front)}".equals(s.toString())) {
                System.out.println("ERROR 040");
            }
            s.dequeue();
            // System.out.println(s);
            if (! "Queue {(front)}".equals(s.toString())) {
                System.out.println("ERROR 041");
            }
        }

        // nulls
        {
            Queue<Integer> s = newQueue(4);
            try {
                s.enqueue(null);
                System.out.println("ERROR 042");
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Queue<Integer> s = newQueue(4);
            s.enqueue(0);
            s.enqueue(1);
            try {
                s.enqueue(null);
                System.out.println("ERROR 043");
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
