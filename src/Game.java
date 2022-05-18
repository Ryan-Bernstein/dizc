import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game{
    private Player player;
//    private JLabel l;
    private JFrame frame;
    private Display dis;
//    private TextArea area;

    public Game(String name){
        player = new Player(name,0,0,0);
        frame = new JFrame();
        dis = new Display(player);
//        l = new JLabel();
//// setting the location of the label in frame
//        l.setBounds (20, 50, 100, 20);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        dis.addKeyListener(dis);
        dis.setFocusable(true);
        frame.add(dis);

// adding the label and text area to the frame
//        frame.add(l);
// setting the size, layout and visibility of frame
        frame.setSize (1920, 1080);
        frame.setLayout (null);
        frame.setVisible (true);
    }



}

