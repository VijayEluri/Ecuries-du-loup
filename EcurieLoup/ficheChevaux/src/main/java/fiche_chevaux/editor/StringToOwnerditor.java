package fiche_chevaux.editor;

import java.beans.PropertyEditorSupport;

import fiche_chevaux.donnees.Owner;
import fiche_chevaux.service.FicheChevauxManager;

public class StringToOwnerditor extends PropertyEditorSupport {
	private FicheChevauxManager ficheChevauxManager;

	
	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idOwner = Long.parseLong(text);
		Owner owner = this.ficheChevauxManager.recupererOwner(idOwner);
		this.setValue(owner);

	}
}
