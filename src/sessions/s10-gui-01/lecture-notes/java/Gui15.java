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
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

class Gui15 extends JFrame {
    private Gui15() {
        super("My first editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PsUtilities.setSwingDefaultFontSize(40);

        // create text area
        JTextArea textArea = new JTextArea("Here you can write text", 10, 20);
        JScrollPane textScrollPane = new JScrollPane(textArea);

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

        // create a file chooser
        JRadioButton java = new JRadioButton("Java");
        JRadioButton c = new JRadioButton("C");
        JRadioButton cpp = new JRadioButton("C++");
        JRadioButton python = new JRadioButton("Python");
        ButtonGroup group = new ButtonGroup();
        group.add(java);
        group.add(c);
        group.add(cpp);
        group.add(python);
        java.setSelected(true);
        JPanel lang = new JPanel(new GridLayout(0, 1));
        lang.add(java);
        lang.add(c);
        lang.add(cpp);
        lang.add(python);


        // add everything to the content pane
        Container contentPane = getContentPane();
        contentPane.add(textScrollPane, BorderLayout.CENTER);
        contentPane.add(output, BorderLayout.SOUTH);
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(lang, BorderLayout.WEST);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui15 gui = new Gui15();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
