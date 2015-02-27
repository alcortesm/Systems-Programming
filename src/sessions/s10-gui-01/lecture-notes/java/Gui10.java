import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Color;

class Gui10 extends JFrame {
    private Gui10() {
        super("My first GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PsUtilities.setSwingDefaultFontSize(40);

        JLabel text = new JLabel("Hello World!");
        text.setForeground(Color.RED);
        text.setBackground(Color.BLUE);
        text.setOpaque(true);

        Container contentPane = getContentPane();
        contentPane.add(text);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui10 gui = new Gui10();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
