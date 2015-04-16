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

    public boolean isInternal() {
        return (left != null || right != null);
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

    public String toString() {
        return toStringPreOrder();
    }

    // add a coma if necessary when concatenating strings
    private String concat(String prefix, String suffix) {
        if (prefix.length() == 0) {
            return suffix;
        } else {
            return prefix + ", " + suffix;
        }
    }


    // Concatenating strings in java is not very efficient.
    //
    // It would be better to pass around
    // a StringBuilder object in the recursive calls.
    //
    // But that would make this example code more difficult
    // to understand so we prefer to use the inefficient version.
    public String toStringPreOrder() {
        String result = "";
        result += datum.toString();
        if (left != null) {
            result = concat(result, left.toStringPreOrder());
        }
        if (right != null) {
            result = concat(result, right.toStringPreOrder());
        }
        return result;
    }

    public String toStringPostOrder() {
        String result = "";
        if (left != null) {
            result += left.toStringPostOrder();
        }
        if (right != null) {
            result = concat(result, right.toStringPostOrder());
        }
        result = concat(result, datum.toString());
        return result;
    }

    public String toStringInOrder() {
        String result = "";
        if (left != null) {
            result += left.toStringInOrder();
        }
        result = concat(result, datum.toString());
        if (right != null) {
            result = concat(result, right.toStringInOrder());
        }
        return result;
    }
}
