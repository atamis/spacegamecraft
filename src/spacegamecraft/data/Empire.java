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

	public Empire(String name, int color, int size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.owned_systems = new ArrayList<System>();
	}

	public Empire(String name, int color, int size, ArrayList<System> owned_systems) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.owned_systems = owned_systems;
	}
	
	public int influenceDistance() {
		return size * INFLUENCE_SPHERE_SCALE;
	}
	
}
