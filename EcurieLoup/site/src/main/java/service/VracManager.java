package service;

import donnees.Vrac;
import donnees.news.Nouvelle;

public interface VracManager {

	public Vrac recupererVrac(String identifiant);

	public void modifierVrac(Vrac vrac);

	public Vrac getFormatedVrac(String string, String pathServeur);
}
