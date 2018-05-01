package de.brandgold.Kartenspiel;

import de.brandgold.Kartenspiel.Impl.SpielImpl;

public abstract class Spiel extends SpielObjekt {
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
	
	/**
	 * @brief Wird bei Rundenanfang aufgerufen
	 */
	protected abstract void beiBeginn();
	
	/**
	 * @brief Wird bei Rundenende aufgerufen
	 */
	protected abstract void beiEnde();
}
