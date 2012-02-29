package spacegamecraft.data;

import java.util.ArrayList;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Color;

public class System {
	
	public static final int SYSTEM_COLOR = 0xdba92b;
	public static final int MAX_SYSTEM_SIZE = 3;
	
	public int system_size;
	
	/**
	 * Represents the location of this system in its galaxy chunk.
	 */
	public Point loc;
	
	/**
	 * List of space objects in this system. Could be planets, could be
	 * something else.
	 */
	public ArrayList<SpaceObject> objects;
	
	public System(Point loc, int system_size, ArrayList<SpaceObject> objects) {
		this.loc = loc;
		this.system_size = system_size;
		this.objects = objects;
	}
	
	public String toString() {
		StringBuilder x = new StringBuilder("(System " + loc.toString() + " " + system_size + " ");
		for(int i=0; i<objects.size(); i++) {
			x.append(objects.get(i).toString() + " ");
		}
		x.append(")");
		return x.toString();
	}

	public int systemColor() {
		switch(system_size) {
		case 0: return 0xddddff;
		case 1: return Color.fromRGB(63, 92, 144); // 63, 92, 144
		case 2: return SYSTEM_COLOR;
		}
		return SYSTEM_COLOR;
	}
}
