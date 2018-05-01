package de.brandgold.Kartenspiel.Impl;

import de.brandgold.Kartenspiel.Hilf.Farbe;
import de.brandgold.Kartenspiel.Hilf.Punkt;

public abstract class SpielObjektImpl {	
	public static void setze(SpielObjektImpl impl) { s_impl = impl; }
	public static SpielObjektImpl gib() { return s_impl; }
	
	public abstract void zeichneKreis(Punkt kreisMitte, int radius, Farbe farbe, boolean gefuellt);
	public abstract void zeichneRechteck(Punkt obenLinks, int breite, int hoehe, Farbe farbe, boolean gefuellt);
	
	private static SpielObjektImpl s_impl;
}
