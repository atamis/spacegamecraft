package spacegamecraft;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	public Game game;
	public boolean[] keys = new boolean[256];

	public InputHandler(Game game) {
		this.game = game;
		game.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		keys[ke.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		keys[ke.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

}
