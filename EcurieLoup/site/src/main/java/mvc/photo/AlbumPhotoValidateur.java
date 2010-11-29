package mvc.photo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import donnees.photo.AlbumLight;

public class AlbumPhotoValidateur implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return AlbumLight.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		AlbumLight album = (AlbumLight) command;
		if (album.getTitre() != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre",
					"error.champs.resquis", new Object[] { "titre" });
		}

		if (errors.hasErrors()) {
			errors.reject("error.global");
		}
	}
}
