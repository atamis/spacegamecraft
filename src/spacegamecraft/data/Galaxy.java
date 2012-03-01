package spacegamecraft.data;

import java.util.ArrayList;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

public class Galaxy {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	public ArrayList<System> systems;
	
	public Galaxy(ArrayList<System> systems) {
		this.systems = systems;
	}

	public Buffer draw(Point point, Buffer buf) {
		Buffer result = new Buffer(buf.pixels);
		for(int i=0; i<systems.size(); i++) {
			result = systems.get(i).draw(point, result);
		}
		return result;
	}
	
	public System nearestSystem(Point p) {
		System best_system = null;
		double best_distance = 6.022 * Math.pow(10, 23); // A mole of distance units should be enough
		for(int i=0; i < systems.size(); i++){
				System sys = systems.get(i);
				double distance = p.distance(sys.loc);
				if(distance < best_distance) {
					best_distance = distance;
					best_system = sys;
				}
			}
		return best_system;
	}
}
