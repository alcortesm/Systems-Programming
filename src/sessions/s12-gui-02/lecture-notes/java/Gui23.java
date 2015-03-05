import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Gui23 extends JFrame {
    private static int DEFAULT_FONT_SIZE = 40;

    private Gui23() {
        super("Swing Events Example");
        PsUtilities.setSwingDefaultFontSize(DEFAULT_FONT_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JLabel output = new JLabel("?");

        getContentPane().add(startButton, BorderLayout.WEST);
        getContentPane().add(stopButton, BorderLayout.EAST);
        getContentPane().add(output, BorderLayout.SOUTH);

        startButton.addActionListener(new ButtonFunctor());
        stopButton.addActionListener(new ButtonFunctor());

        pack();
        setVisible(true);
    }

    private class ButtonFunctor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (! (o instanceof JButton)) {
                throw new IllegalArgumentException();
            }
            JButton b = (JButton) o;
            String text = b.getText();
            System.out.println(text + " button click detected!");
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui23 gui = new Gui23();
            }
        });
    }
}
