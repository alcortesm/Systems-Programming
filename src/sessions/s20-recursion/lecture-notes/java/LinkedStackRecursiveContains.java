// Stack implementation using a linked list
//
// This implmentation has infinite capacity.

import java.util.EmptyStackException;

class LinkedStackRecursiveContains<E> implements Stack<E> {

    private class Node<E> {
        E datum;
        Node<E> next;

        Node(E datum, Node<E> next) {
            this.datum = datum;
            this.next = next;
        }

        // this is part of the Node inner class
        boolean contains(E e) {
            if (e.equals(datum)) {
                return true;
            } if (next == null) {
                return false;
            } else {
                return next.contains(e);
            }
        }
    }

    private Node<E> top; // null means empty list

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E e) throws NullPointerException {
        if (e == null) {
            throw new NullPointerException();
        }
        top = new Node<E>(e, top);
    }

    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E retval = top.datum;
        top = top.next;
        return retval;
    }

    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.datum;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (Node<E> current = top;
                current != null;
                current = current.next) {
            sb.insert(0, current.datum);
            if (current.next != null) {
                sb.insert(0, ", ");
            } else {
                sb.append(" ");
            }
        }
        sb.insert(0, "Stack {");
        sb.append("(top)}");
        return sb.toString();
    }

    public boolean contains(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            return false;
        }
        return top.contains(e);
    }

    public static void main(String args[]) {
        Stack<String> s = new LinkedStackRecursiveContains<String>();

        // test contains on empty stack
        try {
            if (s.contains("hello")) {
                System.out.println("ERROR 001");
            }
        } catch (Exception ex) {
            System.out.println("ERROR 002");
        }

        // test contains on empty stack with null
        try {
            s.contains(null);
        } catch (NullPointerException ex) {
            // ok, do nothing
        } catch (Exception ex) {
            System.out.println("ERROR 003");
        }

        // try contains on non-empty stack
        s.push("1");
        s.pop();
        s.push("2");
        s.push("3");
        s.push("4");
        s.pop();
        s.push("5");
        s.push("6");
        s.pop();

        if (s.contains("1")) {
            System.out.println("ERROR 004");
        }
        if (! s.contains("2")) {
            System.out.println("ERROR 005");
        }
        if (! s.contains("3")) {
            System.out.println("ERROR 006");
        }
        if (s.contains("4")) {
            System.out.println("ERROR 007");
        }
        if (! s.contains("5")) {
            System.out.println("ERROR 008");
        }
        if (s.contains("6")) {
            System.out.println("ERROR 009");
        }

        // try contains on a stack that have been emptied
        while (! s.isEmpty()) {
            s.pop();
        }
        if (s.contains("1")) {
            System.out.println("ERROR 010");
        }
        if (s.contains("2")) {
            System.out.println("ERROR 011");
        }
        if (s.contains("3")) {
            System.out.println("ERROR 012");
        }
        if (s.contains("4")) {
            System.out.println("ERROR 013");
        }
    }
}
