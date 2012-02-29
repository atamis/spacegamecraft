package spacegamecraft.gfx;

public class Background {
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
