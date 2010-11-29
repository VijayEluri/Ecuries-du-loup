package editor;

import java.beans.PropertyEditorSupport;

import service.UtilisateurManager;

import donnees.User;

public class StringToUserEditor extends PropertyEditorSupport {
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = this.utilisateurManager.getById(text);
		this.setValue(user);

	}
}
