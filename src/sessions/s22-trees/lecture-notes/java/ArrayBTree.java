import java.util.NoSuchElementException;

class ArrayBTree<E> {
    private E[] array;
    private static final int MIN_DEPTH = 1;
    private static final int MAX_DEPTH = 29;
    // MAX_DEPTH should be 30, because
    // java Integer.MAX_VALUE = (2^31) - 1
    // but we have to take into account the
    // JVM max array margin (usually only a few bytes).

    public ArrayBTree(int depth) {
        if (depth < MIN_DEPTH || depth > MAX_DEPTH ) {
            throw new IllegalArgumentException();
        }
        int capacity = (int) (Math.pow(2d, 1d + depth) - 1d);
        // workaround to create an array of a generic type
        @SuppressWarnings("unchecked")
        E[] workaround = (E[]) new Object[capacity];
        this.array = workaround;
    }

    public ArrayBTree(int depth, E root) {
        this(depth);
        setDatum(root(), root);
    }

    public boolean hasDatum(int i) {
        try {
            return array[i] != null;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean isValidIndex(int i) {
        return (i >= 0) && (i < array.length) ;
    }

    private void throwIfBadAccess(int i)
                        throws ArrayIndexOutOfBoundsException,
                               NoSuchElementException {
        if (! isValidIndex(i)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (! hasDatum(i)) {
            throw new NoSuchElementException();
        }
    }

    // returns the element stored at i
    public E getDatum(int i) throws ArrayIndexOutOfBoundsException,
                                    NoSuchElementException {
        throwIfBadAccess(i);
        return array[i];
    }

    // returns the index of the root element
    public int root() { return 0; }

    public boolean hasRoot() {
        try {
            getDatum(root());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // returns the index to the left of i
    public int left(int i) throws ArrayIndexOutOfBoundsException {
        if (! isValidIndex(i)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int result = (2*i) + 1;
        if (! isValidIndex(result)) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public boolean hasLeft(int i) {
        try {
            return hasDatum(left(i));
        } catch (Exception ex) {
            return false;
        }
    }

    // returns the index to the right of i
    public int right(int i) throws ArrayIndexOutOfBoundsException {
        int result = left(i) + 1;
        if (! isValidIndex(result)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return result;
    }

    public boolean hasRight(int i) {
        try {
            return hasDatum(right(i));
        } catch (Exception ex) {
            return false;
        }
    }

    // returns the index of the parent of i
    public int parent(int i) throws ArrayIndexOutOfBoundsException,
                                    IllegalArgumentException {
        if (! isValidIndex(i)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return (i-1) / 2;
    }

    public boolean hasParent(int i) {
        try {
            return hasDatum(parent(i));
        } catch (Exception ex) {
            return false;
        }
    }

    // sets the element stored at i
    // if i has a parent or if i is the root
    public void setDatum(int i, E datum) throws IllegalArgumentException,
                                                ArrayIndexOutOfBoundsException,
                                                IllegalStateException {
        if (datum == null) {
            throw new IllegalArgumentException();
        }
        if (hasParent(i) || i == root()) {
            array[i] = datum;
        } else {
            throw new IllegalStateException();
        }
    }

    // remove and returns the datum at i, clearing all its subtree
    public E extract(int i) throws ArrayIndexOutOfBoundsException,
                                   NoSuchElementException {
        E result = getDatum(i);
        array[i] = null;
        if (hasLeft(i)) {
            extract(left(i));
        }
        if (hasRight(i)) {
            extract(right(i));
        }
        return result;
    }

    public int size(int i) throws ArrayIndexOutOfBoundsException,
                                  NoSuchElementException {
        throwIfBadAccess(i);
        int leftSize = (hasLeft(i)) ? size(left(i)) : 0;
        int rightSize = (hasRight(i)) ? size(right(i)) : 0;
        return 1 + leftSize + rightSize;
    }

    public int size() throws ArrayIndexOutOfBoundsException,
                             NoSuchElementException {
        return size(root());
    }

    public int height(int i) throws ArrayIndexOutOfBoundsException,
                                    NoSuchElementException {
        throwIfBadAccess(i);
        int leftHeight = (hasLeft(i)) ? height(left(i)) : -1;
        int rightHeight = (hasRight(i)) ? height(right(i)) : -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int height() throws ArrayIndexOutOfBoundsException,
                               NoSuchElementException {
        return height(root());
    }

    // This method is slow, in array binary trees, there is a faster
    // way based in the index (see below).
    public int depthSlow(int i) throws ArrayIndexOutOfBoundsException,
                                       NoSuchElementException {
        throwIfBadAccess(i);
        if (! hasParent(i)) {
            return 0;
        } else {
            return 1 + depth(parent(i));
        }
    }

    // A quick implementation of the depth method using
    // the expresion depth = log_2(i+1)
    //
    // int logs are difficult in Java, here i am using
    // a clever trick using binary arithmetic.
    public int depth(int i) throws ArrayIndexOutOfBoundsException,
                                   NoSuchElementException {
        throwIfBadAccess(i);
        return 31 - Integer.numberOfLeadingZeros(i + 1);
    }

    public boolean isInternal(int i)
                        throws ArrayIndexOutOfBoundsException,
                               NoSuchElementException {
        throwIfBadAccess(i);
        return hasLeft(i) || hasRight(i);
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
        ArrayBTree<Character> tree = new ArrayBTree<Character>(4);
        Character[] data = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' };
        int a = tree.root();
        int b = tree.left(a);
        int c = tree.right(a);
        int d = tree.left(b);
        int e = tree.left(c);
        int f = tree.right(c);
        int g = tree.right(e);
        int h = tree.left(g);
        int i = tree.right(g);
        int[] indexes = { a, b, c, d, e, f, g, h, i };
        for (int ii=0; ii<data.length; ii++) {
            tree.setDatum(indexes[ii], data[ii]);
        }

        System.out.println("Tree size = " + tree.size());
        System.out.println("Tree height = " + tree.height());
        System.out.println("Node\tsize\theight\tdepth\tInternal/External");
        for (int ii=0; ii<indexes.length; ii++) {
            System.out.println("" + tree.getDatum(indexes[ii])
                    + "\t" + tree.size(indexes[ii])
                    + "\t" + tree.height(indexes[ii])
                    + "\t" + tree.depth(indexes[ii])
                    + "\t" + (tree.isInternal(indexes[ii]) ? "I" : "E"));
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
