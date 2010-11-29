package service.smiley;

import java.io.File;
import java.util.List;

import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;

public interface SmileyManager {
	public List<Smiley> recupererTousLesSmiley();
	public Smiley recupererSmiley(long idSmiley);
	public void creerSmiley(Smiley smiley, File Fichier);
	public void modifierSmiley(Smiley smiley);
	public void supprimerSmiley(Smiley smiley);
	
	public List<CategorieSmiley> recupererToutesLesCategoriesSmiley();
	public CategorieSmiley recupererCategorieSmiley(long idCategorie);
	public void creerCategorieSmiley(CategorieSmiley categorieSmiley);
	public void modifierCategorieSmiley(CategorieSmiley categorieSmiley);
	public void supprimerCategorieSmiley(CategorieSmiley categorieSmiley);
	
	public void modifierOrdre(CategorieSmiley categorieSmiley, int nouvellePlace);
	public void modifierOrdre(Smiley smiley, int nouvellePlace);
}
