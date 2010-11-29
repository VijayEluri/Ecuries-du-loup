package fr.ecuriesduloup.ecurieloup.memo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;

public class MemoValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Memo.class.isAssignableFrom(clazz);
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
