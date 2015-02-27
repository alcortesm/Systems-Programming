import javax.swing.JFrame;

class Gui01 {
    public static void main(String args[]) {
        // creates an invisible frame the argument as title
        JFrame frame = new JFrame("My first GUI");
        frame.setSize(640, 480);
        frame.setVisible(true);

        System.out.println("Main Thread finished!");
    }
}
