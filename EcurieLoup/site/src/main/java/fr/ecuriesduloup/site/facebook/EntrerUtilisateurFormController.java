package fr.ecuriesduloup.site.facebook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import service.UtilisateurManager;
import donnees.User;
import fr.ecuriesduloup.site.facebook.api.FacebookManager;

public class EntrerUtilisateurFormController extends SimpleFormController {
	private UtilisateurManager utilisateurManager;
	private FacebookManager facebookManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setFacebookManager(FacebookManager facebookManager) {
		this.facebookManager = facebookManager;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		return new ChoixUserFacebook();
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ChoixUserFacebook choixUserFacebook = (ChoixUserFacebook) command;
		String identifiantFacebook = this.facebookManager
				.getIdentifiantFacebook(request);

		this
				.suppressionAncienUtilisateurIdentifiantFacebook(identifiantFacebook);
		this.ajoutNouvelUtilisateurIdentifiantFacebook(choixUserFacebook,
				identifiantFacebook);

		return new ModelAndView("redirect:/facebook/acceuil.do");

	}

	private void suppressionAncienUtilisateurIdentifiantFacebook(
			String identifiantFacebook) {
		User utilistateurFacebook = this.utilisateurManager
				.rechercheUtilisateurFacebook(identifiantFacebook);
		if (utilistateurFacebook != null) {
			utilistateurFacebook.setIdentifiantFacebook(null);
			this.utilisateurManager.update(utilistateurFacebook);
		}

	}

	private void ajoutNouvelUtilisateurIdentifiantFacebook(
			ChoixUserFacebook nouvelUtilisateur, String identifiantFacebook) {
		User utilistateurAuthentifier = this.utilisateurManager
				.getById(nouvelUtilisateur.getUsername());
		utilistateurAuthentifier.setIdentifiantFacebook(identifiantFacebook);
		this.utilisateurManager.update(utilistateurAuthentifier);

		UtilitairePourFacebook.forceConnexion(utilistateurAuthentifier);
	}
}
