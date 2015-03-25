// Stack (also called a LIFO):
//
// - ordered collection
// - normally capacity is bounded (no infinite)
// - normally nulls are not allowed
// - normally duplicated elements are allowed

import java.util.EmptyStackException;

interface Stack<E> {
    boolean isEmpty();
    void    push(E e);
    E       pop() throws EmptyStackException;
    E       peek() throws EmptyStackException;
}
