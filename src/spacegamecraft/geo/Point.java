package spacegamecraft.geo;

import java.util.Random;

public class Point {
	public int x;
	public int y;
	/**
	 * Made a new point
	 * @param x, the x coordinate.
	 * @param y, the y coordinate.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Generates a random point within the given range.
	 * @param xrange, the range the x point should have.
	 * @param yrange, the range the y point should have.
	 * @return a random point with coordinates between xrange and yrange.
	 */
	public static Point randomPoint(int xrange, int yrange) {
		Random rand = new Random();
		return new Point(rand.nextInt(xrange), rand.nextInt(yrange));
	}
	
	/**
	 * Adds the given x and y coordinates to this point, producing a new point.
	 * @param px, the x coordinate.
	 * @param py, the y coordinate.
	 * @return a new point, with the added coordinates.
	 */
	public Point add(int px, int py) {
		return new Point(x + px, y + py);
	}
	
	/**
	 * Adds this point to another point, producing a third point.
	 * @param p, the point to add.
	 * @return the point produced by adding this point and the argument.
	 */
	public Point add(Point p) {
		return add(p.x, p.y);
	}
	
	/**
	 * Pretty way of displaying a point.
	 */
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	/**
	 * Multiplies the x and y coordinates by a number
	 * @param i, the number to multiply by.
	 * @return a new point with the coordinates multiplied by i.
	 */
	public Point scale(int i) {
		return new Point(x*i, y*i);
	}

	/**
	 * Calculates the distance between 2 points.
	 * @param p, the point to calculate the distance to
	 * @return the distance.
	 */
	public double distance(Point p) {
		return Math.sqrt(Math.pow(p.x-x, 2) + Math.pow(p.y-y, 2));
	}
}
