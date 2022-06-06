import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Column{
    private int bottom;
    private int top;
    private Rectangle2D rect;
    private static double renderDist = 5;
    private Color color;
    private double dist;
    public Column(int top, int bottom, int res, int col, double dist, int screenWidth){
        this.top = top;
        this.bottom = bottom;
        this.dist = dist;
        this.rect = new Rectangle2D.Double(col * (screenWidth / res ) /* finds the size of a column * col number */, top, screenWidth / res, bottom - top); //create rectangle object
        this.color = Color.getHSBColor(0,0, (float)((dist <= renderDist) ? 1 - (dist/8) : 0)); // add in the color thing later

    }

    public Rectangle2D getRect() {
        return rect;
    }

    public int getTop(){return top;}

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
       return Double.toString(dist);
    }
}
