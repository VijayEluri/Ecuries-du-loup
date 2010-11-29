package service.smiley;

import java.io.File;
import java.util.List;

import util.SmileyUtil;
import donnees.MemoireVariable;
import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;

public class SmileyManagerImpl implements SmileyManager {
	private SmileyUtil smileyUtil;
	private String emplacementSmiley;
	private SmileyManagerData smileyManagerData;
	private CategorieSmileyManager categorieSmileyManager;

	public void setSmileyManagerData(SmileyManagerData smileyManagerData) {
		this.smileyManagerData = smileyManagerData;
	}
	public void setCategorieSmileyManager(
			CategorieSmileyManager categorieSmileyManager) {
		this.categorieSmileyManager = categorieSmileyManager;
	}


	public void setSmileyUtil(SmileyUtil smileyUtil) {
		this.smileyUtil = smileyUtil;
	}



	public void setEmplacementSmiley(String emplacementSmiley) {
		this.emplacementSmiley = emplacementSmiley;
	}



	@Override
	public void creerCategorieSmiley(CategorieSmiley categorieSmiley) {
		this.categorieSmileyManager.add(categorieSmiley);
	}


	@Override
	public void creerSmiley(Smiley smiley, File fichier) {
		this.smileyManagerData.add(smiley);
		String emplacement = MemoireVariable.optenirVariable("pathServeur")+this.emplacementSmiley;
		this.smileyUtil.creerFicherSurDisque(emplacement, ""+smiley.getId(), fichier);
	}

	@Override
	public void modifierCategorieSmiley(CategorieSmiley categorieSmiley) {
		this.categorieSmileyManager.update(categorieSmiley);
	}

	@Override
	public void modifierSmiley(Smiley smiley) {
		this.smileyManagerData.update(smiley);
	}

	@Override
	public CategorieSmiley recupererCategorieSmiley(long idCategorie) {
		return this.categorieSmileyManager.getById(idCategorie);
	}

	@Override
	public Smiley recupererSmiley(long idSmiley) {
		return this.smileyManagerData.getById(idSmiley);
	}

	@Override
	public List<Smiley> recupererTousLesSmiley() {

		return this.smileyManagerData.getAll();
	}

	@Override
	public List<CategorieSmiley> recupererToutesLesCategoriesSmiley() {
		return this.categorieSmileyManager.getAll();
	}


	@Override
	public void supprimerCategorieSmiley(CategorieSmiley categorieSmiley) {
		for(Smiley smiley : categorieSmiley.getSmileys()){

			this.supprimerSmiley(smiley);
		}
		this.categorieSmileyManager.delete(categorieSmiley);

	}


	@Override
	public void supprimerSmiley(Smiley smiley) {
		String emplacementFichier = MemoireVariable.optenirVariable("pathServeur")+this.emplacementSmiley+"/"+smiley.getId();
		this.smileyUtil.supprimerFicherSurDisque(emplacementFichier);

		this.smileyManagerData.delete(smiley);
	}
	public void modifierOrdre(CategorieSmiley categorieSmiley, int nouvellePlace) {
		this.categorieSmileyManager.changeOrdre(categorieSmiley, nouvellePlace);
	}

	@Override
	public void modifierOrdre(Smiley smiley, int nouvellePlace) {
		this.smileyManagerData.changeOrdre(smiley, nouvellePlace);
	}
}
