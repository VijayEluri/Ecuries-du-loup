package fr.ecuriesduloup.site.facebook;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import service.UtilisateurManager;
import donnees.User;

public class ChoixUserFacebookValidator implements Validator {

	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public boolean supports(Class clazz) {
		return ChoixUserFacebook.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {

		ChoixUserFacebook utilisateur = (ChoixUserFacebook) command;
		this.checkRemplissageChamps(errors);

		if (!errors.hasErrors()) {
			this.checkExistUser(utilisateur, errors);
		}

		if (!errors.hasErrors()) {
			this.checkPasswordUser(utilisateur, errors);
		}
	}

	private void checkRemplissageChamps(Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"facebook.error.champs.resquis", new Object[] { "username" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"facebook.error.champs.resquis", new Object[] { "password" });

	}

	private void checkExistUser(ChoixUserFacebook utilisateur, Errors errors) {
		User utilisateurTrouve = this.utilisateurManager.getById(utilisateur
				.getUsername());

		if (utilisateurTrouve == null) {
			errors.reject("facebook.error.connexionImpossible");
		}
	}

	private void checkPasswordUser(ChoixUserFacebook utilisateur, Errors errors) {
		User utilisateurTrouve = this.utilisateurManager.getById(utilisateur
				.getUsername());

		if (!utilisateurTrouve.getPassword().equals(utilisateur.getPassword())) {
			errors.reject("facebook.error.connexionImpossible");
		}
	}
}
