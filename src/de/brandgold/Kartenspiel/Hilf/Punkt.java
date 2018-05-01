package de.brandgold.Kartenspiel.Hilf;

/**
 * @brief Punkt im zweidimensionalen Raum
 *
 */
public class Punkt {
	public Punkt(int x, int y) { m_x = x; m_y = y; }
	
	public int gibX() { return m_x; }
	public int gibY() { return m_y; }
	public void setzeY(int y) { m_y = y; }
	public void setzeX(int x) { m_x = x; }
	
	/**
	 * Berechnet den Abstand zwischen diesem und einem anderen Punkt
	 * 
	 * @param p2 Anderer Punkt
	 * @return Der Abstand der beiden Punkte
	 */
	public long abstand(Punkt p2)
	{
		return Math.round(Math.sqrt(Math.pow(gibX() - p2.gibX(), 2) + Math.pow(gibY() - p2.gibY(), 2)));
	}
	
	private int m_x, m_y;
}
