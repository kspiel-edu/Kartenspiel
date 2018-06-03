package de.brandgold.Kartenspiel.Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.brandgold.Kartenspiel.Spiel;
import de.brandgold.Kartenspiel.Impl.SpielImpl;

public class SwingFenster extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public SwingFenster(Spiel spiel)
	{
		setTitle("Kartenspiel");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		JMenuBar menu = new JMenuBar();
		JMenu menu_spiel = new JMenu("Spiel");
		JMenuItem neue_runde = new JMenuItem("Neue Runde");
		JMenuItem beenden = new JMenuItem("Beenden");
		
		neue_runde.addActionListener(this);
		neue_runde.setActionCommand("spiel_neu");
		
		menu_spiel.add(neue_runde);
		
		beenden.addActionListener(this);
		beenden.setActionCommand("beenden");
		
		menu_spiel.add(beenden);
		
		menu.add(menu_spiel);
		
		setJMenuBar(menu);
		
		add(new SpielPanel(spiel));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "spiel_neu":
			SpielImpl.gib().gibSpiel().neustart();
			break;
		case "beenden":
			System.exit(0);
			break;
		}
	}
}
