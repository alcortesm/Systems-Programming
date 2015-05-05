import java.util.NoSuchElementException;

class Heap<P extends Comparable<P>, V> implements PriorityQueue<P, V> {

    private class Pair implements Comparable<Pair> {

        P prio;
        V value;

        Pair(P prio, V value) {
            if (prio == null) {
                throw new IllegalArgumentException();
            }
            this.prio = prio;
            this.value = value;
        }

        public int compareTo(Pair other) {
            return prio.compareTo(other.prio);
        }

        public String toString() {
            return "(" + prio + ", " + value + ")";
        }
    }

    // Pairs of (priority, values) are stored in this
    // array, but we are not going to use the first
    // position of the array (index = 0) to simplify
    // calculations of parent, left and right.
    private Pair[] array;

    // Index of last inserted element, 0 if empty.
    //
    // It is also the number of elements in the heap
    // as we keep the 0th element of the array empty
    // to simplify operations.
    private int last;

    // Initial capacity is enough for a binary tree of
    // depth 3 (15 elements plust the initial empty first
    // array position.
    private static final int INIT_LENGTH = 16;

    public Heap() {
        last = 0;
        // workaround to create an array of a generic type
        @SuppressWarnings("unchecked")
        Pair[] workaround = (Pair[])
            java.lang.reflect.Array.newInstance(
                    Pair.class, INIT_LENGTH);
        this.array = workaround;
        array[0] = null;
    }

    public boolean isEmpty() {
        return last == 0;
    }

    public int size() {
        return last;
    }

    // returns the index of the left of i
    private int left(int i) {
        return 2*i;
    }

    // returns the index of the right of i
    private int right(int i) {
        return 1 + 2*i;
    }

    // returns the index of the parent of i
    private int parent(int i) {
        if (i == 1) {
            throw new NoSuchElementException();
        }
        return i/2;
    }

    // swaps two elements in the array
    private void swap(int a, int b) {
        Pair tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    // creates a new array with double the capacity of the old one
    // and copies the data from the old one to the new one
    private void grow() {
        int newLength = array.length * 2;

        @SuppressWarnings("unchecked")
        Pair[] workaround = (Pair[])
            java.lang.reflect.Array.newInstance(Pair.class, newLength);
        // there are better ways to copy big arrays, but they are
        // not part of this course
        for (int i=0; i<array.length; i++) {
            workaround[i] = array[i];
        }
        this.array = workaround;
    }

    public void insert(P prio, V value) {
        if (last == array.length - 1) {
            grow();
        }

        // insert at the end
        array[++last] = new Pair(prio, value);

        // swap with parent until heap property is satisfied
        int current = last;
        try {
            while (array[current].compareTo(array[parent(current)]) > 0) {
                swap(current, parent(current));
                current = parent(current);
            }
        } catch (NoSuchElementException ex) {
            // stop swapping, we have reached the root.
        }
    }

    public V getMax() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[1].value;
    }

    // creates a new array half the size of the old one
    // and copies all the elements of the old one into the new one.
    private void shrink() {
        int newLength = array.length / 2;

        @SuppressWarnings("unchecked")
        Pair[] workaround = (Pair[])
            java.lang.reflect.Array.newInstance(Pair.class, newLength);
        // there are better ways to copy big arrays, but they are
        // not part of this course
        for (int i=0; i<=last; i++) {
            workaround[i] = array[i];
        }
        this.array = workaround;
    }

    // returns the index of the pair with the
    // biggest priority between a parent and
    // its children.
    //
    // In case of equal priorities, the parent
    // and then the left child take precedence.
    //
    // If parent has no children, the parent is
    // returned.
    private int biggestOfTheFamily(int parent) {
        int biggest = parent;
        // If I have a left child, compute the
        // biggest of parent, left and right (if right exist).
        if (left(parent) <= last) {
            biggest = (array[parent].compareTo(array[left(parent)]) >= 0)
                ?  parent : left(parent);
            if (right(parent) <= last) {
                biggest = (array[biggest].compareTo(array[right(parent)]) >= 0)
                    ? biggest : right(parent);
            }
        }
        return biggest;
    }

    public V removeMax() throws NoSuchElementException {
        V retval = getMax();

        if (array.length > INIT_LENGTH &&
                last < array.length / 4) {
            shrink();
        }

        // move last node to the root
        array[1] = array[last];
        array[last] = null;
        last--;

        // swap with the biggest child until the
        // heap order property is satisfied
        int current = 1;
        int biggest;
        while (current != (biggest = biggestOfTheFamily(current))) {
            swap(current, biggest);
            current = biggest;
        }

        return retval;
    }

    public String toString() {
        return toStringLevelOrder();
    }

    private String toStringLevelOrder() {
        StringBuilder sb = new StringBuilder("{(max)");
        for (int i=1; i<=last; i++) {
            sb.append(" ");
            sb.append(array[i]);
        }
        sb.append("}");
        return sb.toString();
    }

}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=3:foldtext=v\:foldend
