class Node<E> {

    private E       info;
    private Node<E> next;

    Node(E info, Node<E> next) {
        setInfo(info);
        setNext(next);
    }

    void setInfo(E info) {
        if (info == null) {
            throw new IllegalArgumentException();
        }
        this.info = info;
    }

    void setNext(Node<E> next) {
        this.next = next;
    }

    E getInfo() {
        return info;
    }

    Node<E> getNext() {
        return next;
    }
}
