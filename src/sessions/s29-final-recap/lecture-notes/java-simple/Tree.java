class Tree {

    private String name;
    private Forest children;

    Tree(String name, Forest children) {
        setName(name);
        setChilds(children);
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private void setChilds(Forest children) {
        if (children == null) {
            throw new IllegalArgumentException();
        }
        this.children = children;
    }

    boolean isLeaf() {
        // to do in section 2
        return false;
    }

    public String toString() {
        // to do in section 4
    }
}
