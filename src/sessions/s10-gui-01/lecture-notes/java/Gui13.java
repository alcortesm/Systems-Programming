import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

class Gui13 extends JFrame {
    private Gui13() {
        super("My first editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PsUtilities.setSwingDefaultFontSize(40);

        // create text area
        JTextArea textArea = new JTextArea("Here you can write text", 10, 20);

        // create button panel with buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton compileButton = new JButton("Compile");
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(compileButton);

        // create information label
        JLabel output = new JLabel("output for the user");
        output.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // add everything to the content pane
        Container contentPane = getContentPane();
        contentPane.add(textArea, BorderLayout.CENTER);
        contentPane.add(output, BorderLayout.SOUTH);
        contentPane.add(buttonPanel, BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui13 gui = new Gui13();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
