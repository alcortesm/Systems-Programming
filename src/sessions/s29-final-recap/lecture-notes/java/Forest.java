import java.util.NoSuchElementException;

class Forest implements Queue<Tree> {

    private Node<Tree> first;
    private Node<Tree> last;
    private int size;

    Forest() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public Tree dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Tree retval = first.getInfo();
        first = first.getNext();
        size--;
        return retval;
    }

    public void enqueue(Tree tree) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }
        Node<Tree> newLast = new Node<Tree>(tree, null);
        if (size() == 0) {
            first = newLast;
        } else {
            last.setNext(newLast);
        }
        last = newLast;
        size++;
    }

    public String toString() {
        String retval = "";
        for (Node<Tree> c = first;
                c != null;
                c = c.getNext()) {
            retval += c.getInfo().toString();
        }
        return retval;
    }
}
