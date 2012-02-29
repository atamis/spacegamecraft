package spacegamecraft.data;

import java.util.ArrayList;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

public class Galaxy {
	public ArrayList<GalaxyChunk> chunks;
	
	public Galaxy(ArrayList<GalaxyChunk> chunks) {
		this.chunks = chunks;
	}

	public Buffer draw(Point point, Buffer buf) {
		Buffer result = new Buffer(buf.pixels);
		for(int i=0; i<chunks.size(); i++) {
			result = chunks.get(i).draw(point, result);
		}
		return result;
	}
}
