// Stack implementation using a linked list
//
// This particular implmentation has infinite capacity.

import java.util.EmptyStackException;

class LinkedStack<E> implements Stack<E> {

    private class Node<E> {
        private E datum;
        private Node<E> next;

        Node(E datum, Node<E> next) {
            setDatum(datum);
            setNext(next);
        }

        E getDatum() { return datum; }
        Node<E> getNext() { return next; }
        void setDatum(E datum) { this.datum = datum; }
        void setNext(Node<E> next) { this.next = next;}
    }

    private Node<E> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E e) {
        top = new Node<E>(e, top);
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E retval = top.getDatum();
        top = top.getNext();
        return retval;
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getDatum();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (Node<E> current = top;
                current != null;
                current = current.getNext()) {
            sb.insert(0, current.getDatum());
            if (current.getNext() != null) {
                sb.insert(0, ", ");
            } else {
                sb.append(" ");
            }
        }
        sb.insert(0, "Stack {");
        sb.append("(top)}");
        return sb.toString();
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
