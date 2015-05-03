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

    public LinkedStack() {
        top = null;
    }

    public boolean empty() {
        return top == null;
    }

    public void push(int i) {
        top = new Node(i, top);
    }

    public int pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        int result = top.info;
        top = top.next;
        return result;
    }
}
