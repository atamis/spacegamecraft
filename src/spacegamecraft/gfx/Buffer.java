package spacegamecraft.gfx;

import java.awt.image.BufferedImage;

public class Buffer {
	public int[][] pixels;
	
	/**
	 * Make a new buffer of the given height and width.
	 * @param height, the height of the buffer.
	 * @param width, the width of the buffer.
	 */
	public Buffer(int height, int width) {
		pixels = new int[height][width];
	}
	
	/**
	 * Just make a buffer from the given pixel buffer.
	 * @param pixels, array of array of integers.
	 */
	public Buffer(int[][] pixels) {
		this.pixels = pixels;
	}
	
	/**
	 * Sets the entire buffer to the given color.
	 * @param color, the color to set the buffer to.
	 */
	public void clear(int color) {
		// Sets the entire pixel buffer to the given color.
		for(int x=0; x < pixels.length; x++){
			for(int y=0; y < pixels[x].length; y++) {
				pixels[x][y] = color;
			}
		}
	}
	
	/**
	 * Replace this buffer with the other buffer, but only if the other buffers
	 * color isn't the special invisible color.
	 * @param buf1, the buffer we're replacing this buffer with.
	 */
	public void replaceBuffer(Buffer buf1) {
		for(int x=0; x<pixels.length; x++){
			for(int y=0; y<pixels[x].length; y++) {
				if(buf1.pixels[x][y] != Color.INVISIBLE) {
					pixels[x][y] = buf1.pixels[x][y];
				}
			}
		}
	}
	
	/**
	 * Add 2 buffers together, unless the color is invisible, in which case
	 * nothing happens, or if its white, in which case it remains white. We
	 * don't want to exceed 0xffffff, or weird shit happens.
	 * @param buf1
	 */
	public void addBuffer(Buffer buf1) {
		for(int x=0; x<pixels.length; x++){
			for(int y=0; y<pixels[x].length; y++) {
				if(buf1.pixels[x][y] != Color.INVISIBLE) {
					if(pixels[x][y] != 0xffffff) {
						pixels[x][y] = pixels[x][y] + buf1.pixels[x][y];
					} else {
						pixels[x][y] = 0xffffff;
					}
				}
			}
		}
	}
	
	/**
	 * Try to get a color at the given x and y, but return 0 if its out of 
	 * bounds
	 * @param x
	 * @param y
	 * @return
	 */
	public int safeGet(int x, int y) {
		try {
			return pixels[x][y];
		} catch(ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	/**
	 * Clear the buffer to black.
	 */
	public void clear() {
		clear(0x000000);
	}

	/**
	 * Draws itself onto an image with setRGB.
	 * @param img, the image to draw onto.
	 */
	public void drawOnImage(BufferedImage img) {
		for(int x=0; x<pixels.length; x++){
			for(int y=0; y<pixels[x].length; y++) {
				img.setRGB(x, y, pixels[x][y]);
			}
		}
	}

	/**
	 * Tries to set the x, y coordinate to the color. Returns true at success,
	 * false at failure.
	 * @param x, x coordinate
	 * @param y, y coordinate
	 * @param color, the color
	 * @return boolean, true if successful, false if otherwise.
	 */
	public boolean set(int x, int y, int color) {
		try {
			pixels[x][y] = color;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
