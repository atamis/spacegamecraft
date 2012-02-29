package spacegamecraft.data;

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
}
