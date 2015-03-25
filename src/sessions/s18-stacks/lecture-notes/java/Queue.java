// Queue (also called a FIFO):
//
// - ordered collection
// - normally capacity is bounded (no infinite)
// - normally nulls are not allowed
// - normally duplicated elements are allowed

import java.util.NoSuchElementException;

interface Queue<E> {
    boolean isEmpty();
    void    enqueue(E e);
    E       dequeue() throws NoSuchElementException;
    E       front() throws NoSuchElementException;
}
