// Stack implementation using an array
//
// This particular implmentation is size bounded:
//
// - The constructor receives the max capacity.
// - The push method throws a StackOverflowException if full.

import java.util.EmptyStackException;

class ArrayStack<E> implements Stack<E> {

    private E[] array;
    private int top; // -1 means empty stack

    public ArrayStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }

        top = -1;
        // we would like to initialize the attribute like this:
        //    this.array = new E[capacity];
        // but Java does not allow to create "generic" arrays
        // so we use this (unsafe) workaround.
        @SuppressWarnings("unchecked")
        E[] workaround = (E[]) new Object[capacity];
        array = workaround;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(E e) throws NullPointerException, StackOverflowException {
        if (e == null) {
            throw new NullPointerException();
        }
        if (top == array.length-1) {
            throw new StackOverflowException();
        }
        array[++top] = e;
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E retval = array[top];
        array[top--] = null; // to help the garbage collector
        return retval;
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i<=top; i++) {
            sb.append(array[i].toString());
            if (i != top) {
                sb.append(", ");
            } else {
                sb.append(" ");
            }
        }
        sb.insert(0, "Stack {");
        sb.append("(top)}");
        return sb.toString();
    }
}
// vim: foldmethod=indent:foldminlines=0:foldnestmax=2:foldtext=v\:foldend
