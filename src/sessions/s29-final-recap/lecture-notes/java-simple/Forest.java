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
        // to do, just because
        return null;
    }

    public void enqueue(Tree tree) {
        // to do in section 1
    }

    public String toString() {
        // to do in section 4
        return "";
    }
}
