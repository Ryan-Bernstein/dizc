import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) {
        new Launcher();
    }
    /**
     * Constructor for the Main object.
     *
     * @param f First name of this Person instance
     * @param l Last name of this Person instance
     */
    public Launcher() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    // ex.printStackTrace();
                }

                JFrame frame = new JFrame("ARM");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

    }
}
