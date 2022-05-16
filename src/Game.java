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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Line armPiece: arms){
            Graphics2D g2d = (Graphics2D) g.create();
            //System.out.print(""+(int)armPiece.getOrg().getX()+(int) armPiece.getOrg().getY()+ (int)armPiece.findB().getX()+ (int)armPiece.findB().getY());
            Line2D lin = new Line2D.Float((int)armPiece.getOrg().getX(),(int) armPiece.getOrg().getY(), (int)armPiece.findB().getX(), (int)armPiece.findB().getY());
            g2d.draw(lin);
            g2d.dispose();
        }
        // if (selection != null) {
        //     g.setColor(UIManager.getColor("List.selectionBackground"));
        //     Graphics2D g2d = (Graphics2D) g.create();
        //     g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        //     g2d.fill(selection);
        //     g2d.dispose();
        //     g2d = (Graphics2D) g.create();
        //     g2d.draw(selection);
        //     g2d.dispose();
        // }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

