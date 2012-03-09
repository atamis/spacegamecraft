package spacegamecraft.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import spacegamecraft.geo.Point;


public class Font {
	public static final int character_width = 5; // Default: 5
	public static final int character_height = 5; // Default: 5
	public final static String chars = "abcdefghijklmnopqrstuvwxyz1234567890.,!'[]";
	private static Font instance = null;
	public BufferedImage fontImage;
	
	/**
	 * This is necessary because Java doesn't let exception producing code
	 * a function or constructor such as this one.
	 */
	private Font(){
		try {
			fontImage = ImageIO.read(Font.class.getResourceAsStream("/font.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Draws the string in the given color at the given point on the given
	 * buffer. Will obey newlines and move the "cursor" down. Please see
	 * Font.chars for a complete alphabet of possible characters. To add
	 * another character to the font, first draw the character at the end of
	 * the font image, then add the character to the end of the font string.
	 * Unrecognized characters will default to empty.
	 * @param text, the String to draw
	 * @param p, where you want the upper left hand corner of the message
	 * 			(probably)
	 * @param color, the color to draw the message in
	 * @param pixels, the buffer to draw onto
	 * @return the completed buffer
	 */
	public static Buffer drawMessage(String text, Point p, int color, Buffer pixels) {
		String[] messages = text.split("\n");
		for(int d = 0; d < messages.length; d++) {
			BufferedImage fontImage = Font.instance().fontImage;
			String message = messages[d].toLowerCase();
			for(int i = 0; i < message.length(); i++) {
				char character = message.charAt(i);
				int char_loc = chars.indexOf(character);
				int[][] character_pixels = new int[character_width][character_height];
				
				
				if(character != ' ') {
					if(char_loc >= 0) {
						// Copy the pixels from the font image to the character buffer.
						for(int x = 0; x < character_pixels.length; x++) {
							for(int y = 0; y < character_pixels[x].length; y++) {
								int font_pixel_color;
								// This is to protect against requested character going beyond the range of the the font image.
								try {
									font_pixel_color = fontImage.getRGB(character_width*char_loc + x, y);
								} catch (Exception e) {
									font_pixel_color = 0;
								}

								// White is black, and everything else is white. Simple really.
								if(font_pixel_color == 0xffffff) {
									character_pixels[x][y] = Color.INVISIBLE;
								} else {
									character_pixels[x][y] = color;
								}
							}
						}
					}
				} else {
					for(int x = 0; x < character_pixels.length; x++) {
						for(int y = 0; y < character_pixels[x].length; y++) {
							character_pixels[x][y] = Color.INVISIBLE;
						}
					}
				}
				
				// Copy the character pixel buffer into the primary pixel buffer.
				for(int x = 0; x < character_pixels.length; x++) {
					for(int y = 0; y < character_pixels[x].length; y++) {
						Point pp = p.add(x, y);
						// We have to catch this exception because the text might extend beyond the available buffer
						// space. In this instance, we just ignore that fact and continue.
						try {
							// We add 1 to character_width to give a small 1 pixel space between this character and the next.
							if(character_pixels[x][y] != Color.INVISIBLE) {
								pixels.pixels[pp.x+(character_width+1)*i][pp.y] = character_pixels[x][y];
							}
						} catch(ArrayIndexOutOfBoundsException e) {
							
						}
					}
				}
			}
			// We're dealing with multiple lines, so we move the cursor down by the height of the chracter
			// plus 1, because we want this to look nice.
			p = p.add(0, character_height+1);
		}
		return pixels;
	}
	
	/**
	 * Gets the one instance of this class.
	 * @return an instance of Font.
	 */
	public static Font instance() {
		// We have to do this weird singleton pattern thing because the font image buffer throws IO errors,
		// and you can't catch those when assigning the image to a static field in the top level of the
		// class. So. We have to catch those in the constructor.
		if(instance == null){
			instance = new Font();
		}
		return instance;
	}
}
