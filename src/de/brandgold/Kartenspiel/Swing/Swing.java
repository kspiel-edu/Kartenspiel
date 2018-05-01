package de.brandgold.Kartenspiel.Swing;

import de.brandgold.Kartenspiel.Impl.SpielImpl;
import de.brandgold.Kartenspiel.Impl.SpielObjektImpl;

public class Swing {
	/**
	 * Verwende Swing für die Darstellung des Spiels
	 */
	public static void verwenden()
	{
		SpielImpl.setze(new SwingSpielImpl());
		SpielObjektImpl.setze(new SwingSpielObjektImpl());
	}
	
	private Swing() {}
}
