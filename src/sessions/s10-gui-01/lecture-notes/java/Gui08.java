import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import javax.swing.JLabel;

class Gui08 extends JFrame {
    private Gui08() {
        super("My first GUI");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PsUtilities.setSwingDefaultFontSize(40);

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
                Gui08 gui = new Gui08();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
