package de.brandgold.Kartenspiel.Swing;

import javax.swing.JFrame;
import de.brandgold.Kartenspiel.Spiel;

public class SwingFenster extends JFrame {
	private static final long serialVersionUID = 1L;

	public SwingFenster(Spiel spiel)
	{
		setTitle("Kartenspiel");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		add(new SpielPanel(spiel));
	}
}
