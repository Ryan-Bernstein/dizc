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
    private int[] dimentions = {1920, 1080};

    public Display(Player player) {
        this.player = player;
        this.engine = new RayTraceTest(player, 600, 0.01, this); //VISUAL SETTINGS
    }

    public int[] getDimentions() {
        return dimentions;
    }

    protected void paintComponent(Graphics g) { // this will be called by repaint();
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = Color.getHSBColor(64, 66, 80);
        Color color2 = Color.black;
        GradientPaint gp = new GradientPaint(w / 2, 0, color1, w / 2, h / 2, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,0, dimentions[0], dimentions[1] / 2);

        color1 = Color.getHSBColor(1, 90, 60);
        color2 = Color.getHSBColor(0, 90, 40);
        gp = new GradientPaint(w / 2, h, color1, w / 2, h / 2, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,h / 2, w, h / 2);

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
        System.out.println(player);//temp line
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
