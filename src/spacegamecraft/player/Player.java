package spacegamecraft.player;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;
import spacegamecraft.gfx.Color;

public class Player {
	public Point loc;
	public int color;
	
	public Player(Point loc, int color) {
		this.loc = loc;
		this.color = color;
	}
	
	public Buffer draw(Buffer buf) {
		buf.pixels[loc.x][loc.y] = color;
		buf.pixels[loc.x+1][loc.y] = color;
		buf.pixels[loc.x][loc.y+1] = color;
		buf.pixels[loc.x+1][loc.y+1] = color;

		return buf;
	}
	
	public void moveUp() {
		loc = loc.add(0, -1);
	}
	public void moveDown() {
		loc = loc.add(0, 1);
	}
	public void moveLeft() {
		loc = loc.add(-1, 0);
	}
	public void moveRight() {
		loc = loc.add(1, 0);
	}
}
