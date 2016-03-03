package gamestuff;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeftListener implements KeyListener {
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(!Game.started){
			Game.leftFalseStarted = true;
			Game.countdown.interrupt();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// System.out.println("Key Released.");
		if (findValue(Game.leftKeyList, arg0.getKeyCode()) && Game.started) {
			// System.out.println("Is argument correct?");
			if (arg0.getKeyCode() == Game.leftKey) {
				// System.out.println("Yes.");
				Game.n -= 5;
				int temp = Game.leftKey;
				while (temp == Game.leftKey) {
					int x = (int) (Math.random() * 4);
					// System.out.println("x = " + x);
					// System.out.println("leftKey = " + Game.leftKey);
					// System.out.println("temp = " + temp);
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
				Game.leftKey = temp;
				Game.bar.setValue(Game.n);
				Game.checkWin();
			} else {
				// System.out.println("No");
				Game.n += 5;
				Game.bar.setValue(Game.n);
				Game.checkWin();
			}
		}
		// System.out.println("Finished");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static boolean findValue(int[] list, int value) {
		// System.out.println("Finding values");
		for (int i = 0; i <= list.length - 1; i++) {
			if (list[i] == value) {
				// System.out.println("Value found");
				return true;
			}
			// System.out.println("Value NOT found");
		}
		return false;
	}
}
