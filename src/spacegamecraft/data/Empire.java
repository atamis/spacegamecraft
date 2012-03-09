package spacegamecraft.data;

import java.util.ArrayList;

public class Empire {
	public static final int INFLUENCE_SPHERE_SCALE = 10;
	public static final int MAX_EMPIRE_SIZE = 10;

	
	/**
	 * The color indicative of the empire.
	 */
	public int color;
	
	/**
	 * Name of the empire.
	 */
	public String name;
	
	/**
	 * List of systems owned by this empire.
	 */
	public ArrayList<System> owned_systems;
	
	/**
	 * Size of the empire. Integer between 0 and 10.
	 */
	public int size;

	/**
	 * Make an empire with no owned systems.
	 * @param name, the name of the Empire.
	 * @param color, the Empire's color.
	 * @param size, the size of the empire, 0-10.
	 */
	public Empire(String name, int color, int size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.owned_systems = new ArrayList<System>();
	}

	/**
	 * Make an empire, specifying owned systems.
	 * @param name, name of the Empire.
	 * @param color, the Empire's color.
	 * @param size, the size of the Empire.
	 * @param owned_systems, ArrayList<System> of systems owned by the Empire.
	 */
	public Empire(String name, int color, int size, ArrayList<System> owned_systems) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.owned_systems = owned_systems;
	}
	
	/**
	 * The distance the sphere of influence of the Empire extends into space.
	 * @return integer
	 */
	public int influenceDistance() {
		return size * INFLUENCE_SPHERE_SCALE;
	}
	
}
