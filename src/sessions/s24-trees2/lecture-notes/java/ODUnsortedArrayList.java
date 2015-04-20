import java.util.NoSuchElementException;

class ODUnsortedArrayList<K extends Comparable<K>, I>
    implements OrderedDictionary<K, I> {

    // most JVM don't allow Integer.MAX_VALUE arrays, but -2, -4 or -8
    // we use JVM_MAX_ARRAY_MARGIN just in case
    private static final int JVM_MAX_ARRAY_MARGIN = 10;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - JVM_MAX_ARRAY_MARGIN;
    private static final int MIN_CAPACITY = 10; // totally arbitrary value
    private static final int DEFAULT_CAPACITY = MIN_CAPACITY;

    private class Entry implements Comparable<Entry> {
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

    private Entry[] array;
    private int size;

    public ODUnsortedArrayList() {
        size = 0;
        // We whould like to initialize our array like this:
        //    array = new Entry<k, I>[DEFAULT_CAPACITY];
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

    public void insert(K key, I info) {
        if (size == array.length) {
            grow();
        }
        array[size++] = new Entry(key, info);
        return;
    }

    private int indexOf(K key) throws NoSuchElementException {
        for (int i = 0 ; i<size; i++) {
            if (array[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public I find(K key) throws NoSuchElementException {
        return array[indexOf(key)].info;
    }

    public I remove(K key) throws NoSuchElementException {
        int index = indexOf(key);
        I retval = (I) array[index].info;
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
        for (Entry entry : array) {
            if (entry == null) {
                break;
            }
            list.add(entry);
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
}
