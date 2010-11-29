package mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.User;

/**
 * Validateur pour la gestion du profil
 * 
 * @author Krack
 * 
 */
public class ProfilValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// User utilisateur = (User)command;

		// "Mot de passe requis"
		// on vérifie que les champs ne sont pas vide

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"error.champs.resquis", new Object[] { "password" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
				"error.champs.resquis", new Object[] { "nom" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom",
				"error.champs.resquis", new Object[] { "prénom" });
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"error.champs.resquis", new Object[] { "email" });

		// on vérifie l'email
		// TODO : vérifie que c'est un email

		// on met un message général
		if (errors.hasErrors()) {
			errors.reject("error.global");
		}
	}
}
