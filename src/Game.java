import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener{
    private Player player;
    private JLabel l;
    private JFrame frame;
//    private TextArea area;

    public Game(String name){
        player = new Player(name, 0,0,0);
        frame = new JFrame();
        l = new JLabel();
// setting the location of the label in frame
        l.setBounds (20, 50, 100, 20);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
// adding the label and text area to the frame
        frame.add(l);
// setting the size, layout and visibility of frame
        frame.setSize (1920, 1080);
        frame.setLayout (null);
        frame.setVisible (true);
    }


    @Override
    public void keyPressed(KeyEvent e){
        // New key press (ps I took part of this code)
        int key = e.getKeyCode();
        double angleBit = 10, distBit = 10;
        // If we press right
        double dist = 0, angle = 0;
        if (key == KeyEvent.VK_RIGHT) {
            angle += angleBit;
        }
        if (key == KeyEvent.VK_LEFT) {
            angle -= angleBit;
        }
        if (key == KeyEvent.VK_UP) {
            dist += distBit;
        }
        if (key == KeyEvent.VK_DOWN) {
            dist -= distBit;
        }
        player.move(dist, angle);
        System.out.println(player);//temp line
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
}

