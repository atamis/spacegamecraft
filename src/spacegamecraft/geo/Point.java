package spacegamecraft.geo;

import java.util.Random;

public class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Point randomPoint(int xrange, int yrange) {
		Random rand = new Random();
		return new Point(rand.nextInt(xrange), rand.nextInt(yrange));
	}
	
	public Point add(int px, int py) {
		return new Point(x + px, y + py);
	}
	
	public Point add(Point p) {
		return add(p.x, p.y);
	}
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	public Point scale(int i) {
		return new Point(x*i, y*i);
	}
}
