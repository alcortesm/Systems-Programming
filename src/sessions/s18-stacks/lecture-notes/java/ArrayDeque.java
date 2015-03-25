// Deque implemented using an array.
//
// This implementation has bounded capacity.
//
// - the constructor receives the max capacity.
//
// - add methods throw IllegalStatusException.

import java.util.NoSuchElementException;

class ArrayDeque<E> implements Deque<E> {

    private E[] array;
    private int head; // -1 when empty
    private int tail; // -1 when empty

    public ArrayDeque(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        head = -1;
        tail = -1;
        @SuppressWarnings("unchecked")
        E[] workaround = (E[]) new Object[capacity];
        array = workaround;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    private int next(int i) { return (++i % array.length); }

    private int prev(int i) { return i==0 ? array.length-1 : --i; }

    private boolean isFull() {
        return next(tail) == head;
    }

    public void addTail(E e)
        throws NullPointerException, IllegalStateException {
        if (e == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = next(tail);
        array[tail] = e;
    }

    public void addHead(E e)
        throws NullPointerException, IllegalStateException {
        if (e == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (isEmpty()) {
            addTail(e);
            return;
        }
        head = prev(head);
        array[head] = e;
    }

    public E removeHead() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E retval = array[head];
        array[head] = null; // to help the garbage collector
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = next(head);
        }
        return retval;
    }

    public E removeTail() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E retval = array[tail];
        array[tail] = null; // to help the garbage collector
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            tail = prev(tail);
        }
        return retval;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        if (! isEmpty()) {
            for (int i=head; i!=tail; i=next(i)) {
                sb.append(array[i]);
                sb.append(", ");
            }
            sb.append(array[tail]);
            sb.append(" ");
        }
        sb.insert(0, "Deque {(head) ");
        sb.append("(tail)}");
        return sb.toString();
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
