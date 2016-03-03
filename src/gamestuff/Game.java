package gamestuff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Game {
	static Countdown countdown = new Countdown();
	static JFrame frame = new JFrame("2 Player Game");
	static JPanel panel = new JPanel(new GridBagLayout());
	static GridBagConstraints c = new GridBagConstraints();
	static JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	static JLabel leftPrompt = new JLabel("W");
	static JLabel rightPrompt = new JLabel("UP");
	static JLabel label = new JLabel("<- - - - - -3- - - - - ->");
	static Font font = new Font("Playbill", Font.ITALIC, 60);
	static int n = 50;
	static int[] leftKeyList = { 65, 87, 68, 83 };
	static int[] rightKeyList = { 37, 38, 39, 40 };
	static int leftKey = 87;
	static int rightKey = 38;
	static boolean started = false;
	static boolean leftFalseStarted;

	public static void main(String[] args) {
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
		c.ipadx = 400;
		c.ipady = 25;
		c.gridwidth = 3;
		panel.add(bar, c);
		bar.setValue(50);
		bar.setForeground(Color.BLUE);
		bar.setBackground(Color.RED);
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(750, 300);
		panel.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		leftPrompt.setPreferredSize(new Dimension(100,100));
		rightPrompt.setPreferredSize(new Dimension(100,100));
		label.setPreferredSize(new Dimension(450,100));
		leftPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		rightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		countdown.start();
	}

	public static void addListener() {
		panel.addKeyListener(new LeftListener());
		panel.addKeyListener(new RightListener());
	}

	public static void checkWin() {
		if (n >= 100) {
			leftPrompt.setText("LOSE");
			rightPrompt.setText("WIN" );
			label.setText("<- - - - - -OVER- - - - - ->");
			n += 200;
		} else if (n <= 0) {
			rightPrompt.setText("LOSE");
			leftPrompt.setText("WIN");
			label.setText("<- - - - - -OVER- - - - - ->");
			n = -100;
		}
	}

}
