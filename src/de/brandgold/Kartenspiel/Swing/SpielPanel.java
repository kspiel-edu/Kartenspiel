package de.brandgold.Kartenspiel.Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import de.brandgold.Kartenspiel.Spiel;

public class SpielPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	SpielPanel(Spiel spiel)
	{
		m_spiel = spiel;
		
		Timer timer = new Timer(1000 / 30, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.white);
		// zeichne*() Funktionen können nur in diesem Zeitraum verwendet werden.
		SwingSpielObjektImpl.setzeGraphics(g);
		m_spiel.zeichne();
		SwingSpielObjektImpl.setzeGraphics(null);
	}
	
	private Spiel m_spiel;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		m_spiel.logik();
		repaint();
	}
}
