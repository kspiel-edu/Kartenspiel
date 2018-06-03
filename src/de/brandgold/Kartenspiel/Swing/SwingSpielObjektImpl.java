package de.brandgold.Kartenspiel.Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.brandgold.Kartenspiel.Hilf.Farbe;
import de.brandgold.Kartenspiel.Hilf.Punkt;
import de.brandgold.Kartenspiel.Impl.SpielObjektImpl;

public class SwingSpielObjektImpl extends SpielObjektImpl {

	private void setzeFarbe(Farbe farbe) 
	{
		gibGraphics().setColor(new Color((int)(farbe.gibRot() * 255), (int)(farbe.gibGruen() * 255), (int)(farbe.gibBlau() * 255)));
	}
	
	@Override
	public void zeichneKreis(Punkt kreisMitte, int radius, Farbe farbe, boolean gefuellt) {
		setzeFarbe(farbe);
		
		if (gefuellt)
			gibGraphics().fillOval(kreisMitte.gibX() + radius / 2, kreisMitte.gibY() + radius / 2, radius, radius);
		else
			gibGraphics().drawOval(kreisMitte.gibX() + radius / 2, kreisMitte.gibY() + radius / 2, radius, radius);
	}

	@Override
	public void zeichneRechteck(Punkt obenLinks, int breite, int hoehe, Farbe farbe, boolean gefuellt) {
		setzeFarbe(farbe);
		
		if (gefuellt)
			gibGraphics().fillRect(obenLinks.gibX(), obenLinks.gibY(), breite, hoehe);
		else
			gibGraphics().drawRect(obenLinks.gibX(), obenLinks.gibY(), breite, hoehe);
	}
	

	private static Graphics gibGraphics()
	{
		return s_graphics; 
	}
	public static void setzeGraphics(Graphics graphics) { s_graphics = graphics; }
	
	private static Graphics s_graphics;

	@Override
	public void zeichneBild(Punkt obenLinks, int breite, int hoehe, String bild) {
		try {
			gibGraphics().drawImage(ImageIO.read(new File(bild)), obenLinks.gibX(), obenLinks.gibY(), breite, hoehe, null, null);
		} catch (IOException e) {
		}
	}
}
