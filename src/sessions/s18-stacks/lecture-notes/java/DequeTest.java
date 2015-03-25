import java.util.NoSuchElementException;
import java.util.Iterator;

class DequeTest {

    private static final String ARRAY_DEQUE = "A";
    private static final String LINKED_DEQUE = "L";
    private static final String JAVA_DEQUE = "J";
    private static String implementation;
    private static boolean debug;

    private static class JavaDeque<E>
            extends java.util.ArrayDeque<E> implements Deque<E> {
        public void addHead(E e) { addFirst(e); }
        public void addTail(E e) { addLast(e); }
        public E removeHead() { return removeFirst(); }
        public E removeTail() { return removeLast(); }
        public String toString() {
            StringBuffer sb = new StringBuffer("");
            for (Iterator<E> i=this.iterator(); i.hasNext();) {
                sb.append(i.next());
                if (i.hasNext()) {
                    sb.append(", ");
                } else {
                    sb.append(" ");
                }
            }
            sb.insert(0, "Deque {(head) ");
            sb.append("(tail)}");
            return sb.toString();
        }
    }

    private static <E> Deque<E> newDeque(String implementation, int capacity) {
        Deque<E> d;
        switch (implementation) {
            case ARRAY_DEQUE:
                d = new ArrayDeque<E>(capacity);
                break;
            case LINKED_DEQUE:
                d = new LinkedDeque<E>();
                break;
            case JAVA_DEQUE:
                d = new JavaDeque<E>();
                break;
            default:
                throw new TypeNotPresentException(
                        "Unexpected implementation: " + implementation, null);
        }
        return d;
    }

    private static <E> void compare(Deque<E> j, Deque<E> m, String error) {
        debug(j, m);
        String js = j.toString();
        String ms = m.toString();
        if (! js.equals(ms) ||
                j.isEmpty() != m.isEmpty()) {
            System.out.println(error);
            print(j, m);
            System.exit(-1);
        }
    }

    private static void compare(int j, int m, String error) {
        if (j != m) {
            System.out.println(error + " expected: " + j +
                    "extracted: " + m);
            System.exit(-1);
        }
    }

    private static <E> void print(Deque<E> j, Deque<E> m) {
        System.out.println("---> java (" + j.isEmpty() + ") " + j);
        System.out.println("---> mine (" + m.isEmpty() + ") " + m);
    }

    private static <E> void debug(Deque<E> j, Deque<E> m) {
        if (debug) {
            print(j, m);
        }
    }

