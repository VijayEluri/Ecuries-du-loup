package mvc.calendrier;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.calendrier.Evenement;

public class EvenementValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Evenement.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"error.champs.resquis", new Object[] { "description" });

		if (errors.hasErrors()) {
			errors.reject("error.global");
		}

	}
}
