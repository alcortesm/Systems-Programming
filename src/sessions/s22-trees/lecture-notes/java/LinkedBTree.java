class LinkedBTree<E> {
    private LinkedBNode<E> root;
    public static final boolean LEFT = true;
    public static final boolean RIGHT = false;

    public LinkedBTree() {
        root = null;
    }

    public LinkedBTree(E root) {
        this.root = new LinkedBNode<E>(root, null, null, null);
    }

    public LinkedBNode<E> getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return root.size();
    }

    public int height() {
        return root.height();
    }

    public void printPreOrder() {
        if (! isEmpty()) {
            root.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (! isEmpty()) {
            root.printPostOrder();
        }
    }

    public void printInOrder() {
        if (! isEmpty()) {
            root.printInOrder();
        }
    }

    public void makeEmpty() {
        root = null;
    }

    // Insert a tree on the left or on the right of this one.
    //
    // To make this method fast, we are reusing the nodes from the original
    // tree, and therefore we must destroy the oringal tree to avoid
    // having several trees using the same nodes.
    public void insert(LinkedBTree<E> tree, boolean onTheLeft) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }
        if (onTheLeft) {
            if (tree.isEmpty()) {
                root.left = null;
            } else {
                root.left = tree.root;
                root.left.parent = root;
                tree.makeEmpty(); // destroy original
            }
        } else { // the same but on the right
            if (tree.isEmpty()) {
                root.right = null;
            } else {
                root.right = tree.root;
                root.right.parent = root;
                tree.makeEmpty(); // destroy original
            }
        }
    }

    public static void main(String args[]) {
        //             a
        //            / \
        //           /   \
        //          /     \
        //         b       c          size = 9
        //        /       / \
        //       /       /   \        height = 4
        //      d       e     f
        //               \
        //                \
        //                 g
        //                / \
        //               /   \
        //              h     i
        //
        LinkedBTree<Character> a = new LinkedBTree<Character>('a');
        LinkedBTree<Character> b = new LinkedBTree<Character>('b');
        LinkedBTree<Character> c = new LinkedBTree<Character>('c');
        LinkedBTree<Character> d = new LinkedBTree<Character>('d');
        LinkedBTree<Character> e = new LinkedBTree<Character>('e');
        LinkedBTree<Character> f = new LinkedBTree<Character>('f');
        LinkedBTree<Character> g = new LinkedBTree<Character>('g');
        LinkedBTree<Character> h = new LinkedBTree<Character>('h');
        LinkedBTree<Character> i = new LinkedBTree<Character>('i');

        @SuppressWarnings("unchecked")
        LinkedBNode<Character>[] nodes =
            (LinkedBNode<Character>[]) new LinkedBNode[9];
        nodes[0] = a.getRoot();
        nodes[1] = b.getRoot();
        nodes[2] = c.getRoot();
        nodes[3] = d.getRoot();
        nodes[4] = e.getRoot();
        nodes[5] = f.getRoot();
        nodes[6] = g.getRoot();
        nodes[7] = h.getRoot();
        nodes[8] = i.getRoot();

        g.insert(h, LinkedBTree.LEFT);
        g.insert(i, LinkedBTree.RIGHT);
        e.insert(g, LinkedBTree.RIGHT);
        c.insert(e, LinkedBTree.RIGHT);
        c.insert(f, LinkedBTree.LEFT);
        b.insert(d, LinkedBTree.LEFT);
        a.insert(b, LinkedBTree.LEFT);
        a.insert(c, LinkedBTree.RIGHT);

        System.out.println("Tree size = " + a.size());
        System.out.println("Tree height = " + a.height());
        System.out.println("Node\tsize\theight\tdepth\tInternal/External");
        for (int ii=0; ii<nodes.length; ii++) {
            System.out.println("" + nodes[ii].datum
                    + "\t" + nodes[ii].size()
                    + "\t" + nodes[ii].height()
                    + "\t" + nodes[ii].depth()
                    + "\t" + (nodes[ii].isInternal() ? "I" : "E"));
        }
        // The output should be:
        //
        // Tree size = 9
        // Tree height = 4
        // Node    size    height  depth   Internal/External
        // a       9       4       0       I
        // b       2       1       1       I
        // c       6       3       1       I
        // d       1       0       2       E
        // e       4       2       2       I
        // f       1       0       2       E
        // g       3       1       3       I
        // h       1       0       4       E
        // i       1       0       4       E
    }
}