    public static void main(String args[]) {
        if (args.length == 1
                && (args[0].equals(ARRAY_DEQUE)
                    || args[0].equals(LINKED_DEQUE))) {
            implementation = args[0];
            debug = false;
        } else if (args.length == 2
                && (args[0].equals(ARRAY_DEQUE)
                    || args[0].equals(LINKED_DEQUE))
                && args[1].equals("D")) {
            implementation = args[0];
            debug = true;
        } else {
            System.err.println("USAGE: [" + ARRAY_DEQUE + ", "
                    + LINKED_DEQUE + "] [D]");
            System.exit(-1);
        }

        {
            Deque<Integer> j, m;
            int ji, mi;

            j = newDeque("J", 5);
            m = newDeque(implementation, 5);
            // - - - - -
            compare(j, m, "ERROR 001");

            j.addTail(0); m.addTail(0);
            // 0 - - - -
            compare(j, m, "ERROR 002");

            ji = j.removeHead(); mi = m.removeHead();
            // - - - - -
            compare(ji, mi, "ERROR 003");
            compare(j, m, "ERROR 003");

            j.addTail(1); m.addTail(1);
            // 1 - - - -
            compare(j, m, "ERROR 004");

            j.addTail(2); m.addTail(2);
            // 1 2 - - -
            compare(j, m, "ERROR 005");

            ji = j.removeHead(); mi = m.removeHead();
            // - 2 - - -
            compare(ji, mi, "ERROR 006");
            compare(j, m, "ERROR 006");

            ji = j.removeHead(); mi = m.removeHead();
            // - - - - -
            compare(ji, mi, "ERROR 007");
            compare(j, m, "ERROR 007");

            j.addTail(3); m.addTail(3);
            j.addTail(4); m.addTail(4);
            j.addTail(5); m.addTail(5);
            j.addTail(6); m.addTail(6);
            j.addTail(7); m.addTail(7);
            // 3 4 5 6 7
            compare(j, m, "ERROR 008");

            ji = j.removeHead(); mi = m.removeHead();
            // - 4 5 6 7
            compare(ji, mi, "ERROR 009");
            compare(j, m, "ERROR 009");

            ji = j.removeHead(); mi = m.removeHead();
            // - - 5 6 7
            compare(ji, mi, "ERROR 010");
            compare(j, m, "ERROR 010");

            ji = j.removeHead(); mi = m.removeHead();
            // - - - 6 7
            compare(ji, mi, "ERROR 011");
            compare(j, m, "ERROR 011");

            ji = j.removeHead(); mi = m.removeHead();
            // - - - - 7
            compare(ji, mi, "ERROR 012");
            compare(j, m, "ERROR 012");

            ji = j.removeHead(); mi = m.removeHead();
            // - - - - -
            compare(ji, mi, "ERROR 013");
            compare(j, m, "ERROR 013");

            j.addTail(0); m.addTail(0);
            j.addTail(1); m.addTail(1);
            j.addTail(2); m.addTail(2);
            j.addTail(3); m.addTail(3);
            j.addTail(4); m.addTail(4);
            // 0 1 2 3 4
            ji = j.removeHead(); mi = m.removeHead();
            ji = j.removeHead(); mi = m.removeHead();
            ji = j.removeHead(); mi = m.removeHead();
            // - - - 3 4
            compare(ji, mi, "ERROR 014");
            compare(j, m, "ERROR 014");
            j.addTail(5); m.addTail(5);
            j.addTail(6); m.addTail(6);
            // 5 6 - 3 4
            compare(j, m, "ERROR 015");
            ji = j.removeHead(); mi = m.removeHead();
            // 5 6 - - 4
            compare(ji, mi, "ERROR 016");
            compare(j, m, "ERROR 016");
            j.addTail(7); m.addTail(7);
            j.addTail(8); m.addTail(8);
            // 5 6 7 8 4
            compare(j, m, "ERROR 017");
            ji = j.removeHead(); mi = m.removeHead();
            ji = j.removeHead(); mi = m.removeHead();
            ji = j.removeHead(); mi = m.removeHead();
            ji = j.removeHead(); mi = m.removeHead();
            // - - - 8 -
            j.addTail(9); m.addTail(9);
            j.addTail(10); m.addTail(10);
            j.addTail(11); m.addTail(11);
            // 10 11 - 8 9
            compare(j, m, "ERROR 018");

            j.addHead(7); m.addHead(7);
            // 10 11 7 8 9
            compare(j, m, "ERROR 019");

            ji = j.removeTail(); mi = m.removeTail();
            // 10 - 7 8 9
            compare(ji, mi, "ERROR 020");
            compare(j, m, "ERROR 020");

            j.addHead(6); m.addHead(6);
            // 10 6 7 8 9
            compare(j, m, "ERROR 021");

            ji = j.removeTail(); mi = m.removeTail();
            // - 6 7 8 9
            compare(ji, mi, "ERROR 022");
            compare(j, m, "ERROR 022");

            ji = j.removeTail(); mi = m.removeTail();
            // - 6 7 8 -
            compare(ji, mi, "ERROR 023");
            compare(j, m, "ERROR 023");

            j.addHead(5); m.addHead(5);
            j.addHead(4); m.addHead(4);
            // 5 6 7 8 4
            compare(j, m, "ERROR 024");

            ji = j.removeHead(); mi = m.removeHead();
            ji = j.removeHead(); mi = m.removeHead();
            // - 6 7 8 -
            ji = j.removeTail(); mi = m.removeTail();
            ji = j.removeTail(); mi = m.removeTail();
            // - 6 - - -
            compare(ji, mi, "ERROR 025");
            compare(j, m, "ERROR 025");

            j.addHead(1); m.addHead(1);
            j.addHead(0); m.addHead(0);
            // 1 6 - - 0
            j.addTail(10); m.addTail(10);
            j.addTail(11); m.addTail(11);
            // 1 6 10 11 0
            compare(j, m, "ERROR 026");

            ji = j.removeTail(); mi = m.removeTail();
            ji = j.removeTail(); mi = m.removeTail();
            ji = j.removeTail(); mi = m.removeTail();
            ji = j.removeTail(); mi = m.removeTail();
            ji = j.removeTail(); mi = m.removeTail();
            // - - - - -
            compare(j, m, "ERROR 027");

            j.addHead(1); m.addHead(1);
            j.addHead(0); m.addHead(0);
            // 1 - - - 0
            compare(j, m, "ERROR 028");
            j.addHead(2); m.addHead(2);
            j.addHead(3); m.addHead(3);
            j.addHead(0); m.addHead(0);
            // 1 0 3 2 0
            compare(j, m, "ERROR 029");
        }

        { // addHead exceptions
            Deque<Integer> m;
            m = newDeque(implementation, 3);
            try {
                m.addHead(null);
                System.out.println("ERROR 030");
                System.exit(-1);
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            try {
                m.addHead(0);
                m.addHead(null);
                System.out.println("ERROR 031");
                System.exit(-1);
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            try {
                m.addHead(0);
                m.addHead(1);
                m.addHead(null);
                System.out.println("ERROR 032");
                System.exit(-1);
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }

        { // addTail exceptions
            Deque<Integer> m;
            m = newDeque(implementation, 3);
            try {
                m.addTail(null);
                System.out.println("ERROR 033");
                System.exit(-1);
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            try {
                m.addTail(0);
                m.addTail(null);
                System.out.println("ERROR 034");
                System.exit(-1);
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            try {
                m.addTail(0);
                m.addTail(1);
                m.addTail(null);
                System.out.println("ERROR 035");
                System.exit(-1);
            } catch (NullPointerException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }

        { // removeHead exceptions
            Deque<Integer> m;
            m = newDeque(implementation, 3);
            try {
                m.removeHead();
                System.out.println("ERROR 036");
                System.exit(-1);
            } catch (NoSuchElementException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            try {
                m.addTail(1);
                m.removeHead();
                m.removeHead();
                System.out.println("ERROR 037");
                System.exit(-1);
            } catch (NoSuchElementException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }

        { // removeTail exceptions
            Deque<Integer> m;
            m = newDeque(implementation, 3);
            try {
                m.removeTail();
                System.out.println("ERROR 038");
                System.exit(-1);
            } catch (NoSuchElementException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            try {
                m.addTail(1);
                m.removeHead();
                m.removeTail();
                System.out.println("ERROR 039");
                System.exit(-1);
            } catch (NoSuchElementException ex) {
                // ok
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }

        { // ArrayDeque specific exceptions
            if (implementation.equals(ARRAY_DEQUE)) {
                Deque<Integer> m;
                m = newDeque(implementation, 1);
                try {
                    m.addHead(1);
                    m.addHead(2);
                    System.out.println("ERROR 040");
                    System.exit(-1);
                } catch (IllegalStateException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(-1);
                }
                m = newDeque(implementation, 1);
                try {
                    m.addHead(1);
                    m.addTail(2);
                    System.out.println("ERROR 041");
                    System.exit(-1);
                } catch (IllegalStateException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(-1);
                }
                try {
                    m = newDeque(implementation, 0);
                    System.out.println("ERROR 042");
                    System.exit(-1);
                } catch (IllegalArgumentException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(-1);
                }
                try {
                    m = newDeque(implementation, -1);
                    System.out.println("ERROR 043");
                    System.exit(-1);
                } catch (IllegalArgumentException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.exit(-1);
                }
            }
        }
    }
}
