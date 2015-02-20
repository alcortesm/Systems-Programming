import java.io.PrintStream;

class ReversiblePrintStream extends PrintStream implements Reversible {
    private boolean reversed;

    public ReversiblePrintStream(PrintStream ps) {
        super(ps);
        this.reversed = false;
    }

    private void reverseArray(char[] array) {
            for (int i=0; i<(array.length/2); i++) {
                char tmp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = tmp;
            }
    }

    public void print(String s) {
        String toPrint;
        if (reversed) {
            // students do not need to know about reverse method in
            // StringBuilder:
            // toPrint = new StringBuilder(s).reverse().toString();
            char[] array = s.toCharArray();
            reverseArray(array);
            toPrint = new String(array);
        } else {
            toPrint = s;
        }
        super.print(toPrint);
    }

    public void reverse() {
        this.reversed ^= true;
    }
}
