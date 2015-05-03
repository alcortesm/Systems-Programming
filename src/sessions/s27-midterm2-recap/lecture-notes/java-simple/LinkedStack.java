import java.util.EmptyStackException;

class LinkedStack implements Stack {

    private class Node {
        int info;
        Node next;
        Node(int info, Node next) {
            this.info = info;
            this.next = next;
        }
    }

    private Node top;

    public LinkedStack() { }

    public boolean empty() { }

    public void push(int i) { }

    public int pop() throws EmptyStackException { }
}
