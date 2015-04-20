import java.util.NoSuchElementException;

class ODSortedLinkedList<K extends Comparable<K>, I>
    implements OrderedDictionary<K, I> {

    private Node first;
    private int size;

    private class Node {
        K key;
        I info;
        Node next;

        Node(K key, I info, Node next) {
            this.key = key;
            this.info = info;
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

    public void insert(K key, I info) {
        if (isEmpty() || first.key.compareTo(key) > 0) {
            first = new Node(key, info, first);
        } else {
            Node prev;
            // move prev to the node before the first bigger key
            // or the end if no bigger key is found
            for (prev = first; prev.next != null; prev = prev.next) {
                if (prev.next.key.compareTo(key) > 0) {
                    break;
                }
            }
            prev.next = new Node(key, info, prev.next);
        }
        size++;
    }

    public I find(K key) throws NoSuchElementException {
        Node current;
        for (current = first; current != null ; current = current.next) {
            if (current.key.compareTo(key) == 0) {
                return current.info;
            }
            if (current.key.compareTo(key) > 0) {
                break;
            }
        }
        throw new NoSuchElementException();
    }

    public I remove(K key) throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first.key.compareTo(key) == 0) {
            I retval = first.info;
            first = first.next;
            size--;
            return retval;
        }

        for (Node prev = first; prev.next != null; prev = prev.next) {
            if (prev.next.key.compareTo(key) == 0) {
                I retval = prev.next.info;
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
            sb.append("(" + current.key + "," + current.info + ")");
        }
        return sb.toString();
    }
}
