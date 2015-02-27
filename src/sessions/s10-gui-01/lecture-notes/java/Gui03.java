import javax.swing.JFrame;

class Gui03 {
    public static void main(String args[]) {
        JFrame frame = new JFrame("My first GUI");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("Main Thread finished!");
    }
}
