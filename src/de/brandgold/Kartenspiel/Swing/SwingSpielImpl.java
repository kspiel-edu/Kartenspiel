package de.brandgold.Kartenspiel.Swing;

import de.brandgold.Kartenspiel.Spiel;
import de.brandgold.Kartenspiel.Impl.SpielImpl;

public class SwingSpielImpl extends SpielImpl {

	@Override
	public void ausfuehren(Spiel spiel) 
	{
		spiel.beginn();
		new SwingFenster(spiel);
	}
}
