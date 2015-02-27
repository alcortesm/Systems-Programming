import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Gui05 {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("My first GUI");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
        System.out.println("Main Thread finished!");
    }
}
