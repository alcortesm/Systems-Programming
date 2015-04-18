import java.util.NoSuchElementException;

class ODSortedList<K extends Comparable, I>
    implements OrderedDictionary<K, I> {

    public ODSortedList() {
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public void insert(K key, I info) {
        return;
    }

    public I find(K key) throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    public I remove(K key) throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    public void clear() {
        return;
    }

    public String toString() {
        return "ODSortedList = ";
    }
}
