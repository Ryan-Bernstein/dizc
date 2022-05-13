
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Frame implements KeyListener {
    private Player player;
    private Label l;
    private TextArea area;

    public Game(String name){
        player = new Player(name, 0,0,0);
        l = new Label();
// setting the location of the label in frame
        l.setBounds (20, 50, 100, 20);
// creating the text area
        area = new TextArea();
// setting the location of text area
        area.setBounds (20, 80, 300, 300);
// adding the KeyListener to the text area
        area.addKeyListener(this);
// adding the label and text area to the frame
        add(l);
        add(area);
// setting the size, layout and visibility of frame
        setSize (400, 400);
        setLayout (null);
        setVisible (true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

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

}

