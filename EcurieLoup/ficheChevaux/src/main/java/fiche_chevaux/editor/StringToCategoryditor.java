package fiche_chevaux.editor;

import java.beans.PropertyEditorSupport;

import fiche_chevaux.donnees.Category;
import fiche_chevaux.service.FicheChevauxManager;

public class StringToCategoryditor extends PropertyEditorSupport {
	private FicheChevauxManager ficheChevauxManager;

	
	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long id = Long.parseLong(text);
		Category category = this.ficheChevauxManager.getCategory(id);
		this.setValue(category);

	}
}
