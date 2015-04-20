import java.util.NoSuchElementException;

class ODUnsortedLinkedList<K extends Comparable<K>, I>
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

    public void insert(K key, I info) {
        first = new Node(key, info, first);
        size++;
        return;
    }

    public I find(K key) throws NoSuchElementException {
        Node current;
        for (current = first; current != null ; current = current.next) {
            if (current.key.compareTo(key) == 0) {
                return current.info;
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
        }
        throw new NoSuchElementException();
    }

    public void clear() {
        first = null;
        size = 0;
        return;
    }

    // To make testing simpler, this method should return the
    // entries growing in key order, but the purpose of the class
    // is to store the entries unsorted (for demostration purposes).
    //
    // This means returning the entries in key order is absurd for
    // for this class.
    //
    // Let us solve this quickly by inserting copies of the entries
    // in a Java List and the sort it. This is pretty advanced Java
    // magic for the average first year student, and completly out
    // of the scope of this course.
    public String toString() {
        java.util.List<Entry> list =
            new java.util.LinkedList<Entry>();
        for (Node current = first;
                current != null;
                current = current.next) {
            list.add(new Entry(current.key, current.info));
        }
        java.util.Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Entry entry : list) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + entry.key + "," + entry.info + ")");
        }
        return sb.toString();
    }

    // this class is needed for the above workaround to work.
    private class Entry
            implements Comparable<Entry> {
        K key;
        I info;

        Entry(K key, I info) {
            this.key = key;
            this.info = info;
        }

        public int compareTo(Entry entry) {
            return this.key.compareTo(entry.key);
        }
    }
}
