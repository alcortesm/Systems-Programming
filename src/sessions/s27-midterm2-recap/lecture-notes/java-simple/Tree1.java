class Tree1 {

    private class Node {
        int element;
        Tree1 left;
        Tree1 right;

        // according to the tree definition
        // nulls are not allowed as left or right
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

    // empty tree
    public Tree1() {
        node = null;
    }

    // internal tree
    public Tree1(Tree1 left, int element, Tree1 right) {
        // ...
    }

    // leaf
    public Tree1(int element) {
        // ...
    }

    public boolean isEmpty() {
        // ...
    }

    public String toStringInOrder() {
        // ...
    }

    public String toString() {
        return toStringInOrder();
    }

    public int countLeafs() {
        //
        // YOU MUST WRITE THIS METHOD RECURSIVELY
        //
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
