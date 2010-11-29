package fiche_chevaux.editor;

import java.beans.PropertyEditorSupport;

import fiche_chevaux.donnees.Robe;
import fiche_chevaux.service.FicheChevauxManager;

public class RobeEditor extends PropertyEditorSupport {
	private FicheChevauxManager ficheChevauxManager;

	
	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idRobe = Long.parseLong(text);
		Robe robe = this.ficheChevauxManager.recupererRobe(idRobe);
		this.setValue(robe);

	}
}
