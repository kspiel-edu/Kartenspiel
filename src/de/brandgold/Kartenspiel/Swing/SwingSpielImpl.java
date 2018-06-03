package de.brandgold.Kartenspiel.Swing;

import javax.swing.SwingUtilities;

import de.brandgold.Kartenspiel.Spiel;
import de.brandgold.Kartenspiel.Impl.SpielImpl;

public class SwingSpielImpl extends SpielImpl {

	@Override
	public void ausfuehren(Spiel spiel) 
	{
		m_spiel = spiel;
		spiel.beginn();
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	    		new SwingFenster(spiel);      
	        }
	    });
	}
	
	public Spiel gibSpiel() { return m_spiel; }
	
	public Spiel m_spiel;
}
