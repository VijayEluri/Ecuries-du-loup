package mvc.forum;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import forum.donnees.TopicNouveau;

public class CreationTopicForumValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return TopicNouveau.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre", "error.champs.resquis", new Object[] {"titre"});
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contenu", "error.champs.resquis", new Object[] {"contenu"});
		
		if( errors.hasErrors() ) {
			errors.reject("error.global");
		}
	}
}
