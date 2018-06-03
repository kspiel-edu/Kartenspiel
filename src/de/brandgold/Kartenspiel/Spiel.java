package de.brandgold.Kartenspiel;

import de.brandgold.Kartenspiel.Hilf.Punkt;
import de.brandgold.Kartenspiel.Impl.SpielImpl;

public abstract class Spiel extends SpielObjekt {
	public Spiel() {
		super(new Punkt(0,0));
		// TODO Auto-generated constructor stub
	}

	public void ausfuehren()
	{
		SpielImpl.gib().ausfuehren(this);
	}
	
	public void ende()
	{
		beiEnde();
	}
	
	
	public void beginn()
	{
		beiBeginn();
	}
	
	public void neustart()
	{
		ende();
		beginn();
	}
	
	/**
	 * @brief Wird bei Rundenanfang aufgerufen
	 */
	protected abstract void beiBeginn();
	
	/**
	 * @brief Wird bei Rundenende aufgerufen
	 */
	protected abstract void beiEnde();
}
