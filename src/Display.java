import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Display extends JPanel implements KeyListener {
    private Player player;
    private RayTraceTest engine;
    private int[] dimentions = {1024, 768};

    public Display(Player player) {
        this.player = player;
        this.engine = new RayTraceTest(player, 600, 0.01, this); //VISUAL SETTINGS
    }

    public int[] getDimentions() {
        return dimentions;
    }

    protected void paintComponent(Graphics g) { // this will be called by repaint();
        super.paintComponent(g);

//        Graphics2D g2d = (Graphics2D) g.create(); // create graphics engine
        ArrayList<Column> renderSet= engine.getRenderSet();
        for (Column col: renderSet) {
            g.setColor(col.getColor());
            Rectangle2D rect = col.getRect();
            g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { //the keyboard listener implementation
        // New key press (ps I took part of this code)
        int key = e.getKeyCode();
        double angleBit = 3, distBit = 0.1;
        // If we press right
        double dist = 0, angle = 0;

        switch (key) {
            case KeyEvent.VK_RIGHT:
                angle += angleBit;
                break;
            case KeyEvent.VK_LEFT:
                angle -= angleBit;
                break;
            case KeyEvent.VK_UP:
                dist += distBit;
                break;
            case KeyEvent.VK_DOWN:
                dist -= distBit;
                break;
        }
        player.move(dist, angle);
//        player.move(dist, angle);
//        for(Column col: engine.getRenderSet()) {
//            System.out.print(col.getHeight() + ",");
//        } // debugging
//        System.out.println();
//        System.out.println(player);//temp line
        repaint();//temp
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    public static void main(String[] args) {

    }

}
