package spacegamecraft.gfx;

/**
 * Quickly generates a sort of cool looking wavvy background.
 * @author atamiser
 *
 */
public class Background {
	
	/**
	 * Generates a background with sin waves
	 * @param height, height of the buffer.
	 * @param width, width of the buffer.
	 * @return a buffer with the background.
	 */
	public static Buffer generateBackground(int height, int width) {
		Buffer b = new Buffer(height, width);
		
		for(int x=0; x < b.pixels.length; x++) {
			for(int y=0; y < b.pixels[x].length; y++) {
				int c = (int) (100+100*(Math.sin(x/5) * Math.sin(y/5)) + 0x000000);
				b.pixels[x][y] = Color.fromRGB(c, c, c);
			}
		}
		
		return b;
	}
}
