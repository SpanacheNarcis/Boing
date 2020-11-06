/**
 * @author Narcis Spanache
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square is an Square shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 */
public class Square extends ClosedShape {
    /**
     * the length of a side in the square
     */
    private int side;

    /**
     *  Creates a square
     *
     *   @param x The display component's x position.
     * 	 @param y The display component's y position.
     * 	 @param vx The display component's x velocity.
     * 	 @param vy The display component's y velocity.
     * 	 @param colour The line colour or fill colour.
     *   @param side The length of a side
     * 	 @param isFilled True if the oval is filled with colour, false if opaque.
     */
    public Square (int x, int y, int vx, int vy, Color colour, boolean isFilled,int insertionTime, int side ) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Method to convert an square to a string.
     */
    public String toString () {
        String result = "This is an oval\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     *
     * @param side reset the side length
     */
    public void setSide (int side) { this.side = side; }

    /**
     * @return the width of the square
     */
    @Override
    public int getWidth () { return side; }

    /**
     * @return the Height of the square
     */
    @Override
    public int getHeight() { return side; }

    /**
     * Draw the square
     * @param g The graphics object associated with the drawing component.
     */
    @Override
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side);
        }
        else {
            g.strokeRect( x, y, side, side);
        }
    }

}
