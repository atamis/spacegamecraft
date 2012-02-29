package spacegamecraft.gfx;

public class Blur {
	public static final int blur_radius = 1;
	
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
	
	public static Buffer multiblur(Buffer buf, int i) {
		Buffer result = new Buffer(buf.pixels);
		while(i > 0) {
			result = blur(result);
			i--;
		}
		
		return result;
	}
}
