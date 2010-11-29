package mvc.forum.administration;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.smiley.CategorieSmileyLight;

public class CategorieSmileyValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return CategorieSmileyLight.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "error.champs.resquis", new Object[] {"nom"});
		
		if( errors.hasErrors() ) {
			errors.reject("error.global");
		}
	}
}
