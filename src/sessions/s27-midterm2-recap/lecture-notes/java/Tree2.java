class Tree2 {

    private class Node {
        int element;
        Node left;
        Node right;

        // in this definition nodes can be null
        Node(Node left, int element, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        String toStringInOrder() {
            String leftString =
                (left == null) ? "" : left.toStringInOrder();
            String rightString =
                (right == null) ? "" : right.toStringInOrder();
            return leftString + " " + element + " " + rightString;
        }

        int countLeafs() {
            if (left == null && right == null) { // base case
                return 1;
            } else { // recursive case
                int leftLeafs = (left == null) ? 0 : left.countLeafs();
                int rightLeafs = (right == null) ? 0 : right.countLeafs();
                return leftLeafs + rightLeafs;
            }
        }
    }

    private Node root;

    // empty btree
    public Tree2() {
        root = null;
    }

    // internal btree
    //
    // merging trees like this will make them empty.
    public Tree2(Tree2 left, int element, Tree2 right) {
        root = new Node(null, element, null);
        if (left != null) {
            root.left = left.root;
            left.root = null;
        }
        if (right != null) {
            root.right = right.root;
            right.root = null;
        }
    }

    // leaf
    public Tree2(int element) {
        this(null, element, null);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return root.toStringInOrder();
        }
    }

    public int countLeafs() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.countLeafs();
        }
    }

    public static void main(String args[]) {
        //          0
        //        /   \
        //       /     \
        //      1       2
        //     / \       \
        //    3   4       5
        //     \         /
        //      6       7
        //
        Tree2 t6 = new Tree2(6);
        Tree2 t3 = new Tree2(new Tree2(), 3, t6);
        Tree2 t4 = new Tree2(4);
        Tree2 t1 = new Tree2(t3, 1, t4);

        Tree2 t7 = new Tree2(7);
        Tree2 t5 = new Tree2(t7, 5, new Tree2());
        Tree2 t2 = new Tree2(new Tree2(), 2, t5);

        Tree2 t0 = new Tree2(t1, 0, t2);

        System.out.println("t0.toStringInOrder() = " + t0);
        System.out.println("t1.toStringInOrder() = " + t1);
        System.out.println("t2.toStringInOrder() = " + t2);
        System.out.println("t3.toStringInOrder() = " + t3);
        System.out.println("t4.toStringInOrder() = " + t4);
        System.out.println("t5.toStringInOrder() = " + t5);
        System.out.println("t6.toStringInOrder() = " + t6);
        System.out.println("t7.toStringInOrder() = " + t7);

        System.out.println("t0.countLeafs() = " + t0.countLeafs());
        System.out.println("t1.countLeafs() = " + t1.countLeafs());
        System.out.println("t2.countLeafs() = " + t2.countLeafs());
        System.out.println("t3.countLeafs() = " + t3.countLeafs());
        System.out.println("t4.countLeafs() = " + t4.countLeafs());
        System.out.println("t5.countLeafs() = " + t5.countLeafs());
        System.out.println("t6.countLeafs() = " + t6.countLeafs());
        System.out.println("t7.countLeafs() = " + t7.countLeafs());
    }
}
