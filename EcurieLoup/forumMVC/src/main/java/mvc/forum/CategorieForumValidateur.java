package mvc.forum;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import forum.donnees.Categorie;

public class CategorieForumValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Categorie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre", "error.champs.resquis", new Object[] {"titre"});
		
		if( errors.hasErrors() ) {
			errors.reject("error.global");
		}

	}
}
