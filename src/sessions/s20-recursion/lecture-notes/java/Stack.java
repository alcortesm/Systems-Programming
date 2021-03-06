// Stack (also called a LIFO):
//
// - ordered collection
// - normally capacity is bounded (not infinite)
// - normally nulls are not allowed
// - normally duplicated elements are allowed

import java.util.EmptyStackException;

interface Stack<E> {
    boolean isEmpty();
    void    push(E e) throws NullPointerException;
    E       pop() throws EmptyStackException;
    E       peek() throws EmptyStackException;
    boolean contains(E e) throws NullPointerException;
}
