import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.util.NoSuchElementException;
import javax.swing.SwingUtilities;

class PrimesGui {
    private static final int MAX_NUMBER_TO_CHECK = 100;
    private static final int DEFAULT_FONT = 40;
    private static final String COMMAND_START = "COMMAND_START";
    private static final String COMMAND_STOP = "COMMAND_STOP";

    private PrimeGenerator primeGenerator;
    private boolean running = false;
    private Worker worker;

    private JLabel output;
    private JButton startButton;
    private JButton stopButton;

    private void setButtonsEnabledProperty() {
        if (running) {
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        } else {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }

    private static void setFontSize(int fontSize) {
        java.util.Hashtable<Object, Object> defaults = javax.swing.UIManager.getDefaults();
        java.util.Enumeration keys = defaults.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            if ((key instanceof String) && (((String) key).endsWith(".font"))) {
                javax.swing.plaf.FontUIResource font = (javax.swing.plaf.FontUIResource) javax.swing.UIManager.get(key);
                defaults.put (key, new javax.swing.plaf.FontUIResource(font.getFontName(), font.getStyle(), fontSize));
            }
        }
    }

    private void createAndShowGui() {
        setFontSize(DEFAULT_FONT);
        JFrame frame = new JFrame("PrimesGui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonListener buttonListener = new ButtonListener();

        // Graphical objects
        startButton = new JButton("Start");
        startButton.setActionCommand(COMMAND_START);
        startButton.addActionListener(buttonListener);

        stopButton = new JButton("Stop");
        stopButton.setActionCommand(COMMAND_STOP);
        stopButton.addActionListener(buttonListener);

        setButtonsEnabledProperty();

        output = new JLabel("?", SwingConstants.RIGHT);

        // Panels
        // contentPane: BordeLayout
        // buttonPane: Grindlayout at contentPane center
        JPanel contentPane = (JPanel) frame.getContentPane();
        JPanel buttonPane = new JPanel(new GridLayout(1, 2));
        frame.getContentPane().add(buttonPane, BorderLayout.CENTER);

        // add graphical objets to panels
        contentPane.add(output, BorderLayout.SOUTH);
        buttonPane.add(startButton, 0, 0);
        buttonPane.add(stopButton, 0, 1);

        frame.pack();
        frame.setVisible(true);
    }

    private PrimesGui(PrimeGenerator primeGenerator) {
        this.primeGenerator = primeGenerator;
    }

    public static void main(String args[]) {
        final PrimeGenerator primeGenerator = new PrimeGenerator(MAX_NUMBER_TO_CHECK);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PrimesGui app = new PrimesGui(primeGenerator);
                app.createAndShowGui();
            }
        });
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case COMMAND_START:
                    if (running) {
                        return;
                    }
                    running = true;
                    setButtonsEnabledProperty();
                    worker = new Worker();
                    worker.start();
                    break;
                case COMMAND_STOP:
                    if (! running) {
                        return;
                    }
                    running = false;
                    setButtonsEnabledProperty();
                    worker.interrupt();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private class Worker extends Thread {
        public void run() {
            try {
                while (true) {
                    int prime = primeGenerator.next();
                    final String primeStr = "" + prime;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            output.setText(primeStr);
                        }
                    });
                }
            } catch (NoSuchElementException ex) {
                running = false;
                primeGenerator = new PrimeGenerator(MAX_NUMBER_TO_CHECK);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setButtonsEnabledProperty();
                        output.setText("Finished!");
                    }
                });
            } catch (InterruptedException ex) {
            }
        }
    }
}
