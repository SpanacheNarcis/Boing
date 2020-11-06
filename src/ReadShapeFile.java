/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Narcis Spanache
 *
 */

import javafx.scene.paint.Color;

import java.io.File;
import java.util.Scanner;


public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	private static Hexagon readHexagon(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertionTime = in.nextInt();

		Hexagon myHexagon = new Hexagon(px, py, vx, vy, width, height, Color.rgb(r,g,b), isFilled, insertionTime);
		//System.out.println(myHexagon.toString());

		return myHexagon;
	}
	private static Circle readCircle(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int diameter = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertionTime = in.nextInt();

		Circle myCircle = new Circle (insertionTime, px, py, vx, vy, diameter, Color.rgb(r,g,b), isFilled);

		return myCircle;
	}

	private static Oval readOval(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertion = in.nextInt();

		Oval myOval = new Oval (insertion, px, py, vx, vy, width, height, Color.rgb(r,g,b), filled);

		return myOval;

	}

	private static Square readSquare (Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int side = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertionTime = in.nextInt();

		Square mySquare = new Square(px, py, vx, vy, Color.rgb(r,g,b), isFilled, insertionTime, side);

		return mySquare;
	}

	private static Rect readRect (Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertionTime = in.nextInt();

		Rect myRect = new Rect(px, py, vx, vy, width, height, isFilled, Color.rgb(r,g,b), insertionTime);

		return myRect;
	}


	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			Scanner newIn = new Scanner(line);

			 String shape = newIn.next();
			if(shape.equals("circle")) {
				shapeQueue.enqueue(ReadShapeFile.readCircle(newIn));
			}
			else if(shape.equals("oval")) {
				shapeQueue.enqueue(ReadShapeFile.readOval(newIn));
            }
			else if(shape.equals("square")) {
				shapeQueue.enqueue(ReadShapeFile.readSquare(newIn));
            }
			else if(shape.equals("rect")) {
				shapeQueue.enqueue(ReadShapeFile.readRect(newIn));
            }
			else if(shape.equals("hexagon")) {
				shapeQueue.enqueue(ReadShapeFile.readHexagon(newIn));
			}
		}
		//read in the shape files and place them on the Queue
		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
		Scanner in = null;
		try {
			File file = new File(filename);
			in = new Scanner(file);
		}
		catch(Exception e) {
			System.out.println("We cannot find the file");
		}
	    
	    return ReadShapeFile.readDataFile(in);
	    
	}
}
