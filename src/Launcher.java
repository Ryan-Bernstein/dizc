import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Launcher {
    private Player player;
    public static void main(String[] args) {

        new Launcher();
    }
    /**
     * Constructor for the Main object.
     *
     * @param f First name of this Person instance
     * @param l Last name of this Person instance
     */
    public Launcher(Player _player) {
        if(this.player == null){
            this.player = new Player("Dam", 0,0,0);
        }
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
                frame.add(new TestPanel(player));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

    }
}
