//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class TestPanel extends JPanel implements KeyListener{
//
//    private Player player;
//    private int[] dimentions = {1920, 1080};
//    private int[] lDimentions = {20, 50, 100, 20};
//
//    public TestPanel(Player player) {
//
//
//
//
//        MouseAdapter ma = new MouseAdapter() {
//
//
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                repaint();
//            }
//
//
//        };
//
//        addMouseListener(ma);
//        addMouseMotionListener(ma);
//
//
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(200, 200);
//    }
//
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        for(Line armPiece: arms){
//            Graphics2D g2d = (Graphics2D) g.create();
//            g2d.dispose();
//        }
//        // if (selection != null) {
//        //     g.setColor(UIManager.getColor("List.selectionBackground"));
//        //     Graphics2D g2d = (Graphics2D) g.create();
//        //     g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
//        //     g2d.fill(selection);
//        //     g2d.dispose();
//        //     g2d = (Graphics2D) g.create();
//        //     g2d.draw(selection);
//        //     g2d.dispose();
//        // }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//// New key press (ps I took part of this code)
//        int key = e.getKeyCode();
//        double angleBit = 10, distBit = 10;
//        // If we press right
//        double dist = 0, angle = 0;
//        if (key == KeyEvent.VK_RIGHT) {
//            angle += angleBit;
//        }
//        if (key == KeyEvent.VK_LEFT) {
//            angle -= angleBit;
//        }
//        if (key == KeyEvent.VK_UP) {
//            dist += distBit;
//        }
//        if (key == KeyEvent.VK_DOWN) {
//            dist -= distBit;
//        }
//
//        player.move(dist, angle);
//        System.out.println(key);
//        System.out.println(player);//temp line
//        repaint();//temp
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//}