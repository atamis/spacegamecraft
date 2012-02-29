package spacegamecraft.data;

import java.util.ArrayList;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

/**
 * Represents a chunk of the galaxy. Has a location and a list of systems.
 * @author atamiser
 *
 */
public class GalaxyChunk {
	public static final int CHUNK_SIZE = 16;
	
	/**
	 * The location of the chunk in real space. This doesn't represent a corner
	 * or something, but the location in the galaxy map.
	 */
	public Point loc;
	
	/**
	 * List of systems in this chunk.
	 */
	ArrayList<System> systems;
	
	public GalaxyChunk(Point loc, ArrayList<System> systems) {
		this.loc = loc;
		this.systems = systems;
	}
	
	public String toString() {
		StringBuilder x = new StringBuilder("(GalaxyChunk " + loc.toString() + " ");
		for(int i=0; i < systems.size(); i++) {
			x.append(systems.get(i).toString() + " ");
		}
		x.append(")");
		return x.toString();
	}

	public Buffer draw(Point point, Buffer buf) {
		for(int i=0; i < systems.size(); i++) {
			System sys = systems.get(i);
			Point abs_loc = loc.scale(CHUNK_SIZE).add(point).add(sys.loc).scale(2);
			buf.pixels[abs_loc.x][abs_loc.y] = sys.systemColor();
		}
		return buf;
	}
}
