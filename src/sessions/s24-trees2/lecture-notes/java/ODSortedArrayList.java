import java.util.NoSuchElementException;

class ODSortedArrayList<K extends Comparable<K>, V>
    implements OrderedDictionary<K, V> {

    // most JVM don't allow Vnteger.MAX_VALUE arrays, but -2, -4 or -8
    // we use JVM_MAX_ARRAY_MARGVN just in case
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

    public ODSortedArrayList() {
        size = 0;
        // We whould like to initialize our array like this:
        //    array = new Entry<k, V>[DEFAULT_CAPACVTY];
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

    // invariants:
    //
    // - the key at start is <= than the one we want to insert
    //
    // - the key at stop is >= than the one we want to insert
    private int indexOfOrFirstGreaterThan(K key, int start, int stop) {
        if (stop - start <= 1) {
            if (array[start].key.compareTo(key) == 0) {
                return start;
            } else {
                return stop;
            }
        } else {
            int middle = start + ((stop - start) / 2);
            if (array[middle].key.compareTo(key) == 0) {
                return middle;
            } else if (array[middle].key.compareTo(key) > 0) {
                return indexOfOrFirstGreaterThan(key, start, middle);
            } else {
                return indexOfOrFirstGreaterThan(key, middle, stop);
            }
        }
    }

    private int whereToInsert(K key) {
        if (isEmpty()) {
            return 0;
        } else if (array[0].key.compareTo(key) > 0) {
            // if all keys in the array are bigger then insert at the
            // beginning
            return 0;
        } else if (array[size-1].key.compareTo(key) < 0) {
            // if all keys in the array are smaller or equal then insert at the
            // end
            return size;
        } else {
            // if there are smaller and bigger keys, then look for the
            // first key that is bigger than the one we want to insert
            return indexOfOrFirstGreaterThan(key, 0, size-1);
        }
    }

    public void insert(K key, V value) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int insertionPoint = whereToInsert(key);
        if (size > insertionPoint &&
                array[insertionPoint].key.compareTo(key) == 0) {
            array[insertionPoint].value = value;
            return;
        }
        if (size == array.length) {
            grow();
        }
        // make room shifting elements to the right
        for (int i=size-1; i>=insertionPoint; i--) {
            array[i+1] = array[i];
        }
        array[insertionPoint] = new Entry(key, value);
        size++;
    }

    private int indexOfRecursive(K key, int start, int stop)
        throws NoSuchElementException {
        if (stop - start <= 1) {
            if (array[start].key.compareTo(key) == 0) {
                return start;
            } else if (array[stop].key.compareTo(key) == 0) {
                return stop;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            int middle = start + ((stop - start) / 2);
            if (array[middle].key.compareTo(key) == 0) {
                return middle;
            } else if (array[middle].key.compareTo(key) > 0) {
                return indexOfRecursive(key, start, middle);
            } else {
                return indexOfRecursive(key, middle, stop);
            }
        }
    }

    private int indexOf(K key) throws NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() ||
                array[0].key.compareTo(key) > 0 ||
                array[size-1].key.compareTo(key) < 0) {
            throw new NoSuchElementException();
        } else {
            return indexOfRecursive(key, 0, size-1);
        }
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<size; i++) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + array[i].key + "," + array[i].value + ")");
        }
        return sb.toString();
    }

    private void testWhere(K key, int expected) {
        int where = whereToInsert(key);
        if (where != expected) {
            throw new TestException("where is " + where + ", but should be " + expected);
        }
    }


    private static void testWhereToInsert() {
        ODSortedArrayList<Integer, Integer> od = new ODSortedArrayList<Integer, Integer>();
        od.testWhere(-10, 0);
        od.testWhere(-2, 0);
        od.testWhere(-1, 0);
        od.testWhere(0, 0);
        od.testWhere(1, 0);
        od.testWhere(2, 0);
        od.testWhere(10, 0);

        od.insert(10, 10);
        // (10,10)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(20, 1);

        od.insert(12, 12);
        // (10,10), (12,12)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(12, 1);
        od.testWhere(13, 2);
        od.testWhere(20, 2);

        od.insert(14, 14);
        // (10,10), (12,12), (14,14)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(12, 1);
        od.testWhere(13, 2);
        od.testWhere(14, 2);
        od.testWhere(15, 3);
        od.testWhere(20, 3);

        od.insert(16, 16);
        // (10,10), (12,12), (14,14), (16,16)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(12, 1);
        od.testWhere(13, 2);
        od.testWhere(14, 2);
        od.testWhere(15, 3);
        od.testWhere(16, 3);
        od.testWhere(17, 4);
        od.testWhere(20, 4);

        od.insert(18, 18);
        // (10,10), (12,12), (14,14), (16,16), (18,18)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(12, 1);
        od.testWhere(13, 2);
        od.testWhere(14, 2);
        od.testWhere(15, 3);
        od.testWhere(16, 3);
        od.testWhere(17, 4);
        od.testWhere(18, 4);
        od.testWhere(19, 5);
        od.testWhere(20, 5);

        od.insert(20, 20);
        // (10,10), (12,12), (14,14), (16,16), (18,18), (20,20)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(12, 1);
        od.testWhere(13, 2);
        od.testWhere(14, 2);
        od.testWhere(15, 3);
        od.testWhere(16, 3);
        od.testWhere(17, 4);
        od.testWhere(18, 4);
        od.testWhere(19, 5);
        od.testWhere(20, 5);
        od.testWhere(21, 6);
        od.testWhere(30, 6);

        od.insert(22, 22);
        // (10,10), (12,12), (14,14), (16,16), (18,18), (20,20), (22,22)
        od.testWhere(0, 0);
        od.testWhere(9, 0);
        od.testWhere(10, 0);
        od.testWhere(11, 1);
        od.testWhere(12, 1);
        od.testWhere(13, 2);
        od.testWhere(14, 2);
        od.testWhere(15, 3);
        od.testWhere(16, 3);
        od.testWhere(17, 4);
        od.testWhere(18, 4);
        od.testWhere(19, 5);
        od.testWhere(20, 5);
        od.testWhere(21, 6);
        od.testWhere(22, 6);
        od.testWhere(23, 7);
        od.testWhere(30, 7);

        od.clear();
        od.insert(1, 1);
        od.insert(1, 1);
        // (1,1)
        od.testWhere(0, 0);
        od.testWhere(1, 0);
        od.testWhere(2, 1);
        od.insert(1, 1);
        // (1,1)
        od.testWhere(0, 0);
        od.testWhere(1, 0);
        od.testWhere(2, 1);
        od.insert(3, 3);
        od.insert(3, 3);
        od.insert(3, 3);
        od.insert(5, 5);
        // (1,1), (3,3), (5,5)
        od.testWhere(0, 0);
        od.testWhere(1, 0);
        od.testWhere(2, 1);
        od.testWhere(3, 1);
        od.testWhere(4, 2);
        od.testWhere(5, 2);
        od.testWhere(6, 3);
    }

    public static void main(String args[]) {
        System.out.print("Testing whereToInsert...");
        try {
            testWhereToInsert();
            System.out.println(" OK");
        } catch (TestException ex) {
            System.out.println(" ERROR");
            ex.printStackTrace();
        }
    }
}
