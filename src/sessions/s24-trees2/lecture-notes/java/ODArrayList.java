// Ordered Dictionary implementation using an array list.
//
// This implementation:
//
// - allows nulls in the values
//
// - does not allow duplicates (insertion of an entry with
//   an already existing key, will replace the old value with
//   the new one)

import java.util.NoSuchElementException;

class ODArrayList<K extends Comparable<K>, V>
    implements OrderedDictionary<K, V> {

    // most JVM don't allow Integer.MAX_VALUE arrays, but -2, -4 or -8
    // we use JVM_MAX_ARRAY_MARGIN just in case
    private static final int JVM_MAX_ARRAY_MARGIN = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - JVM_MAX_ARRAY_MARGIN;
    private static final int MIN_CAPACITY = 10; // totally arbitrary value
    private static final int DEFAULT_CAPACITY = MIN_CAPACITY;

    private class Entry implements Comparable<Entry> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Entry entry) {
            return this.key.compareTo(entry.key);
        }
    }

    private Entry[] array;
    private int size;

    public ODArrayList() {
        size = 0;
        // We whould like to initialize our array like this:
        //    array = new Entry<k, V>[DEFAULT_CAPACITY];
        // but Java does not allow creating "generic" arrays.
        // The following 4 lines is a workaround:
        @SuppressWarnings("unchecked")
        Entry[] workaround = (Entry[])
            java.lang.reflect.Array.newInstance(Entry.class, DEFAULT_CAPACITY);
        this.array = workaround;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // creates a new array with double the capacity of the old one
    // and copies the data from the old one to the new one
    private void grow() {
        int newLength;
        // check for int arithmetic overflow
        if ((array.length * 2 < array.length)
                || (array.length * 2 > MAX_CAPACITY)) {
            newLength = MAX_CAPACITY;
        } else {
            newLength = array.length * 2;
        }

        @SuppressWarnings("unchecked")
        Entry[] workaround = (Entry[])
            java.lang.reflect.Array.newInstance(Entry.class, newLength);
        // there are better ways to copy big arrays, but they are
        // not part of this course
        for (int i=0; i<array.length; i++) {
            workaround[i] = array[i];
        }
        this.array = workaround;
    }

    // creates a new array half the size of the old one
    // and copies all the elements of the old one into the new one.
    private void shrink() {
        int newLength;
        if (array.length / 2 < MIN_CAPACITY) {
            newLength = MIN_CAPACITY;
        } else {
            newLength = array.length / 2;
        }

        @SuppressWarnings("unchecked")
        Entry[] workaround = (Entry[])
            java.lang.reflect.Array.newInstance(Entry.class, newLength);
        // there are better ways to copy big arrays, but they are
        // not part of this course
        for (int i=0; i<size; i++) {
            workaround[i] = array[i];
        }
        this.array = workaround;
    }

    private int indexOf(K key) throws NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0 ; i<size; i++) {
            if (array[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public void insert(K key, V value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        try {
            array[indexOf(key)].value = value;
        } catch (NoSuchElementException ex) {
            if (size == array.length) {
                grow();
            }
            array[size++] = new Entry(key, value);
        }
        return;
    }

    public V find(K key) throws
        IllegalArgumentException, NoSuchElementException {
        return array[indexOf(key)].value;
    }

    public V remove(K key) throws
        IllegalArgumentException, NoSuchElementException {
        int index = indexOf(key);
        V retval = array[index].value;
        // shift elements to the left
        for (int j=index; j<(size-1); j++) {
            array[j] = array[j+1];
        }
        size--;
        array[size] = null; // helps the garbage collector a bit
        if ((array.length > MIN_CAPACITY)
                && (size <= (array.length / 4))) {
            shrink();
        }
        return retval;
    }

    public void clear() {
        @SuppressWarnings("unchecked")
        Entry[] workaround = (Entry[])
            java.lang.reflect.Array.newInstance(Entry.class, DEFAULT_CAPACITY);
        this.array = workaround;
        size = 0;
    }

    // this will not print the elements in key order, of course
    // that will be a lot of work for a collections that is not
    // storing the elements in order.
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i<size(); i++) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + array[i].key + "," + array[i].value + ")");
        }
        return sb.toString();
    }
}
