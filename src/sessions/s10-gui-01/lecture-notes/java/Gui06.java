import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Gui06 extends JFrame {
    private Gui06() {
        super("My first GUI");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui06 gui = new Gui06();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
