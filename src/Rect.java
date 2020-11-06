/**
 * @author Narcis Spanache
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rect is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the rect's bounding rectangle.
 */
public class Rect extends ClosedShape {

    /**
     * the width and height of the rect
     */
    private int width, height;

    /**
     *  Creates a rect
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rect (in pixels).
     * @param height The height of the rect (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the oval is filled with colour, false if opaque.
     */
    public Rect (int x, int y, int vx, int vy, int width, int height,  boolean isFilled, Color colour, int insertionTime) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert an rect to a string.
     */
    public String toString () {
        String result = "This is an rect\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @param width reset the width of the rect
     */
    public void setWidth(int width) { this.width = width; }

    /**
     * @param height reset the height of the rect
     */
    public void setHeight(int height) { this.height = height; }

    /**
     * @return the width of the rect
     */
    @Override
    public int getWidth () { return width; }

    /**
     * @return the height of the rect
     */
    @Override
    public int getHeight () { return height; }

    /**
     * Draw the rect
     * @param g The graphics object associated with the drawing component.
     */
    @Override
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.strokeRect( x, y, width, height );
        }
    }
}
