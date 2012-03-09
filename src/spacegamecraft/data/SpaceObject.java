package spacegamecraft.data;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

public class SpaceObject {
	/**
	 * Represents the local name for this space object.
	 */
	public String name;
	
	public SpaceObject(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "(SpaceObject " + name + ")";
		
	}

	/**
	 * Draws this space object onto the buffer. For now, this just draws a
	 * grey pixel at the commanded place
	 * @param p, the point to draw at
	 * @param buf, the buffer to draw onto.
	 * @return, the modified buffer.
	 */
	public Buffer draw(Point p, Buffer buf) {
		buf.set(p.x, p.y, 0x222222);
		return buf;
	}
}
