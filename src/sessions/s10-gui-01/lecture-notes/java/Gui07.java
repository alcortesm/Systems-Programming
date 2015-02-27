import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import javax.swing.JLabel;

class Gui07 extends JFrame {
    private Gui07() {
        super("My first GUI");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // add a graphical component
        JLabel text = new JLabel("Hello World!");
        // graphical components are added to the content pane of the frame
        Container contentPane = getContentPane();
        contentPane.add(text);

        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui07 gui = new Gui07();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
