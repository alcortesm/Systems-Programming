import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Gui27 extends JFrame implements ActionListener {

    private static int DEFAULT_FONT_SIZE = 40;

    private int clicksCounter = 0;

    private Gui27() {
        super("Swing Events Example");
        PsUtilities.setSwingDefaultFontSize(DEFAULT_FONT_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("clicks = " + clicksCounter);
        JButton stopButton = new JButton("clicks = " + clicksCounter);
        JLabel output = new JLabel("?");

        getContentPane().add(startButton, BorderLayout.WEST);
        getContentPane().add(stopButton, BorderLayout.EAST);
        getContentPane().add(output, BorderLayout.SOUTH);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (! (o instanceof JButton)) {
            throw new IllegalArgumentException();
        }
        JButton b = (JButton) o;
        clicksCounter++;
        b.setText("clicks = " + clicksCounter);
        pack();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui27 gui = new Gui27();
            }
        });
    }
}
