package fiche_chevaux.editor;

import java.beans.PropertyEditorSupport;

import fiche_chevaux.donnees.Race;
import fiche_chevaux.service.FicheChevauxManager;

public class RaceEditor extends PropertyEditorSupport {
	private FicheChevauxManager ficheChevauxManager;

	
	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idRace = Long.parseLong(text);
		Race race = this.ficheChevauxManager.recupererRace(idRace);
		this.setValue(race);

	}
}
