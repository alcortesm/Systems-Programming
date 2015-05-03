interface PriorityQueue<P extends Comparable<P>, V> {
    boolean isEmpty();
    int     size();
    void    insert(P prio, V value);
    V       getMax();
    V       removeMax();
}
