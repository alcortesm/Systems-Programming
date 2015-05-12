import java.util.NoSuchElementException;

interface Queue<E> {
    boolean isEmpty();
    int     size();
    void    enqueue(E info) throws IllegalArgumentException;
    E       dequeue() throws NoSuchElementException;
}
