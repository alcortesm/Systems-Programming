import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Gui29 extends JFrame implements ActionListener {

    private static int DEFAULT_FONT_SIZE = 40;

    private int startClicksCounter = 0;
    private int stopClicksCounter = 0;
    private JButton startButton;
    private JButton stopButton;
    private JLabel output;

    private String labelText() {
        return "Start clicks: " + startClicksCounter + ", stop clicks: " + stopClicksCounter;
    }

    private Gui29() {
        super("Swing Events Example");
        PsUtilities.setSwingDefaultFontSize(DEFAULT_FONT_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        output = new JLabel(labelText());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
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
        if (b == startButton) {
            startClicksCounter++;
        } else if (b == stopButton) {
            stopClicksCounter++;
        } else {
            throw new IllegalArgumentException();
        }
        output.setText(labelText());
        pack();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui29 gui = new Gui29();
            }
        });
    }
}
