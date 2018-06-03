package de.brandgold.Kartenspiel;

import java.util.ArrayList;

import de.brandgold.Kartenspiel.Hilf.Farbe;
import de.brandgold.Kartenspiel.Hilf.Punkt;
import de.brandgold.Kartenspiel.Impl.SpielObjektImpl;

public abstract class SpielObjekt {
	public SpielObjekt(Punkt koordinaten) { m_impl = SpielObjektImpl.gib(); setzeSollGefuelltZeichnen(true); setzeZeichenFarbe(Farbe.WEISS); m_koordinaten = koordinaten; }
	
	protected void setzeZeichenFarbe(Farbe farbe) { m_farbe = farbe; }	
	protected void setzeSollGefuelltZeichnen(boolean gefuellt) { m_gefuellt = gefuellt; }

	protected void zeichneKreis(Punkt kreisMitte, int radius, Farbe farbe, boolean gefuellt) 
	{
		m_impl.zeichneKreis(m_koordinaten.summe(kreisMitte), radius, farbe, gefuellt);
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
		m_impl.zeichneRechteck(m_koordinaten.summe(obenLinks), breite, hoehe, farbe, gefuellt);
	}
	
	protected void zeichneRechteck(Punkt obenLinks, int breite, int hoehe, Farbe farbe) 
	{
		zeichneRechteck(obenLinks, breite, hoehe, farbe, m_gefuellt);
	}
	
	protected void zeichneRechteck(Punkt obenLinks, int breite, int hoehe) 
	{
		zeichneRechteck(obenLinks, breite, hoehe, m_farbe, m_gefuellt);
	}
	
	protected void zeichneBild(Punkt obenLinks, int breite, int hoehe, String datei)
	{
		m_impl.zeichneBild(m_koordinaten.summe(obenLinks), breite, hoehe, datei);
	}
	
	
	protected void neuesKind(SpielObjekt kind)
	{
		m_kinder.add(kind);
	}
	
	protected void entferneKind(SpielObjekt kind)
	{
		m_kinder.remove(kind);
	}
	
	protected void entferneAlleKinder()
	{
		m_kinder.clear();
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
		
		for (SpielObjekt kind : m_kinder)
			kind.zeichne();
	}
	
	public void logik()
	{
		beiLogik();
		
		for (SpielObjekt kind : m_kinder)
			kind.logik();
	}
	
	public Punkt gibKoordinaten() { return m_koordinaten; }

	public int gibBreite() { return m_breite; }
	public void setzeBreite(int breite) { m_breite = breite; }
	public int gibHoehe() { return m_hoehe; }
	public void setzeHoehe(int hoehe) { m_hoehe = hoehe; }
	
	public boolean liegtPunktInObjekt(Punkt p)
	{
		return p.gibX() >= m_koordinaten.gibX() && p.gibY() >= m_koordinaten.gibY() && p.gibX() <= (m_koordinaten.gibX() + m_breite) && p.gibY() <= (m_koordinaten.gibY() + m_hoehe);
	}
	
	/**
	 * @brief Beinhaltet die Spiellogik.
	 * 
	 * Beachte das diese Methode mehrmals pro Sekunde aufgerufen wird.
	 */
	protected abstract void beiLogik();
	
	private SpielObjektImpl m_impl;
	private Punkt m_koordinaten;
	private int m_breite;
	private int m_hoehe;
	private boolean m_gefuellt;
	private Farbe m_farbe;
	private ArrayList<SpielObjekt> m_kinder = new ArrayList<>();
}
