import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;

public class Display extends JPanel implements KeyListener {
    private Player player;
    private int[] dimentions = {1920, 1080};
    private int[] lDimentions = {20, 50, 100, 20};

    public Display(Player player){
        this.player = player;
    }

    protected void paintComponent(Graphics g) { // this will be called by repaint();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create(); // create graphics engine
        Rectangle lin = new Line2D.Float((int) player.getX(), (int) player.getY() + 10, (int) player.getX(), (int) player.getY() - 10);// generate the line obj
        g2d.draw(lin); //draw the line
        g2d.dispose(); //clear the object
    }
    @Override
    public void keyPressed(KeyEvent e){ //the keyboard listener implementation
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
        repaint();//temp
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

}
