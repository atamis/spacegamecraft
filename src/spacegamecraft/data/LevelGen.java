package spacegamecraft.data;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

public class LevelGen {
	/**
	 * The max number of systems in a galactic chunk
	 */
	public static final int MAX_SYSTEMS = 10;
	/**
	 * Maximum number of objects in a system.
	 */
	public static final int MAX_OBJECTS = 10;
	
	public static Galaxy generateGalaxy(int x_chunks, int y_chunks, Random rand) {
		ArrayList<GalaxyChunk> chunks = new ArrayList<GalaxyChunk>();
		for(int x=0; x < x_chunks; x++) {
			for(int y=0; y < y_chunks; y++) {
				chunks.add(generateChunk(new Point(x, y), rand));
			}
		}
		return new Galaxy(chunks);
	}
	
	public static GalaxyChunk generateChunk(Point loc, Random rand) {
		ArrayList<System> systems = new ArrayList<System>();
		for(int number_systems = rand.nextInt(MAX_SYSTEMS); number_systems > 0; number_systems--) {
			systems.add(generateSystem(rand));
		}
		
		return new GalaxyChunk(loc, systems);
	}
	
	public static System generateSystem(Random rand) {
		return generateSystem(new Point(rand.nextInt(GalaxyChunk.CHUNK_SIZE), rand.nextInt(GalaxyChunk.CHUNK_SIZE)), rand);
	}

	public static System generateSystem(Point loc, Random rand) {
		ArrayList<SpaceObject> objects = new ArrayList<SpaceObject>();
		
		for(int number_objects = rand.nextInt(MAX_OBJECTS); number_objects > 0; number_objects--) {
			objects.add(generateObject());
		}
		int system_size = rand.nextInt(3);
		
		return new System(loc, system_size, objects);
	}

	public static SpaceObject generateObject() {
		return new SpaceObject("Awesome Planet");
	}
	
	public static void main(String[] args) {
		int chunks = 5;
		int width = GalaxyChunk.CHUNK_SIZE*2*chunks + 5;
		int height = GalaxyChunk.CHUNK_SIZE*2*chunks + 5;
		
		for(int i=0; i < 1; i++) {
			BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Buffer buf = new Buffer(width, height);
			buf = LevelGen.generateGalaxy(chunks, chunks, new Random()).draw(new Point(0, 0), buf);
			buf.drawOnImage(img);
			JOptionPane.showMessageDialog(null,
					null,
					"Another",
					JOptionPane.OK_CANCEL_OPTION,
					new ImageIcon(img.getScaledInstance(width*4, height * 4, Image.SCALE_AREA_AVERAGING)));
		}
		java.lang.System.exit(0);
	}
}
