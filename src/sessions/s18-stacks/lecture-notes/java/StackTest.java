import java.util.EmptyStackException;

class StackTest {

    private static final String ARRAY_STACK = "A";
    private static final String LINKED_STACK = "L";
    private static String implementation;

    private static <E> Stack<E> newStack(int capacity) {
        Stack<E> s;
        switch (implementation) {
            case ARRAY_STACK:
                s = new ArrayStack<E>(capacity);
                break;
            case LINKED_STACK:
                s = new LinkedStack<E>();
                break;
            default:
                throw new TypeNotPresentException(
                        "Unexpected implementation: " + implementation, null);
        }
        return s;
    }

    public static void main(String args[]) {
        if (args.length == 1
                && (args[0].equals(ARRAY_STACK)
                    || args[0].equals(LINKED_STACK))) {
            implementation = args[0];
        } else {
            System.err.println("ERROR: one argument expected (" +
                   ARRAY_STACK + " or " + LINKED_STACK + ")");
            System.exit(-1);
        }

        // ctor exception
        if (implementation.equals(ARRAY_STACK)) {
            try {
                Stack<Integer> s = newStack(-1);
                System.out.println("ERROR -001");
            } catch (IllegalArgumentException ex) {
                // ok
            } catch (Exception ex) {
                System.out.println("ERROR 000");
            }

            // ctor exception again
            try {
                Stack<Integer> s = newStack(0);
                System.out.println("ERROR 001");
            } catch (IllegalArgumentException ex) {
                // ok
            } catch (Exception ex) {
                System.out.println("ERROR 002");
            }
        }

        // push and pop no overflow or empty stack
        try {
            Stack<Integer> s = newStack(4);
            if (! s.isEmpty()) {
                System.out.println("ERROR 003");
            }

            s.push(0);
            if (s.isEmpty()) {
                System.out.println("ERROR 004");
            }
            if (0 != s.peek()) {
                System.out.println("ERROR 005");
            }

            s.push(1);
            if (s.isEmpty()) {
                System.out.println("ERROR 006");
            }
            if (1 != s.peek()) {
                System.out.println("ERROR 007");
            }

            s.push(2);
            if (s.isEmpty()) {
                System.out.println("ERROR 008");
            }
            if (2 != s.peek()) {
                System.out.println("ERROR 009");
            }

            s.push(3);
            if (s.isEmpty()) {
                System.out.println("ERROR 010");
            }
            if (3 != s.peek()) {
                System.out.println("ERROR 011");
            }

            Integer r = s.pop();
            if (s.isEmpty()) {
                System.out.println("ERROR 012");
            }
            if (2 != s.peek()) {
                System.out.println("ERROR 013");
            }
            if (r != 3) {
                System.out.println("ERROR 014");
            }

            r = s.pop();
            if (s.isEmpty()) {
                System.out.println("ERROR 015");
            }
            if (1 != s.peek()) {
                System.out.println("ERROR 016");
            }
            if (r != 2) {
                System.out.println("ERROR 017");
            }

            r = s.pop();
            if (s.isEmpty()) {
                System.out.println("ERROR 018");
            }
            if (0 != s.peek()) {
                System.out.println("ERROR 019");
            }
            if (r != 1) {
                System.out.println("ERROR 020");
            }

            r = s.pop();
            if (! s.isEmpty()) {
                System.out.println("ERROR 021");
            }
            if (r != 0) {
                System.out.println("ERROR 022");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }


        // peek on empty stack
        try {
            Stack<Integer> s = newStack(4);
            s.peek();
            System.out.println("ERROR 023");
        } catch (EmptyStackException ex) {
            // OK
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        {
            Stack<Integer> s = newStack(4);
            s.push(0);
            s.pop();
            try {
                s.peek();
                System.out.println("ERROR 024");
            } catch (EmptyStackException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Stack<Integer> s = newStack(4);
            s.push(0);
            s.push(0);
            s.pop();
            s.pop();
            try {
                s.peek();
                System.out.println("ERROR 025");
            } catch (EmptyStackException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
           Stack<Integer> s = newStack(4);
            s.push(0);
            s.push(0);
            s.push(0);
            s.push(0);
            s.pop();
            s.pop();
            s.pop();
            s.pop();
            try {
                s.peek();
                System.out.println("ERROR 026");
            } catch (EmptyStackException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        // pop on empty stack
        try {
            Stack<Integer> s = newStack(4);
            s.pop();
            System.out.println("ERROR 027");
        } catch (EmptyStackException ex) {
            // OK
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        {
            Stack<Integer> s = newStack(4);
            s.push(0);
            s.pop();
            try {
                s.pop();
                System.out.println("ERROR 028");
            } catch (EmptyStackException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Stack<Integer> s = newStack(4);
            s.push(0);
            s.push(0);
            s.pop();
            s.pop();
            try {
                s.pop();
                System.out.println("ERROR 029");
            } catch (EmptyStackException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        {
            Stack<Integer> s = newStack(4);
            s.push(0);
            s.push(0);
            s.push(0);
            s.push(0);
            s.pop();
            s.pop();
            s.pop();
            s.pop();
            try {
                s.pop();
                System.out.println("ERROR 030");
            } catch (EmptyStackException ex) {
                // OK
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        // stress test
        {
            int max = 100_000;
            Stack<Integer> s = newStack(max);
            for (int i=0; i<max; i++) {
                s.push(i);
            }
            // System.out.println(s);
            Stack<Integer> s2 = newStack(max);
            while(! s.isEmpty()) {
                s2.push(s.pop());
            }
            // System.out.println(s2);
            for (int i=0; i<max; i++) {
                Integer r = s2.pop();
                if (i != r) {
                    System.out.println("ERROR 30-A: extracted " + r +
                            " expected " + i);
                    break;
                }
            }
        }


        // push on full stack
        if (implementation.equals(ARRAY_STACK)) {
            {
                Stack<Integer> s = newStack(4);
                s.push(0);
                s.push(0);
                s.push(0);
                s.push(0);
                try {
                    s.push(0);
                    System.out.println("ERROR 031");
                } catch (StackOverflowException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
            {
                Stack<Integer> s = newStack(4);
                s.push(0);
                s.pop();
                s.push(0);
                s.push(0);
                s.push(0);
                s.pop();
                s.push(0);
                s.push(0);
                s.pop();
                s.pop();
                s.pop();
                s.push(0);
                s.pop();
                s.push(0);
                s.push(0);
                s.push(0);
                try {
                    s.push(0);
                    System.out.println("ERROR 032");
                } catch (StackOverflowException ex) {
                    // ok
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }

        // toString
        Stack<Integer> s = newStack(4);
        // System.out.println(s);
        if (! "Stack {(top)}".equals(s.toString())) {
            System.out.println("ERROR 033");
        }
        s.push(0);
        // System.out.println(s);
        if (! "Stack {0 (top)}".equals(s.toString())) {
            System.out.println("ERROR 034");
        }
        s.push(1);
        // System.out.println(s);
        if (! "Stack {0, 1 (top)}".equals(s.toString())) {
            System.out.println("ERROR 035");
        }
        s.push(2);
        // System.out.println(s);
        if (! "Stack {0, 1, 2 (top)}".equals(s.toString())) {
            System.out.println("ERROR 036");
        }
        s.push(3);
        // System.out.println(s);
        if (! "Stack {0, 1, 2, 3 (top)}".equals(s.toString())) {
            System.out.println("ERROR 037");
        }
        s.pop();
        // System.out.println(s);
        if (! "Stack {0, 1, 2 (top)}".equals(s.toString())) {
            System.out.println("ERROR 038");
        }
        s.pop();
        // System.out.println(s);
        if (! "Stack {0, 1 (top)}".equals(s.toString())) {
            System.out.println("ERROR 039");
        }
        s.pop();
        // System.out.println(s);
        if (! "Stack {0 (top)}".equals(s.toString())) {
            System.out.println("ERROR 040");
        }
        s.pop();
        // System.out.println(s);
        if (! "Stack {(top)}".equals(s.toString())) {
            System.out.println("ERROR 041");
        }
    }
}
