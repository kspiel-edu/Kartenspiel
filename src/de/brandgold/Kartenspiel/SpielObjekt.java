package de.brandgold.Kartenspiel;

import de.brandgold.Kartenspiel.Hilf.Farbe;
import de.brandgold.Kartenspiel.Hilf.Punkt;
import de.brandgold.Kartenspiel.Impl.SpielObjektImpl;

public abstract class SpielObjekt {
	public SpielObjekt() { m_impl = SpielObjektImpl.gib(); setzeSollGefuelltZeichnen(true); setzeZeichenFarbe(Farbe.WEISS); }
	
	protected void setzeZeichenFarbe(Farbe farbe) { m_farbe = farbe; }	
	protected void setzeSollGefuelltZeichnen(boolean gefuellt) { m_gefuellt = gefuellt; }

	protected void zeichneKreis(Punkt kreisMitte, int radius, Farbe farbe, boolean gefuellt) 
	{
		m_impl.zeichneKreis(kreisMitte, radius, farbe, gefuellt);
	}
	
	protected void zeichneKreis(Punkt kreisMitte, int radius, Farbe farbe) 
	{
		zeichneKreis(kreisMitte, radius, farbe, m_gefuellt);
	}
	
	protected void zeichneKreis(Punkt kreisMitte, int radius) 
	{
		zeichneKreis(kreisMitte, radius, m_farbe, m_gefuellt);
	}
	
	protected void zeichneRechteck(Punkt obenLinks, int breite, int hoehe, Farbe farbe, boolean gefuellt) 
	{
		m_impl.zeichneRechteck(obenLinks, breite, hoehe, farbe, gefuellt);
	}
	
	protected void zeichneRechteck(Punkt obenLinks, int breite, int hoehe, Farbe farbe) 
	{
		zeichneRechteck(obenLinks, breite, hoehe, farbe, m_gefuellt);
	}
	
	protected void zeichneRechteck(Punkt obenLinks, int breite, int hoehe) 
	{
		zeichneRechteck(obenLinks, breite, hoehe, m_farbe, m_gefuellt);
	}
	
	
	/**
	 * @brief Zeichnet dein Spielfenster.
	 * 
	 * Beachte das diese Methode mehrmals pro Sekunde aufgerufen wird.
	 */
	protected abstract void beiZeichnen();
	
	public void zeichne()
	{
		beiZeichnen();
	}
	
	public void logik()
	{
		beiLogik();
	}
		
	/**
	 * @brief Beinhaltet die Spiellogik.
	 * 
	 * Beachte das diese Methode mehrmals pro Sekunde aufgerufen wird.
	 */
	protected abstract void beiLogik();
	
	private SpielObjektImpl m_impl;
	private boolean m_gefuellt;
	private Farbe m_farbe;
}
