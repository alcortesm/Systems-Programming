// Deque (double queue)
//
// Like a queue, but you can add and remove from both ends.

import java.util.NoSuchElementException;

interface Deque<E> {
    boolean isEmpty();
    void    addHead(E e) throws NullPointerException;
    void    addTail(E e) throws NullPointerException;
    E       removeHead() throws NoSuchElementException;
    E       removeTail() throws NoSuchElementException;
}
