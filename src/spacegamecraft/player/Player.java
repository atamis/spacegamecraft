package spacegamecraft.player;

import spacegamecraft.InputHandler;
import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

/**
 * Currently acts as a cursor for looking at the galaxy.
 * @author atamiser
 *
 */
public class Player {
	public Point loc;
	public int color;
	
	/**
	 * Declare a player with a location and a color
	 * @param loc, starting location of the player
	 * @param color, color of the player.
	 */
	public Player(Point loc, int color) {
		this.loc = loc;
		this.color = color;
	}
	
	/**
	 * Draws the player onto the buffer.
	 * @param buf, the Buffer to draw onto.
	 * @return the drawn on buffer.
	 */
	public Buffer draw(Buffer buf) {
		try {
			buf.pixels[loc.x][loc.y] = color;
			buf.pixels[loc.x+1][loc.y] = color;
			buf.pixels[loc.x][loc.y+1] = color;
			buf.pixels[loc.x+1][loc.y+1] = color;
		} catch (Exception e) {
			System.out.println("Out of bounds");
		}

		return buf;
	}
	
	/**
	 * Obey input. Arrow keys act as they should.
	 * @param input, the InputHandler.
	 */
	public void handleKey(InputHandler input) {
		if(input.keys[39]) {
			moveRight();
		}
		if(input.keys[38]) {
			moveUp();
		}
		if(input.keys[37]) {
			moveLeft();
		}
		if(input.keys[40]) {
			moveDown();
		}
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
