import java.util.NoSuchElementException;

class ODUnsortedLinkedList<K extends Comparable<K>, V>
    implements OrderedDictionary<K, V> {

    private Node first;
    private int size;

    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public ODUnsortedLinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node findNode(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (Node current = first; current != null ; current = current.next) {
            if (current.key.compareTo(key) == 0) {
                return current;
            }
        }
        throw new NoSuchElementException();
    }

    public void insert(K key, V value) throws IllegalArgumentException {
        try {
            findNode(key).value = value;
        } catch (NoSuchElementException ex) {
            first = new Node(key, value, first);
            size++;
        }
    }

    public V find(K key) throws
        IllegalArgumentException, NoSuchElementException {
        return findNode(key).value;
    }

    public V remove(K key) throws
        IllegalArgumentException, NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first.key.compareTo(key) == 0) {
            V retval = first.value;
            first = first.next;
            size--;
            return retval;
        }

        for (Node prev = first; prev.next != null; prev = prev.next) {
            if (prev.next.key.compareTo(key) == 0) {
                V retval = prev.next.value;
                prev.next = prev.next.next;
                size--;
                return retval;
            }
        }

        throw new NoSuchElementException();
    }

    public void clear() {
        first = null;
        size = 0;
        return;
    }

    // this will not print the elements in key order, of course
    // that will be a lot of work for a collections that is not
    // storing the elements in order.
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Node current = first;
                current != null;
                current = current.next) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + current.key + ", " + current.value + ")");
        }
        return sb.toString();
    }
}
