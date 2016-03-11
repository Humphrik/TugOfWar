package gamestuff;

public class AI extends Thread {
	public void run() {
		int speed;
		int errorChance;
		if (Game.difficulty.getSelectedIndex() == 1) {
			speed = 600;
			errorChance = 10;
		} else if (Game.difficulty.getSelectedIndex() == 2) {
			speed = 500;
			errorChance = 5;
		} else {
			speed = 400;
			errorChance = 1;
		}
		while (Game.n > 0 && Game.n < 100) {
			int i = (int) (Math.random() * speed) + speed;
			int j = (int) (Math.random() * 101);
			try {
				Thread.sleep(i);
				if (j > errorChance) {
					RightListener.testKey(Game.rightKey);
				} else {
					Game.n += 5;
					Game.bar.setValue(Game.n);
					Game.checkWin();
				}
			} catch (InterruptedException e) {

			}
		}

	}
}
