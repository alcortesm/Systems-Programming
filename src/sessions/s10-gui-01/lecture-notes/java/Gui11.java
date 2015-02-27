import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;

class Gui11 extends JFrame {
    private Gui11() {
        super("My first GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PsUtilities.setSwingDefaultFontSize(40);

        JLabel northText = new JLabel("Up");
        northText.setForeground(Color.RED);
        northText.setBackground(Color.BLUE);
        northText.setOpaque(true);

        JButton centerButton = new JButton("Center");

        JLabel southText = new JLabel("Down");
        southText.setBackground(Color.GREEN);
        southText.setOpaque(true);
        southText.setHorizontalAlignment(JLabel.CENTER);

        JLabel eastText = new JLabel("Right");

        JButton westButton = new JButton("Left");
        westButton.setBackground(Color.BLACK);
        westButton.setOpaque(true);
        westButton.setForeground(Color.WHITE);

        Container contentPane = getContentPane();
        contentPane.add(northText, BorderLayout.NORTH);
        contentPane.add(centerButton, BorderLayout.CENTER);
        contentPane.add(southText, BorderLayout.SOUTH);
        contentPane.add(eastText, BorderLayout.EAST);
        contentPane.add(westButton, BorderLayout.WEST);

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui11 gui = new Gui11();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
