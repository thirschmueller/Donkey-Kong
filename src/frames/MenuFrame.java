package frames;

import javax.swing.*;
import javax.swing.text.Position;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame implements ActionListener, Frame {

	private static final JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Play");
	JButton button2 = new JButton("Highscores");
	JButton button3 = new JButton("Options");
	JButton button4 = new JButton("Exit");
	Position pos;

	public MenuFrame() {
		final JButton button = new JButton("Start Game");
		button.addActionListener(this); // this wegen in dieser Klasse
		button1.setBounds(100, 50, 100, 30);

		final JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); // Vertikal ausgelegt

		panel.add(button1);
		panel.add(Box.createRigidArea(new Dimension(100, 20))); // erstellt abstand (Horizontal, Vertikal)

		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		panel.add(button3);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));

		panel.add(button4);

		button1.setFont(new Font("Cooper Black", Font.BOLD, 50));	//Schriftart, Fettgedruckt und Größe
		button1.setForeground(Color.LIGHT_GRAY);	//Schrift Farbe vom Button
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

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 400);
		frame.setTitle("Minigame");
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		new GameFrame().draw();
	}

	public void draw() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 400);
		frame.setTitle("Minigame");
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MenuFrame();
			}

		});

	}
}
