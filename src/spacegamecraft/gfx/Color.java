package spacegamecraft.gfx;

import java.util.Random;

public class Color {
	public static final int INVISIBLE = 0xabcde;
	public static final int GREEN = Color.fromRGB(0, 0xff, 0);
	public static int fromRGB(int r, int g, int b) {
		int x = 0;
		x = x + b;
		x = x + g*0x100;
		x = x + r*0x010000;
		return x;
	}
	
	public static int red(int x) {
		return (int) (x/0x010000);
	}
	
	public static int green(int x) {
		return (int) ((x-red(x)*0x010000)/0x100);
	}
	
	public static int blue(int x) {
		return (int) ((x-red(x)*0x010000-green(x)*0x100));
	}

	public static int randColor(Random rand) {
		return rand.nextInt(0xffffff);
	}
	
	public static int randColor() {
		return randColor(new Random());
	}
}
