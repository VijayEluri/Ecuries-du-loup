package fiche_chevaux.editor;

import java.beans.PropertyEditorSupport;

import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.service.FicheChevauxManager;

public class SexeEditor extends PropertyEditorSupport {
	private FicheChevauxManager ficheChevauxManager;

	
	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idSexe = Long.parseLong(text);
		Sexe sexe = this.ficheChevauxManager.recupererSexe(idSexe);
		this.setValue(sexe);

	}
}
