import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Launcher {
    private Display display;
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
    public Launcher() {
        if(this.player == null){
            this.player = new Player("Dam", 1,1,0);
            Scanner input = new Scanner(System.in);
            System.out.print("enter screen width in pixels: ");
            int width = input.nextInt();

            System.out.print("enter screen height in pixels: ");
            int height = input.nextInt();
            this.display = new Display(player, width, height);

        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                System.out.println(player.isWin());
//                if(!player.isWin()){
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException ex) {
                    // ex.printStackTrace();
                }

                JFrame frame = new JFrame("Dizc");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(display.getWidth(), display.getHeight());

                display.addKeyListener(display);
                display.setFocusable(true);
//                display.setBackground(Color.RED);
                display.repaint();
                frame.getContentPane().add(display);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(display.getWidth(), display.getHeight());
                frame.setVisible(true);




        }
        });

    }
}
