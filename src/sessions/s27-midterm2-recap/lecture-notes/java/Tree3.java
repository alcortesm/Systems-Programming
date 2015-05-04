class Tree3<E> {

    private static class BaseNode {
        String toStringInOrder() {
            return "";
        }

        int countLeaves() {
            return 0;
        }
    }

    private class Node extends BaseNode {
        E element;
        BaseNode left;
        BaseNode right;

        // in this definition nodes can be null
        Node(BaseNode left, E element, BaseNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        String toStringInOrder() {
                return left.toStringInOrder() + " "
                    + element + " "
                    + right.toStringInOrder();
        }

        int countLeaves() {
            int count = left.countLeaves() + right.countLeaves();
            return (count==0) ? 1 : count;
        }
    }

    private BaseNode root;
    private static final BaseNode SENTINEL = new BaseNode();

    // empty btree
    public Tree3() {
        root = SENTINEL;
    }

    // internal btree
    //
    // merging trees like this will make them empty.
    public Tree3(Tree3<E> left, E element, Tree3<E> right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException();
        }
        root = new Node(left.root, element, right.root);
        left.makeEmpty();
        right.makeEmpty();
    }

    // leaf
    public Tree3(E element) {
        root = new Node(SENTINEL, element, SENTINEL);
    }

    public boolean isEmpty() {
        return root == SENTINEL;
    }

    public void makeEmpty() {
        root = SENTINEL;
    }

    public String toString() {
        return root.toStringInOrder();
    }

    public int countLeaves() {
        return root.countLeaves();
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
        //
        Tree3<Integer> t6 = new Tree3<Integer>(6);
        Tree3<Integer> t3 = new Tree3<Integer>(new Tree3<Integer>(), 3, t6);
        Tree3<Integer> t4 = new Tree3<Integer>(4);
        Tree3<Integer> t1 = new Tree3<Integer>(t3, 1, t4);

        Tree3<Integer> t7 = new Tree3<Integer>(7);
        Tree3<Integer> t5 = new Tree3<Integer>(t7, 5, new Tree3<Integer>());
        Tree3<Integer> t2 = new Tree3<Integer>(new Tree3<Integer>(), 2, t5);

        Tree3<Integer> t0 = new Tree3<Integer>(t1, 0, t2);

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
