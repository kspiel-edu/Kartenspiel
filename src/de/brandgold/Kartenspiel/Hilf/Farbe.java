package de.brandgold.Kartenspiel.Hilf;

/**
 * Repräsentation einer Farbe.
 */
public class Farbe {
	public static final Farbe ROT = new Farbe(1, 0, 0);
	public static final Farbe GRUEN = new Farbe(0, 1, 0);
	public static final Farbe BLAU = new Farbe(0, 0, 1);
	public static final Farbe GELB = new Farbe(1, 1, 0);
	public static final Farbe CYAN = new Farbe(0, 1, 1);
	public static final Farbe MAGENTA = new Farbe(1, 0, 1);
	public static final Farbe ORANGE = new Farbe(1, 0.66, 0);
	public static final Farbe SCHWARZ = new Farbe(0, 0, 0);
	public static final Farbe GRAU = new Farbe(.5, .5, .5);
	public static final Farbe WEISS = new Farbe(1, 1, 1);

	
	/**
	 * Erzeugt eine neue Farbe
	 * @param rot roter Anteil der Farbe (0 - 1)
	 * @param gruen gr�ner Anteil der Farbe (0 - 1)
	 * @param blau blauer Anteil der Farbe (0 - 1)
	 */
	Farbe(double rot, double gruen, double blau)
	{
		m_rot = Math.min(Math.max(rot, 0), 1);
		m_gruen = Math.min(Math.max(gruen, 0), 1);
		m_blau = Math.min(Math.max(blau, 0), 1);
	}
	
	/**
	 * @return roter Anteil der Farbe
	 */
	public double gibRot() { return m_rot; }
	/**
	 * @return grüner Anteil der Farbe
	 */
	public double gibGruen() { return m_gruen; }
	/**
	 * @return blauer Anteil der Farbe
	 */
	public double gibBlau() { return m_blau; }
	
	/**
	 * Vergleicht diese Farbe mit einer anderen
	 * @param andereFarbe die andere Farbe
	 * @return ob die Farben gleich sind
	 */
	public boolean gleich(Farbe andereFarbe) { return gibRot() == andereFarbe.gibRot() && gibGruen() == andereFarbe.gibGruen() && gibBlau() == andereFarbe.gibBlau(); }
	
	/**
	 * Farbe erhellen
	 * @param faktor Faktor um den die Farbe erhellt werden soll (0 - 1)
	 * @return Aufgehellte Farbe
	 */
	public Farbe heller(double faktor) { return new Farbe(gibRot() + faktor, gibGruen() + faktor, gibBlau() + faktor); }
	
	/**
	 * Farbe verdunkeln
	 * @param faktor Faktor um den die Farbe verdunkelt werden soll (0 - 1)
	 * @return Verdunkelte Farbe
	 */
	public Farbe dunkler(double faktor) { return heller(-faktor); }
	
	private double m_rot, m_gruen, m_blau;
}
