// Deque implemented using a double-linked list.
//
// This implementation has infinite capacity.

import java.util.NoSuchElementException;

class LinkedDeque<E> implements Deque<E> {

    private class Node<E> {
        E datum;
        Node<E> prev;
        Node<E> next;
        Node(E datum, Node<E> prev, Node<E> next) {
            this.datum = datum;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public LinkedDeque() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.next = tail;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public void addHead(E e) throws NullPointerException {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> newNode = new Node<E>(e, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
    }

    public void addTail(E e) throws NullPointerException {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> newNode = new Node<E>(e, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E retval = head.next.datum;
        head.next.next.prev = head;
        head.next = head.next.next;
        return retval;
    }

    public E removeTail() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E retval = tail.prev.datum;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return retval;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (! isEmpty()) {
            for (Node<E> current=head.next;
                   current!=tail;
                   current=current.next) {
                sb.append(current.datum);
                if (current.next != tail) {
                    sb.append(", ");
                } else {
                    sb.append(" ");
                }
            }
        }
        sb.insert(0, "Deque {(head) ");
        sb.append("(tail)}");
        return sb.toString();
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
