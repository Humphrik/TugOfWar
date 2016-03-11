package gamestuff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Game {
	static Countdown countdown = new Countdown();
	static JFrame frame = new JFrame("Tug of War");
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
	static boolean gameOver = false;
	static boolean AIEnabled = false;

	static JFrame startFrame = new JFrame("Tug of War");
	static JPanel startPanel = new JPanel(new GridBagLayout());
	static GridBagConstraints d = new GridBagConstraints();
	static JButton onePlayer, twoPlayer;
	static JLabel startLabel = new JLabel("Select number of players");

	public static void main(String[] args) {
		createStartDisplay();
	}

	public static void addListener() { // Adds key inputs to the panel.
		panel.addKeyListener(new LeftListener());
		if (!AIEnabled) {
			panel.addKeyListener(new RightListener());
		}
	}

	public static void checkWin() { // Tests for a winning player.
		if (n <= 0) { // The right player wins.
			leftPrompt.setText("LOSE");
			rightPrompt.setText("WIN");
			label.setText("<- - - - - -OVER- - - - - ->");
			gameOver = true;
			n = -100;
		} else if (n >= 100) { // The left player wins.
			rightPrompt.setText("LOSE");
			leftPrompt.setText("WIN");
			label.setText("<- - - - - -OVER- - - - - ->");
			gameOver = true;
			n = 200;
		}
	}

	public static void createDisplay() {
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 25;
		leftPrompt.setFont(font);
		panel.add(leftPrompt, c); // Adds display for WASD player.

		c.gridx = 2;
		rightPrompt.setFont(font);
		panel.add(rightPrompt, c); // Adds display for arrow key player.

		c.gridx = 1;
		c.gridy = 0;
		label.setFont(font);
		panel.add(label, c); // Adds the countdown.

		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 400;
		c.ipady = 25;
		c.gridwidth = 3;
		panel.add(bar, c);
		bar.setValue(50);
		bar.setForeground(Color.BLUE);
		bar.setBackground(Color.RED); // Creates the tug-bar.

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(750, 300);
		panel.setFocusable(true);
		panel.requestFocus();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Sets conditions of the panel and
											// frame.

		leftPrompt.setPreferredSize(new Dimension(100, 100));
		rightPrompt.setPreferredSize(new Dimension(100, 100));
		label.setPreferredSize(new Dimension(450, 100));
		leftPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		rightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER); // Makes sure
																// everything is
																// properly
																// sized and
																// aligned.

		countdown.start(); // Begins the game.
	}

	public static void createStartDisplay() {
		d.gridx = 0;
		d.gridy = 0;
		d.ipadx = 250;
		d.ipady = 50;
		d.gridwidth = 2;
		startLabel.setPreferredSize(new Dimension(250, 50));
		startLabel.setFont(font);
		startPanel.add(startLabel, d);

		d.ipadx = 50;
		d.ipady = 50;
		d.insets = new Insets(10, 10, 10, 10);
		d.gridwidth = 1;
		createButton(onePlayer, 0, 1, "One Player");
		createButton(twoPlayer, 1, 1, "Two Players");
		startFrame.add(startPanel);
		startFrame.setSize(750, 500);
		startFrame.setVisible(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void createButton(JButton button, int gridX, int gridY, String text) {
		button = new JButton(text);
		d.gridx = gridX;
		d.gridy = gridY;
		startPanel.add(button, d);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text.equals("One Player")) {
					AIEnabled = true;
				} else {
					AIEnabled = false;
				}
				createDisplay();
				startFrame.dispose();
			}
		});

	}
}
