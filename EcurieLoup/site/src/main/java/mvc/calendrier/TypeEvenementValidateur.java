package mvc.calendrier;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.calendrier.TypeEvenement;

public class TypeEvenementValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return TypeEvenement.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
				"error.champs.resquis", new Object[] { "nom" });

		if (errors.hasErrors()) {
			errors.reject("error.global");
		}

	}
}
