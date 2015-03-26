// Stack implementation using a linked list
//
// This implmentation has infinite capacity.

import java.util.EmptyStackException;

class LinkedStack<E> implements Stack<E> {

    private class Node<E> {
        E datum;
        Node<E> next;

        Node(E datum, Node<E> next) {
            this.datum = datum;
            this.next = next;
        }
    }

    private Node<E> top; // null means empty list

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E e) throws NullPointerException {
        if (e == null) {
            throw new NullPointerException();
        }
        top = new Node<E>(e, top);
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E retval = top.datum;
        top = top.next;
        return retval;
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.datum;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (Node<E> current = top;
                current != null;
                current = current.next) {
            sb.insert(0, current.datum);
            if (current.next != null) {
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
