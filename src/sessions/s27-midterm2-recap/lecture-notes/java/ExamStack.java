import java.util.EmptyStackException;

class ExamStack implements Stack {

    private static final int INITIAL_CAPACITY = 10;
    private static final int MINIMUM_CAPACITY
        = INITIAL_CAPACITY;

    private int[] array;
    private int size;

    public ExamStack() {
        array = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    private void grow() {
        // calculate new size
        int newLenght = 2 * array.length;
        // create the new (and bigger array)
        int[] newArray = new int[newLenght];
        // copy elements from the old array to the new one
        for (int i=0; i<array.length; i++) {
            newArray[i] = array[i];
        }
        // sobstitute the old array with the new one
        array = newArray;
    }

    public void push(int element) {
        if (size == array.length) {
            grow();
        }
        array[size++] = element;
    }

    private void shrink() {
        int newLenght = array.length / 2;
        int[] newArray = new int[newLenght];
        // carefull here!, copy only until before size!
        for (int i=0; i<size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        if (size >= INITIAL_CAPACITY / 2 &&
                size == array.length / 4) {
            shrink();
        }
        return array[--size];
        // Important: you cannot set array[size] = null here
        // to help the garbage collector, as the array is of
        // ints.
        //
        // The good news is that you do not have to; Why?
    }
}
