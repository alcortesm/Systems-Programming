class Tree1 {

    private class Node {
        int element;
        Tree1 left;
        Tree1 right;

        // according to the tree definition
        // nulls are not allowed as left and right
        Node(Tree1 left, int element, Tree1 right) {
            if (left == null || right == null) {
                throw new IllegalArgumentException();
            }
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private Node node;

    // empty btree
    public Tree1() {
        node = null;
    }

    // internal btree
    public Tree1(Tree1 left, int element, Tree1 right) {
        node = new Node(left, element, right);
    }

    // leaf
    public Tree1(int element) {
        this(new Tree1(), element, new Tree1());
    }

    public boolean isEmpty() {
        return node == null;
    }

    public String toStringInOrder() {
        if (isEmpty()) {
            return "";
        } else {
            return node.left.toStringInOrder() + " "
                + node.element + " "
                + node.right.toStringInOrder();
        }
    }

    public String toString() {
        return toStringInOrder();
    }

    public int countLeaves() {
        if (isEmpty()) {
            return 0;
        } else if (node.left.isEmpty() && node.right.isEmpty() ) {
            return 1;
        } else {
            return node.left.countLeaves() + node.right.countLeaves();
        }
    }

    public static void main(String args[]) {
        //          0
        //        /   \
        //       /     \
        //     1         2
        //    / \         \
        //   3   4         5
        //    \           /
        //     6         7
        Tree1 t6 = new Tree1(6);
        Tree1 t3 = new Tree1(new Tree1(), 3, t6);

        Tree1 t4 = new Tree1(4);
        Tree1 t1 = new Tree1(t3, 1, t4);

        Tree1 t7 = new Tree1(7);
        Tree1 t5 = new Tree1(t7, 5, new Tree1());
        Tree1 t2 = new Tree1(new Tree1(), 2, t5);

        Tree1 t0 = new Tree1(t1, 0, t2);

        System.out.println("t0.toStringInOrder() = " + t0);
        System.out.println("t1.toStringInOrder() = " + t1);
        System.out.println("t2.toStringInOrder() = " + t2);
        System.out.println("t3.toStringInOrder() = " + t3);
        System.out.println("t4.toStringInOrder() = " + t4);
        System.out.println("t5.toStringInOrder() = " + t5);
        System.out.println("t6.toStringInOrder() = " + t6);
        System.out.println("t7.toStringInOrder() = " + t7);

        System.out.println("t0.countLeaves() = " + t0.countLeaves());
        System.out.println("t1.countLeaves() = " + t1.countLeaves());
        System.out.println("t2.countLeaves() = " + t2.countLeaves());
        System.out.println("t3.countLeaves() = " + t3.countLeaves());
        System.out.println("t4.countLeaves() = " + t4.countLeaves());
        System.out.println("t5.countLeaves() = " + t5.countLeaves());
        System.out.println("t6.countLeaves() = " + t6.countLeaves());
        System.out.println("t7.countLeaves() = " + t7.countLeaves());
    }
}
