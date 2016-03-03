package gamestuff;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Game {
	static Countdown countdown = new Countdown();
	static JFrame frame = new JFrame("2 Player Game");
	static JPanel panel = new JPanel(new GridBagLayout());
	static GridBagConstraints c = new GridBagConstraints();
	static JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	static JLabel leftPrompt = new JLabel(" W");
	static JLabel rightPrompt = new JLabel("UP");
	static JLabel label = new JLabel("<--------------------3-------------------->");
	static Font font = new Font("Playbill", Font.ITALIC, 60);
	static int n = 50;
	static int[] leftKeyList = { 65, 87, 68, 83 };
	static int[] rightKeyList = { 37, 38, 39, 40 };
	static int leftKey = 87;
	static int rightKey = 38;
	static boolean started = false;
	static boolean leftFalseStarted;

	public static void main(String[] args){
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 25;
		leftPrompt.setFont(font);
		panel.add(leftPrompt, c);
		c.gridx = 2;
		rightPrompt.setFont(font);
		panel.add(rightPrompt, c);
		c.gridx = 1;
		c.gridy = 0;
		label.setFont(font);
		panel.add(label, c);
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 300;
		c.ipady = 25;
		c.gridwidth = 3;
		panel.add(bar, c);
		bar.setValue(50);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(750, 500);
		panel.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		countdown.start();
		//Game.addListener();
	}

	public static void addListener() {
		panel.addKeyListener(new LeftListener());
		panel.addKeyListener(new RightListener());
	}

	public static void checkWin() {
		if (n >= 100) {
			leftPrompt.setText(" LOSE");
			rightPrompt.setText("WIN");
			n += 200;
		} else if (n <= 0) {
			rightPrompt.setText("LOSE");
			leftPrompt.setText(" WIN");
			n = -100;
		}
	}

}
