// Stack:
//
// - ordered collection
// - normally capacity is bounded
// - normally nulls are allowed
// - normally duplicated are allowed

import java.util.EmptyStackException;

interface Stack<E> {
    boolean isEmpty();
    void    push(E e);
    E       pop() throws EmptyStackException;
    E       peek() throws EmptyStackException;
}
