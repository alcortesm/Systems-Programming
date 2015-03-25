// Queue implemented as a linked list.
//
// This aprticular implementation:
// - is infinite
// - do not allow nulls (enqueue throws NullPointerException)

import java.util.NoSuchElementException;

class LinkedQueue<E> implements Queue<E> {

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
        void setNext(Node<E> next) { this.next = next; }
    }

    private Node<E> first; // if empty, first is null.
    private Node<E> last;  // if empty, last is null.

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(E e)
        throws NullPointerException {
        if (e == null) {
            throw new NullPointerException();
        }
        Node<E> newLast = new Node<E>(e, null);
        if (isEmpty()) {
            first = newLast;
        } else {
            last.setNext(newLast);
        }
        last = newLast;
    }

    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E retval = first.getDatum();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        }
        return retval;
    }

    public E front() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.getDatum();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (! isEmpty()) {
            for (Node<E> current=first;
                   current!=last;
                   current=current.getNext()) {
                sb.insert(0, current.getDatum());
                sb.insert(0, ", ");
            }
            sb.insert(0, last.getDatum());
            sb.append(" ");
        }
        sb.insert(0, "Queue {");
        sb.append("(front)}");
        return sb.toString();
    }
}
