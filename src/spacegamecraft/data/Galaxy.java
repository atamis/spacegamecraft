package spacegamecraft.data;

import java.util.ArrayList;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

public class Galaxy {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	public ArrayList<System> systems;
	public ArrayList<Empire> empires;

	
	/**
	 * Creates a new Galaxy with systems and empires
	 * @param systems, ArrayList of systems.
	 * @param empires, ArrayList of empires.
	 */
	public Galaxy(ArrayList<System> systems, ArrayList<Empire> empires) {
		this.systems = systems;
		this.empires = empires;
	}

	/**
	 * Draws the galaxy onto the buffer starting at the given point. Doesn't
	 * actually draw anything itself, relies on systems to draw themselves
	 * @param point, Point where the drawing of the galaxy should start.
	 * @param buf, the buffer to draw onto
	 * @return the buffer with the galaxy drawn onto it.
	 */
	public Buffer draw(Point point, Buffer buf) {
		Buffer result = new Buffer(buf.pixels);
		for(int i=0; i<systems.size(); i++) {
			result = systems.get(i).draw(point, result);
		}
		return result;
	}
	
	/**
	 * Gets the system nearest to the given point.
	 * @param p, the point nearest to which we are finding a system
	 * @return the System nearest to the given point.
	 */
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
