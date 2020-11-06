/**
 * @author Narcis Spanache
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Hexagon is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the hexagon's bounding rectangle.
 */
public class Hexagon extends ClosedShape {

    private double[] xPoints = new double[6];
    private double[] yPoints = new double[6];
    private int width;
    private int height;
        /**
            * @param x1 The display component's x position.
            * @param y1 The display component's y position.
            * @param vx The display component's x velocity.
            * @param vy The display component's y velocity.
            * @param width The width of the hexagon (in pixels).
            * @param height The height of the hexagon (in pixels).
            * @param colour The line colour or fill colour.
	        * @param isFilled True if the hexagon is filled with colour, false if opaque.
         */
    public Hexagon (int x1, int y1, int vx, int vy, int width, int height, Color colour, boolean isFilled, int insertionTime) {
        super(insertionTime,x1, y1, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
        setCoordinates(x1, y1);
    }

    /**
     * Method to convert an hexagon to a string.
     */
    public String toString () {
        String result = "This is an hexagon\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @param width reset the width
     */
    public void setWidth(int width) { this.width = width; }

    /**
     * @param height reset the height
     */
    public void setHeight(int height) { this.height = height; }

    /**
     * @return the width of the hexagon
     */
    public int getWidth() { return width; }

    /**
     * @return the height of the hexagon
     */
    public int getHeight() { return height; }

    /**
     * set the coordinates after a point A(x1, y1)
     * @param x1 the start coordinate x
     * @param y1 the start coordinate y
     */
    public void setCoordinates(double x1, double y1) {
        this.xPoints[0] = x1 + width/2;
        this.yPoints[0] = y1;

        this.xPoints[1] = x1 + width;
        this.yPoints[1] = y1 + 0.3 * height;

        this.xPoints[2] = this.xPoints[1];
        this.yPoints[2] = this.yPoints[1] + 0.4 * height;

        this.xPoints[3] = this.xPoints[0];
        this.yPoints[3] = this.yPoints[2] + 0.3 * height;

        this.xPoints[4] = x1 ;
        this.yPoints[4] = this.yPoints[2];

        this.xPoints[5] = this.xPoints[4];
        this.yPoints[5] = this.yPoints[1];
    }


    /**
     * Draw the hexagon.
     * @param g The graphics object associated with the drawing component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        setCoordinates(x,y);
        if (isFilled) {
            g.fillPolygon( xPoints , yPoints, 6);
        }
        else {
            g.strokePolygon(xPoints, yPoints, 6 );
        }
    }
}