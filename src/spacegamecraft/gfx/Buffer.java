package spacegamecraft.gfx;

import java.awt.image.BufferedImage;

public class Buffer {
	public int[][] pixels;
	
	public Buffer(int height, int width) {
		pixels = new int[height][width];
	}
	
	public Buffer(int[][] pixels) {
		this.pixels = pixels;
	}
	
	public void clear(int color) {
		// Sets the entire pixel buffer to black.
		for(int x=0; x < pixels.length; x++){
			for(int y=0; y < pixels[x].length; y++) {
				pixels[x][y] = color;
			}
		}
	}
	
	public void replaceBuffer(Buffer buf1) {
		for(int x=0; x<pixels.length; x++){
			for(int y=0; y<pixels[x].length; y++) {
				if(buf1.pixels[x][y] != Color.INVISIBLE) {
					pixels[x][y] = buf1.pixels[x][y];
				}
			}
		}
	}
	
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
	
	public int safeGet(int x, int y) {
		try {
			return pixels[x][y];
		} catch(ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	public void clear() {
		clear(0x000000);
	}

	public void drawOnImage(BufferedImage img) {
		for(int x=0; x<pixels.length; x++){
			for(int y=0; y<pixels[x].length; y++) {
				img.setRGB(x, y, pixels[x][y]);
			}
		}
	}
}
