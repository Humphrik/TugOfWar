package gamestuff;

public class AI extends Thread {
	public void run() {
		while (Game.n > 0 && Game.n < 100) {
			int i = (int) (Math.random() * 500) + 500;
			try {
				Thread.sleep(i);
				RightListener.testKey(Game.rightKey);
			} catch (InterruptedException e) {

			}
		}

	}
}
