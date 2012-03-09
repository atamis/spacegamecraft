package spacegamecraft.gfx;

import java.util.Random;

public class Color {
	/**
	 * This is treated as transparent by Buffer.
	 */
	public static final int INVISIBLE = 0xabcde;
	
	/**
	 * All green, all the time.
	 */
	public static final int GREEN = Color.fromRGB(0, 0xff, 0);
	
	/**
	 * Produces a single color integer from single red, green, and blue values.
	 * @param r, int between 0 and 255 (0xff), representing the red part.
	 * @param g, int between 0 and 255 (0xff), representing the green part.
	 * @param b, int between 0 and 255 (0xff), representing the blue part;
	 * @return integer between 0x010101 and 0xffffff
	 */
	public static int fromRGB(int r, int g, int b) {
		// Magic numbers! Woo!
		int x = 0;
		x = x + b;
		x = x + g*0x100;
		x = x + r*0x010000;
		return x;
	}
	
	/**
	 * Returns the red portion of an integer. Integer is assume to be between
	 * 0xffffff and 0x010101 (inclusive), but probably won't fail too hard if
	 * that rule is broken.
	 * @param x, the color.
	 * @return
	 */
	public static int red(int x) {
		return (int) (x/0x010000);
	}
	
	/**
	 * Returns the green portion of an integer. Integer is assume to be between
	 * 0xffffff and 0x010101 (inclusive), but probably won't fail too hard if
	 * that rule is broken.
	 * @param x, the color.
	 * @return
	 */
	public static int green(int x) {
		return (int) ((x-red(x)*0x010000)/0x100);
	}
	
	/**
	 * Returns the blue portion of an integer. Integer is assume to be between
	 * 0xffffff and 0x010101 (inclusive), but probably won't fail too hard if
	 * that rule is broken.
	 * @param x, the color.
	 * @return
	 */
	public static int blue(int x) {
		return (int) ((x-red(x)*0x010000-green(x)*0x100));
	}

	/**
	 * Returns a random color from the given Random instance
	 * @param rand, Random instance to use
	 * @return a color int between 0 and 0xffffff
	 */
	public static int randColor(Random rand) {
		return rand.nextInt(0xffffff);
	}
	
	/**
	 * Returns a random color from its own Random instance.
	 * @return a color int betwene 0 and 0xffffff
	 */
	public static int randColor() {
		return randColor(new Random());
	}
}
