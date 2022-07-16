package frames;

import behavior.AsyncTask;
import main2.Game;
import utils.Highscore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

public class MenuFrame {

	private static final JFrame menuFrame = new JFrame();
	JPanel panel = new JPanel();
	static JButton button1 = new JButton("Play");
	static JButton button2 = new JButton("Highscores");
	static JButton button3 = new JButton("Options");
	static JButton button4 = new JButton("Exit");
	private final Component verticalStrut = Box.createVerticalStrut(40);
	private final Component verticalStrut_1 = Box.createVerticalStrut(40);
	private final Component verticalStrut_2 = Box.createVerticalStrut(40);
	private final Component verticalStrut_3 = Box.createVerticalStrut(40);

	public MenuFrame() {
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setBounds(100, 50, 100, 30);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); // Vertikal ausgelegt
		
		panel.add(verticalStrut);

		panel.add(button1);
		
		panel.add(verticalStrut_1);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(button2);
		
		panel.add(verticalStrut_2);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(button3);
		
		panel.add(verticalStrut_3);
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(button4);

		button1.setPreferredSize(new Dimension(300, 120));

		button1.setFont(new Font("Cooper Black", Font.BOLD, 50)); // Schriftart, Fettgedruckt und Größe
		button1.setForeground(Color.LIGHT_GRAY); // Schrift Farbe vom Button
		button1.setBackground(Color.DARK_GRAY); // Hintegrundfarbe vom Button
		button1.setFocusable(false); // keine Border mehr um die Schrift

		button2.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		button2.setForeground(Color.GRAY);
		button2.setBackground(Color.DARK_GRAY);
		button2.setFocusable(false);

		button3.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		button3.setForeground(Color.GRAY);
		button3.setBackground(Color.DARK_GRAY);
		button3.setFocusable(false);

		button4.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		button4.setForeground(Color.GRAY);
		button4.setBackground(Color.DARK_GRAY);
		button4.setFocusable(false);

		menuFrame.getContentPane().add(panel);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setLocation(800, 250);
		menuFrame.setTitle("Minigame");
		menuFrame.pack();
		menuFrame.setVisible(true);

		ButtonAction bAction = new ButtonAction();

		button1.addActionListener(bAction);
		button2.addActionListener(bAction);
		button3.addActionListener(bAction);
		button4.addActionListener(bAction);
	}

	public static class ButtonAction implements ActionListener {

		final static Game game = new Game();
		final static JFrame gFrame = new JFrame(Game.title);

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button1) {

				MenuFrame.menuFrame.dispose();

				gFrame.getContentPane().add(game);
				gFrame.pack();
				gFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
				gFrame.requestFocus(); // key input are recognised by the frame without clicking once on it
				gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gFrame.setLocationRelativeTo(null); // centers window on screen
				gFrame.setVisible(true); // shows the frame

				new AsyncTask(game); // starts game loop in new thread
			}

			if (e.getSource() == button2) {
				JPanel panel = new JPanel();
				MenuFrame.menuFrame.dispose();
				//	final Highscore highScore = new Highscore(0, 0);
			//		panel.setLayout(new GridLayout(panel, BoxLayout.PAGE_AXIS));
					
					
					final JFrame hFrame = new JFrame();
				//	hFrame.add(game);
					hFrame.pack();
					hFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
					hFrame.requestFocus(); // key input are recognised by the frame without clicking once on it
					hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					hFrame.setLocationRelativeTo(null); // centers window on screen
					hFrame.setVisible(true); // shows the frame
		

				// open Highscore
			}

			if (e.getSource() == button3) {
				MenuFrame.menuFrame.dispose();

				// options
			}

			if (e.getSource() == button4) {
				MenuFrame.menuFrame.dispose();

			}
		}

		public static void restart() {
			gFrame.dispose();
			new MenuFrame();
		}
	}
}
