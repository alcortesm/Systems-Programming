// Lists implementation using a LinkedList.
//
// Duplicated elements are allowed.

import java.util.NoSuchElementException;

class LinkedList<E> implements List<E> {

    private class Node<E> {
        private E datum;
        private Node<E> next;

        Node(E datum, Node<E> next) {
            setDatum(datum);
            setNext(next);
        }

        E getDatum() { return datum; }
        void setDatum(E datum) { this.datum = datum; }
        // no null protection is needed for setDatum if the outter class is
        // already doing it

        Node<E> getNext() { return next; }
        void setNext(Node<E> next) { this.next = next; }
    }

    private Node<E> first;
    private int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // returns the ith node
    private Node<E> goTo(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node<E> current = first;
        while (currentIndex != i) {
            current = current.getNext();
            currentIndex++;
        }
        return current;
    }

    public void add(int i, E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        // if insert at the beginning
        if (i == 0) {
            first = new Node<E>(e, first);
        } else {
            // look for the previous
            Node<E> prev = goTo(i-1);
            // point prev to new node
            prev.setNext(new Node<E>(e, prev.getNext()));
        }
        size++;
    }

    public E get(int i) {
        return goTo(i).getDatum();
    }

    public void set(int i, E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        goTo(i).setDatum(e);
    }

    public E remove(int i) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        E datum;
        if (i == 0) { // if we want to remove the first one
            datum = first.getDatum();
            first = first.getNext();
        } else {
            Node<E> prev = goTo(i-1);
            datum = prev.getNext().getDatum();
            prev.setNext(prev.getNext().getNext());
        }
        size--;
        return datum;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public int indexOf(E e) {
        // check for performnce gain
        if (e == null) {
            throw new NoSuchElementException();
        }

        int index;
        Node<E> current;
        for (current = first, index = 0;
                current != null;
                current = current.getNext(), index++) {
           if (current.getDatum().equals(e)) {
               return index;
           }
        }
        throw new NoSuchElementException();
    }

    public boolean contains(E e) {
        try {
            indexOf(e);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{}");
        for (Node<E> c = first; c != null; c = c.getNext()) {
            if (c != first) {
                sb.insert(sb.length()-1, ", ");
            }
            sb.insert(sb.length()-1, c.getDatum());
        }
        return sb.toString();
    }
}

// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
