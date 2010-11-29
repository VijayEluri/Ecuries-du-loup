package mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.User;

/**
 * Validateur lors de l'enregistrement d'un nouvel utilisateur
 * 
 * @author Krack
 * 
 */
public class LosePasswordValidator implements Validator {
	
	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login","error.champs.resquis", new Object[] { "login" });

		
		if (errors.hasErrors()) {
			errors.reject("error.global");
		}
	}
}
