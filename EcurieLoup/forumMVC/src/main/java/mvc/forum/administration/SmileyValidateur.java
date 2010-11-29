package mvc.forum.administration;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.smiley.SmileyLight;

public class SmileyValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return SmileyLight.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "error.champs.resquis", new Object[] {"code"});
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "error.champs.resquis", new Object[] {"image"});
		
		if( errors.hasErrors() ) {
			errors.reject("error.global");
		}
	}
}
