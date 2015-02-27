import javax.swing.JFrame;

class Gui04 {
    private static void createAndShowGui() {
        JFrame frame = new JFrame("My first GUI");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        createAndShowGui();
        System.out.println("Main Thread finished!");
    }
}
