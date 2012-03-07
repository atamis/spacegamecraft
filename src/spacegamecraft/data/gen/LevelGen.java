package spacegamecraft.data.gen;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import spacegamecraft.data.Galaxy;
import spacegamecraft.data.SpaceObject;
import spacegamecraft.data.System;
import spacegamecraft.geo.Point;
import spacegamecraft.gfx.Buffer;

public class LevelGen {
	/**
	 * The max number of systems in a galaxy
	 */
	public static final int MAX_SYSTEMS = 100;
	/**
	 * Maximum number of objects in a system.
	 */
	public static final int MAX_OBJECTS = 10;
	private static final int PLANET_NAME_LENGTH = 10;
	
	public static Galaxy generateGalaxy(Random rand) {
		ArrayList<System> systems = new ArrayList<System>();
		for(int x=0; x < MAX_SYSTEMS; x++) {
			systems.add(generateSystem(rand));
		}
		return new Galaxy(systems);
	}
	
	public static System generateSystem(Random rand) {
		return generateSystem(new Point(rand.nextInt(Galaxy.WIDTH), rand.nextInt(Galaxy.HEIGHT)), rand);
	}

	public static System generateSystem(Point loc, Random rand) {
		ArrayList<SpaceObject> objects = new ArrayList<SpaceObject>();
		
		for(int number_objects = rand.nextInt(MAX_OBJECTS); number_objects > 0; number_objects--) {
			objects.add(generateObject(rand));
		}
		int system_size = rand.nextInt(3);
		
		return new System(loc, system_size, Gpw.generate(rand.nextInt(PLANET_NAME_LENGTH-3)+3, rand), objects);
	}

	public static SpaceObject generateObject(Random rand) {
		return new SpaceObject(Gpw.generate(rand.nextInt(PLANET_NAME_LENGTH-3)+3, rand));
	}
	
	public static String randomPlanetName(Random rand) {
		String[] characters = "abcdefghijklmnopqrstuvwxyz'aioue".split("");
		StringBuilder result = new StringBuilder();
		for(int length=rand.nextInt(PLANET_NAME_LENGTH-3)+3; length > 0; length--) {
			result.append(characters[rand.nextInt(characters.length)]);
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		int width = Galaxy.WIDTH;
		int height = Galaxy.HEIGHT;
		
		for(int i=0; i < 1; i++) {
			BufferedImage img = new BufferedImage(width+1, height+1, BufferedImage.TYPE_INT_RGB);
			Buffer buf = new Buffer(width, height);
			Galaxy gal = LevelGen.generateGalaxy(new Random());
			for(int s=0; s<gal.systems.size(); s++) {
				System sys = gal.systems.get(s);
				java.lang.System.out.println(sys.name);
				for(int o=0; o<sys.objects.size(); o++) {
					SpaceObject obj = sys.objects.get(o);
					java.lang.System.out.println("    " + obj.name);
				}
			}
			buf = gal.draw(new Point(0, 0), buf);
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
