import java.util.NoSuchElementException;

class ODSortedLinkedList<K extends Comparable<K>, V>
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

    public ODSortedLinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty() || first.key.compareTo(key) > 0) {
            first = new Node(key, value, first);
        } else if (first.key.compareTo(key) == 0) {
            first.value = value;
            return;
        } else {
            Node prev;
            // move prev to the node before the first bigger key
            // or the end if no bigger key is found
            for (prev = first; prev.next != null; prev = prev.next) {
                if (prev.next.key.compareTo(key) == 0) {
                    prev.next.value = value;
                    return;
                } else if (prev.next.key.compareTo(key) > 0) {
                    break;
                }
            }
            prev.next = new Node(key, value, prev.next);
        }
        size++;
    }

    public V find(K key)
        throws IllegalArgumentException, NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (Node current = first; current != null ; current = current.next) {
            if (current.key.compareTo(key) == 0) {
                return current.value;
            }
            if (current.key.compareTo(key) > 0) {
                break;
            }
        }
        throw new NoSuchElementException();
    }

    public V remove(K key)
        throws IllegalArgumentException, NoSuchElementException {
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
            if (prev.next.key.compareTo(key) > 0) {
                break;
            }
        }
        throw new NoSuchElementException();
    }

    public void clear() {
        first = null;
        size = 0;
        return;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node current = first; current != null;
                current = current.next) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + current.key + "," + current.value + ")");
        }
        return sb.toString();
    }
}
