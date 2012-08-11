package mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import service.UtilisateurManager;
import donnees.User;

public class EnregistrementUtilisateurValidator implements Validator {
    private UtilisateurManager utilisateurManager;

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    @Override
    public boolean supports(Class clazz) {
	return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object command, Errors errors) {
	User utilisateur = (User) command;

	// on vérifie que les champs ne sont pas vide
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "error.champs.resquis", new Object[] { "login" });
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.champs.resquis", new Object[] { "password" });
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "error.champs.resquis", new Object[] { "nom" });
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "error.champs.resquis", new Object[] { "prénom" });
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.champs.resquis", new Object[] { "email" });

	// on vérifie que le login n'est pas pris
	if (this.utilisateurManager.getById(utilisateur.getLogin()) != null) {
	    errors.rejectValue("login", "error.login.already_use", new Object[] { utilisateur.getLogin() }, "login déjà utilisé");
	}
	for (User user : this.utilisateurManager.getAll()) {
	    if ((utilisateur.getEmail() != null) && utilisateur.getEmail().equals(user.getEmail())) {
		errors.rejectValue("email", "error.email.already_use", new Object[] { utilisateur.getLogin() }, "email déjà utilisé");
	    }
	}

	// TODO : make this with regex autorize only accept char
	// ' pose problème dans les requêtes
	if (utilisateur.getLogin().contains("'")) {
	    errors.rejectValue("login", "error.login.specialChar", new Object[] { "'" }, "' interdit dans un login!");
	}

	// pose probleme
	if (utilisateur.getLogin().contains("\"")) {
	    errors.rejectValue("login", "error.login.specialChar", new Object[] { "\"" }, "\" interdit dans un login!");
	}

	// pose probleme dans les url
	if (utilisateur.getLogin().contains("&")) {
	    errors.rejectValue("login", "error.login.specialChar", new Object[] { "&" }, "& interdit dans un login!");
	}

	// pose probleme dans les url
	if (utilisateur.getLogin().contains("=")) {
	    errors.rejectValue("login", "error.login.specialChar", new Object[] { "=" }, "= interdit dans un login!");
	}
	// on vérifie l'email
	// TODO : vérifie que c'est un email

	// on met un message général
	if (errors.hasErrors()) {
	    errors.reject("error.global");
	}
    }
}
