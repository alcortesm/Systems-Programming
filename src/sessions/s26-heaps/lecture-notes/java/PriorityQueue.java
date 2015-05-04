import java.util.NoSuchElementException;

interface PriorityQueue<P extends Comparable<P>, V> {
    boolean isEmpty();
    int     size();
    void    insert(P prio, V value) throws IllegalArgumentException;
    V       getMax() throws NoSuchElementException;
    V       removeMax() throws NoSuchElementException;
}
