import java.util.NoSuchElementException;

class LinkedBTree<E> {
    private LinkedBNode<E> root;

    public LinkedBTree() {
        root = null;
    }

    public LinkedBTree(E root) {
        this.root = new LinkedBNode<E>(root, null, null, null);
    }

    public void setRoot(LinkedBNode<E> root) {
        this.root = root;
    }

    public LinkedBNode<E> getRoot() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        setRoot(null);
    }

    // To make this method fast, we are reusing
    // the nodes from the tree to be inserted
    // instead of reusing them.
    //
    // Therefore, we must destroy the inserted
    // tree after the insertion, to avoid having
    // two trees using the same nodes.
    public void insertLeft(LinkedBTree<E> tree) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }
        // if inserting an empty tree just remove
        // whatever was on the left
        if (tree.isEmpty()) {
            if (root.left != null) {
                root.left.parent = null;
                root.left = null;
            }
        } else {
            // if tree is not empty, substitute old
            // nodes with the ones of the new tree

            // if there was something on the left,
            // remove its parent link.
            if (root.left != null) {
                root.left.parent = null;
            }
            // substitute old nodes with new ones
            root.left = tree.root;
            root.left.parent = root;
            // and destroy the old tree
            tree.makeEmpty();
        }
    }

    // This method is the same as insertLeft, but
    // changing left for right. It is a pity that
    // there is no way in Java to avoid all this
    // code redundancy.
    public void insertRight(LinkedBTree<E> tree) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }
        // if inserting an empty tree just remove
        // whatever was on the right
        if (tree.isEmpty()) {
            if (root.right != null) {
                root.right.parent = null;
                root.right = null;
            }
        } else {
            // if tree is not empty, substitute old
            // nodes with the ones of the new tree

            // if there was something on the right,
            // remove its parent link.
            if (root.right != null) {
                root.right.parent = null;
            }
            // substitute old nodes with new ones
            root.right = tree.root;
            root.right.parent = root;
            // and destroy the old tree
            tree.makeEmpty();
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.size();
        }
    }

    public int height() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else {
            return root.height();
        }
    }

    public String toString() {
        return toStringPreOrder();
    }

    public String toStringPreOrder() {
        String result = "Tree (pre) = ";
        if (isEmpty()) {
            result += "[empty]";
        } else {
            result += root.toStringPreOrder();
        }
        return result;
    }

    public String toStringPostOrder() {
        String result = "Tree (post) = ";
        if (isEmpty()) {
            result += "[empty]";
        } else {
            result += root.toStringPostOrder();
        }
        return result;
    }

    public String toStringInOrder() {
        String result = "Tree (in) = ";
        if (isEmpty()) {
            result += "[empty]";
        } else {
            result += root.toStringInOrder();
        }
        return result;
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

        g.insertLeft(h);
        g.insertRight(i);
        e.insertRight(g);
        c.insertLeft(e);
        c.insertRight(f);
        b.insertLeft(d);
        a.insertLeft(b);
        a.insertRight(c);

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
        System.out.println(a.toStringPreOrder());
        System.out.println(a.toStringPostOrder());
        System.out.println(a.toStringInOrder());
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
        // Tree (pre) = a, b, d, c, e, g, h, i, f
        // Tree (post) = d, b, h, i, g, e, f, c, a
        // Tree (in) = d, b, a, e, h, g, i, c, f
    }
}
