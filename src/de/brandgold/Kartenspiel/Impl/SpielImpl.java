package de.brandgold.Kartenspiel.Impl;

import de.brandgold.Kartenspiel.Spiel;

public abstract class SpielImpl {	
	public static void setze(SpielImpl impl) { m_impl = impl; }
	public static SpielImpl gib() { return m_impl; }
		
	public abstract void ausfuehren(Spiel spiel);
	
	private static SpielImpl m_impl;

	public abstract Spiel gibSpiel();
}