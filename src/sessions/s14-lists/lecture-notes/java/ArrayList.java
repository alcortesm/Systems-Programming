// Lists implementation using and array.
//
// It will try to save memory by keeping the array capacity
// close to the current size of the list.
//
// Duplicated elements are allowed.

import java.util.NoSuchElementException;

class ArrayList<E> implements List<E> {
    // most JVM don't allow Integer.MAX_VALUE arrays, but -2, -4 or -8
    // so use -10 just in case
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 10;
    private static final int MIN_CAPACITY = 10;
    private static final int DEFAULT_CAPACITY = MIN_CAPACITY;

    private E[] array;
    private int size;

    public ArrayList() {
        size = 0;
        // We whould like to initialize our array like this:
        //    array = new E[DEFAULT_CAPACITY];
        // but Java does not allow creating "generic" arrays.
        // The following 3 lines is a workaround:
        @SuppressWarnings("unchecked")
        E[] workaround = (E[]) new Object[DEFAULT_CAPACITY];
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
        //System.out.println("grow! " + array.length + " --> " + newLength);

        @SuppressWarnings("unchecked")
        E[] workaround = (E[]) new Object[newLength];
        // there are better ways to copy big arrays, but they are
        // not part of this course
        for (int i=0; i<array.length; i++) {
            workaround[i] = array[i];
        }
        this.array = workaround;
    }

    public void add(int i, E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == MAX_CAPACITY) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            grow();
        }
        // shift elements to the right
        for (int j=size-1; j>=i; j--) {
            array[j+1] = array[j];
        }
        // insert new element
        array[i++] = e;
        size++;
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    public void set(int i, E e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = e;
    }

    public void clear() {
        for (int i=0; i<size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private void shrink() {
        int newLength;
        if (array.length / 2 < MIN_CAPACITY) {
            newLength = MIN_CAPACITY;
        } else {
            newLength = array.length / 2;
        }
        //System.out.println("shrink! " + array.length + " --> " + newLength);

        @SuppressWarnings("unchecked")
        E[] workaround = (E[]) new Object[newLength];
        // there are better ways to copy big arrays, but they are
        // not part of this course
        for (int i=0; i<size; i++) {
            workaround[i] = array[i];
        }
        this.array = workaround;
    }

    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        E retval = array[i];
        // shift elements to the left
        for (int j=i; j<(size-1); j++) {
            array[j] = array[j+1];
        }
        size--;
        array[size] = null;
        if ((array.length > MIN_CAPACITY)
                && (size <= (array.length / 4))) {
            shrink();
        }
        return retval;
    }

    public boolean contains(E e) {
        for (int i=0; i<size; i++) {
            if (e.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i=0; i<size; i++) {
            if (e.equals(array[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LIST[ ");
        for (int i=0; i<size; i++) {
            sb.append(array[i]);
            if (i != size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
