package spacegamecraft.data;

import java.util.ArrayList;

public class Empire {
	/**
	 * The color indicative of the empire.
	 */
	public int color;
	
	/**
	 * Name of the empire.
	 */
	public String name;
	
	public ArrayList<System> owned_systems;

	public Empire(String name, int color) {
		super();
		this.name = name;
		this.color = color;
		this.owned_systems = new ArrayList<System>();
	}

	public Empire(String name, int color, ArrayList<System> owned_systems) {
		super();
		this.name = name;
		this.color = color;
		this.owned_systems = owned_systems;
	}
	
	
}
