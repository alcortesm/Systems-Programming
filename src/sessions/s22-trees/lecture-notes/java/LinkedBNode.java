class LinkedBNode<E> {
    public E datum;
    public LinkedBNode<E> parent;
    public LinkedBNode<E> left;
    public LinkedBNode<E> right;

    public LinkedBNode(E datum, LinkedBNode<E> parent,
            LinkedBNode<E> left, LinkedBNode<E> right) {
        this.datum = datum;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public LinkedBNode<E> root() {
        if (parent == null) {
            return this;
        } else {
            return parent.root();
        }
    }

    public int depth() {
        return (parent != null) ? 1 + parent.depth() : 0;
    }

    public int size() {
        int leftSize = (left != null) ? left.size() : 0;
        int rightSize = (right != null) ? right.size() : 0;
        return 1 + leftSize + rightSize;
    }

    public int height() {
        int leftHeight = (left != null) ? left.height() : -1;
        int rightHeight = (right != null) ? right.height() : -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isInternal() {
        return (left != null || right != null);
    }

    public void printPreOrder() {
        System.out.println(datum);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.println(datum);
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(datum);
        if (right != null) {
            right.printInOrder();
        }
    }
}
