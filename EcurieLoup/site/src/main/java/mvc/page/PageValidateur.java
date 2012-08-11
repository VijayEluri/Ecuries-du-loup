package mvc.page;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.page.Page;

public class PageValidateur implements Validator {

    @Override
    public boolean supports(Class clazz) {
	return Page.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object command, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.champs.resquis", new Object[] { "title" });

	if (errors.hasErrors()) {
	    errors.reject("error.global");
	}
    }
}
