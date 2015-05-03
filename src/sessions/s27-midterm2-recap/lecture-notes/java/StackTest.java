class StackTest {
    private static Stack createStack(String type) {
        switch (type) {
            case "A":
                return new ArrayStack();
            case "L":
                return new LinkedStack();
            default:
                System.err.println("Unsupported Stack type: " + type);
                System.exit(1);
                return null;
        }
    }

    public static void main(String args[]) {
        Stack s = createStack(args[0]);
        int result;

        try {
            s.pop();
        } catch (java.util.EmptyStackException ex) {
            // ok
        } catch (Exception ex) {
            System.err.println("ERROR 001");
            System.exit(1);
        }

        try {
            s.push(10);
        } catch (Exception ex) {
            System.err.println("ERROR 002");
            System.exit(1);
        }

        try {
            result = s.pop();
            if (result != 10) {
                System.err.println("ERROR 003");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.err.println("ERROR 004");
            System.exit(1);
        }

        try {
            s.push(10);
            s.push(20);
            s.push(30);
        } catch (Exception ex) {
            System.err.println("ERROR 005");
            System.exit(1);
        }

        try {
            result = s.pop();
            if (result != 30) {
                System.err.println("ERROR 006");
                System.exit(1);
            }
            result = s.pop();
            if (result != 20) {
                System.err.println("ERROR 007");
                System.exit(1);
            }
            result = s.pop();
            if (result != 10) {
                System.err.println("ERROR 008");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.err.println("ERROR 009");
            System.exit(1);
        }
        try {
            s.pop();
        } catch (java.util.EmptyStackException ex) {
            // ok
        } catch (Exception ex) {
            System.err.println("ERROR 010");
            System.exit(1);
        }

        int max = 10000;
        try {
            for (int i=0; i<max; i++) {
                s.push(100 + i);
            }
        } catch (Exception ex) {
            System.err.println("ERROR 011");
            System.exit(1);
        }

        try {
            for (int i=max-1; i>0; i--) {
                result = s.pop();
                if (result != 100+i) {
                    System.err.println("ERROR 021");
                    System.exit(1);
                }
            }
        } catch (Exception ex) {
            System.err.println("ERROR 022");
            ex.printStackTrace();
            System.exit(1);
        }
        try {
            s.pop();
        } catch (java.util.EmptyStackException ex) {
            // ok
        } catch (Exception ex) {
            System.err.println("ERROR 023");
            System.exit(1);
        }
    }
}
