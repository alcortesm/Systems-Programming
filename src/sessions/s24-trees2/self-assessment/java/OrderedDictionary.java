import java.util.NoSuchElementException;

interface OrderedDictionary<K extends Comparable<K>, V> {
    int size();
    boolean isEmpty();

    void insert(K key, V value) throws IllegalArgumentException;
    V find(K key) throws IllegalArgumentException, NoSuchElementException;
    V remove(K key) throws IllegalArgumentException, NoSuchElementException;

    void clear();
}
