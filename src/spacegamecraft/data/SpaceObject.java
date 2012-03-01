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

	public Buffer draw(Point p, Buffer buf) {
		try {
			buf.pixels[p.x][p.y] = 0x222222;
		} catch (Exception e) {
			
		}
		return buf;
	}
}
