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

    public Display(Player player, int width, int height) {
        this.dimentions[0] = width;
        this.dimentions[1] = height;
        this.player = player;
        this.engine = new RayTraceTest(player, 1000, 0.01, this);
        player.setEngine(engine);
        //VISUAL SETTINGS
    }

    public int[] getDimentions() {
        return dimentions;
    }

    protected void paintComponent(Graphics g) { // this will be called by repaint();
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = Color.getHSBColor(64, 66, (float) .30);
        Color color2 = Color.black;
        GradientPaint gp = new GradientPaint(w / 2, 0, color1, w / 2, h / 2, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0,0, dimentions[0], dimentions[1] / 2);

        color1 = Color.getHSBColor((float) .616, (float) .4, 0);
        color2 = Color.getHSBColor((float) .616, (float) .4, (float) .6);
        gp = new GradientPaint(w / 2, h / 2, color1, w / 2, h, color2);
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
