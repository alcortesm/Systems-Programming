import java.util.NoSuchElementException;

interface OrderedDictionary<K extends Comparable, I> {
    int size();
    boolean isEmpty();

    void insert(K key, I info);
    I find(K key) throws NoSuchElementException;
    I remove(K key) throws NoSuchElementException;
    void clear();
}
