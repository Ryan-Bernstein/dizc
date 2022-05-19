import javax.swing.*;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game game = new Game("tim");
                    game.createAndShowGui();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
