package gamestuff;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeftListener implements KeyListener {
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(findValue(Game.leftKeyList, arg0.getKeyCode()) && !Game.started){ //Looks for an early start.
			Game.leftFalseStarted = true;
			Game.countdown.interrupt();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (findValue(Game.leftKeyList, arg0.getKeyCode()) && Game.started) { //When a WASD key is pressed.
			if (arg0.getKeyCode() == Game.leftKey) { //If the pressed key is correct.
				Game.n -= 5;
				int temp = Game.leftKey;
				while (temp == Game.leftKey) { //Picks a new key for pressing.
					int x = (int) (Math.random() * 4);
					if (x == 0) {
						temp = 65; // A
						Game.leftPrompt.setText("A");
					} else if (x == 1) {
						temp = 87; // W
						Game.leftPrompt.setText("W");
					} else if (x == 2) {
						temp = 68; // D
						Game.leftPrompt.setText("D");
					} else if (x == 3 || x == 4) {
						temp = 83; // S
						Game.leftPrompt.setText("S");
					}
				}
				Game.leftKey = temp; //New key set.
				Game.bar.setValue(Game.n); //Values adjusted.
				Game.checkWin(); //Checks for a win.
			} else {
				Game.n += 5;
				Game.bar.setValue(Game.n); //Bar goes in inverse direction.
				Game.checkWin(); //Tests for a win.
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static boolean findValue(int[] list, int value) { //Returns whether or not an integer component is part of a list. 
		for (int i = 0; i <= list.length - 1; i++) {
			if (list[i] == value) {
				return true;
			}
		}
		return false;
	}
}
