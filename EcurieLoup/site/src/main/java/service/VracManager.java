package service;

import donnees.Vrac;

public interface VracManager {

	public Vrac recupererVrac(String identifiant);

	public void modifierVrac(Vrac vrac);
}
