import java.util.NoSuchElementException;

class Bst<K extends Comparable<K>, V>
    implements OrderedDictionary<K, V> {

    // Sometimes, the remove operation requires to choose
    // a child, either the in-order successor or the
    // in-order predecessor.
    //
    // Vf you always choose the same one, the tree
    // may become unbalenced. Choosing at random helps to
    // mitigate this effect.
    //
    // But choosing at random makes testing difficult
    // so V am giving here the option to select how
    // are you going to choose the nodes.
    //
    // Use random balancing for general use, and use
    // successor or predecessor for testing purposes.
    public static final int RANDOM_UNBALANCING = 0;
    public static final int PREDECESSOR_UNBALANCING = 1;
    public static final int SUCCESSOR_UNBALANCING = 2;

    private Node root;
    private int size;
    private int unBalancing;

    class Node implements Comparable<Node> {
        K key;
        V value;
        Node parent;
        Node left;
        Node right;

        // internal
        Node(K key, V value, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        // leaf
        Node(K key, V value, Node parent) {
            this(key, value, parent, null, null);
        }

        // root node
        Node(K key, V value) {
            this(key, value, null, null, null);
        }

        public int compareTo(Node node) {
            return this.key.compareTo(node.key);
        }

        void insert(K key, V value) {
            if (key.compareTo(this.key) == 0) {
                this.value = value;
            } else if (key.compareTo(this.key) > 0) {
                if (right == null) {
                    right = new Node(key, value, this);
                    size++;
                } else {
                    right.insert(key, value);
                }
            } else {
                if (left == null) {
                    left = new Node(key, value, this);
                    size++;
                } else {
                    left.insert(key, value);
                }
            }
        }

        Node findNode(K key) {
            if (this.key.compareTo(key) == 0) {
                return this;
            } else if (key.compareTo(this.key) > 0) {
                if (right != null) {
                    return right.findNode(key);
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                if (left != null) {
                    return left.findNode(key);
                } else {
                    throw new NoSuchElementException();
                }
            }
        }

        V find(K key) {
            return findNode(key).value;
        }

        int numChildren() {
            int num = 0;
            num += (left != null) ? 1 : 0;
            num += (right != null) ? 1 : 0;
            return num;
        }

        boolean AmILeftChild() {
            return (parent.left == this);
        }

        Node findClosest(K reference) {
            if (reference.compareTo(this.key) < 0) {
                if (left != null) {
                    return left.findClosest(reference);
                } else {
                    return this;
                }
            } else {
                if (right != null) {
                    return right.findClosest(reference);
                } else {
                    return this;
                }
            }
        }

        void removeNode() {
            switch (numChildren()) {
                case 0:
                    // just remove this node
                    if (this == root) {
                        root = null;
                    } else if (AmILeftChild()) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    break;
                case 1:
                    // replace this node with its child
                    Node child;
                    child = (left != null) ?  left : right;
                    child.parent = parent;
                    if (this == root) {
                        root = child;
                    } else {
                        if (AmILeftChild()) {
                            parent.left = child;
                        } else {
                            parent.right = child;
                        }
                    }
                    break;
                case 2:
                    // Choose candidate for substitution
                    Node substitutor;
                    switch (unBalancing) {
                        case RANDOM_UNBALANCING:
                            if (Math.random() >= 0.5D) {
                                substitutor = right.findClosest(key);
                            } else {
                                substitutor = left.findClosest(key);
                            }
                            break;
                        case PREDECESSOR_UNBALANCING:
                            substitutor = left.findClosest(key);
                            break;
                        case SUCCESSOR_UNBALANCING:
                            substitutor = right.findClosest(key);
                            break;
                        default:
                            throw new IllegalStateException(
                                    "Unknown \"unBalancing\" value: " +
                                    unBalancing);
                    }
                    this.value = substitutor.value;
                    this.key = substitutor.key;
                    substitutor.removeNode();
                    break;
            }
        }

        V remove(K key) {
            Node found = findNode(key);
            V retval = found.value;
            found.removeNode();
            return retval;
        }

        void stringBuilderInOrder(StringBuilder sb) {
            if (left != null) {
                left.stringBuilderInOrder(sb);
            }
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + key + "," + value + ")");
            if (right != null) {
                right.stringBuilderInOrder(sb);
            }
        }

        void stringBuilderLevelOrder(StringBuilder sb, Queue<Node> queue) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append("(" + key + "," + value + ")");
            if (left != null) {
                queue.enqueue(left);
            }
            if (right != null) {
                queue.enqueue(right);
            }
            if (queue.isEmpty()) {
                return;
            } else {
                queue.dequeue().stringBuilderLevelOrder(sb, queue);
            }
        }
    }

    public Bst(int balancing) {
        if (unBalancing != Bst.RANDOM_UNBALANCING &&
                unBalancing != Bst.PREDECESSOR_UNBALANCING &&
                unBalancing != Bst.SUCCESSOR_UNBALANCING) {
            throw new IllegalArgumentException("Unsupported balancing");
        }
        this.unBalancing = balancing;
        root = null;
        size = 0;
    }

    public Bst() {
        this(RANDOM_UNBALANCING);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value)
        throws IllegalStateException {
        if (key == null) {
            throw new IllegalStateException();
        }
        if (isEmpty()) {
            root = new Node(key, value);
            size++;
        } else {
            root.insert(key, value);
        }
    }

    public V find(K key)
        throws IllegalStateException, NoSuchElementException {
        if (key == null) {
            throw new IllegalStateException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return root.find(key);
    }

    public V remove(K key)
        throws IllegalArgumentException, NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (size() == 1) {
            if (root.key.compareTo(key) == 0) {
                V retval = root.value;
                clear();
                return retval;
            } else {
                throw new NoSuchElementException();
            }
        }
        V retval = root.remove(key);
        size--;
        return retval;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        root.stringBuilderInOrder(sb);
        return sb.toString();
    }

    public String toStringLevelOrder() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedQueue<Node>();
        root.stringBuilderLevelOrder(sb, queue);
        return sb.toString();
    }
}
