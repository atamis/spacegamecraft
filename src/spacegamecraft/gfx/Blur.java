package spacegamecraft.gfx;

/**
 * Applies a blur to a buffer.
 * @author atamiser
 *
 */
public class Blur {
	public static final int blur_radius = 1;
	
	/**
	 * Returns the average of the pixels surrounding the given pixel and the
	 * pixel itself from the buffer.
	 * @param buf, the buffer to get the pixel data from.
	 * @param bx, the x coordinate of the pixel we're blurring.
	 * @param by, the y coordinate of the pixel we're blurring.
	 * @return the average of the 4 pixels around and the 1 pixel indicated by 
	 * 			bx and by.
	 */
	public static int circularAverage(Buffer buf, int bx, int by) {
		double pixels = 0;
		double red = 0;
		double green = 0;
		double blue = 0;
		/*for(int x = 0; x < buf.pixels.length; x++) {
			for(int y = 0; y < buf.pixels[x].length; y++) {
				if(Math.sqrt(Math.pow(bx - x, 2) + Math.pow(by - y, 2)) < blur_radius) {
					pixels++;
					sum = sum + buf.pixels[x][y];
				}
			}
		}/**/
		pixels = 5.0f;
		int x;
		x = buf.safeGet(bx, by);
		red += Color.red(x);
		green += Color.green(x);
		blue += Color.blue(x);
		
		x = buf.safeGet(bx+1, by);
		red += Color.red(x);
		green += Color.green(x);
		blue += Color.blue(x);
		
		x = buf.safeGet(bx, by+1);
		red += Color.red(x);
		green += Color.green(x);
		blue += Color.blue(x);
		
		x = buf.safeGet(bx-1, by);
		red += Color.red(x);
		green += Color.green(x);
		blue += Color.blue(x);
		
		x = buf.safeGet(bx, by-1);
		red += Color.red(x);
		green += Color.green(x);
		blue += Color.blue(x);
		
		return Color.fromRGB((int) (red/pixels), (int) (green/pixels), (int) (blue/pixels));
	}
	
	/**
	 * Applies a single blur effect using circularAverage to the given buffer
	 * @param buf, the buffer to blur.
	 * @return the buffer, blurred.
	 */
	public static Buffer blur(Buffer buf) {
		Buffer result = new Buffer(buf.pixels.length, buf.pixels[0].length);
		for(int x = 0; x < buf.pixels.length; x++) {
			for(int y = 0; y < buf.pixels[x].length; y++) {
				//result.pixels[x][y] = (int) (buf.pixels[lx][ly]*0.5 + result.pixels[x][y])/2;
				//result.pixels[x][y] = buf.pixels[lx][ly];
				result.pixels[x][y] = circularAverage(buf, x, y);
			}
		}
		return result;
	}
	
	/**
	 * Applies a blur multiple times.
	 * @param buf, the buffer to blur
	 * @param i, the number of times to blur.
	 * @return the blurred buffer.
	 */
	public static Buffer multiblur(Buffer buf, int i) {
		Buffer result = new Buffer(buf.pixels);
		while(i > 0) {
			result = blur(result);
			i--;
		}
		
		return result;
	}
}
