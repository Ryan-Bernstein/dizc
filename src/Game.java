import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Game{
    private Player player;
//    private JLabel l;
    private JFrame frame;
    private Display dis;
//    private TextArea area;

    public Game(String name){
        player = new Player(name,300,300,0);
        frame = new JFrame();
        dis = new Display(player);
//        l = new JLabel();
//// setting the location of the label in frame
//        l.setBounds (20, 50, 100, 20);

    }

    public void createAndShowGui() throws IOException {

        // create the drawing JPanel
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dis.addKeyListener(dis);
        dis.setFocusable(true);
        frame.getContentPane().add(dis);
        frame.pack();


// adding the label and text area to the frame
//        frame.add(l);
// setting the size, layout and visibility of frame
        frame.setSize (1920, 1080);
        frame.setLayout (null);
        frame.setVisible (true);
    }


}

