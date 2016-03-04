package gamestuff;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RightListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(findValue(Game.rightKeyList, arg0.getKeyCode()) &&  !Game.started){
			Game.leftFalseStarted = false;
			Game.countdown.interrupt();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// System.out.println("Key Released.");
		if (findValue(Game.rightKeyList, arg0.getKeyCode()) && Game.started) {
			// System.out.println("Is argument correct?");
			if (arg0.getKeyCode() == Game.rightKey) {
				Game.n += 5;
				int temp = Game.rightKey;
				while (temp == Game.rightKey) {
					int x = (int) (Math.random() * 4);
					if (x == 0) {
						temp = 37; // LEFT
						Game.rightPrompt.setText("LEFT");
					} else if (x == 1) {
						temp = 38; // UP
						Game.rightPrompt.setText("UP");
					} else if (x == 2) {
						temp = 39; // RIGHT
						Game.rightPrompt.setText("RIGHT");
					} else if (x == 3 || x == 4) {
						temp = 40; // DOWN
						Game.rightPrompt.setText("DOWN");
					}
				}
				Game.rightKey = temp;
				Game.bar.setValue(Game.n);
				Game.checkWin();
			} else {
				// System.out.println("No");
				Game.n -= 5;
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
