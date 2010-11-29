package fr.ecuriesduloup.site.facebook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.UtilisateurManager;
import donnees.User;
import fr.ecuriesduloup.site.facebook.api.FacebookManager;

public class UseUtilisateurConnecterController implements Controller {
	private UtilisateurManager utilisateurManager;
	private FacebookManager facebookManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setFacebookManager(FacebookManager facebookManager) {
		this.facebookManager = facebookManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User utilisateurConnecter = this.utilisateurManager
				.getUtilisateurCourant();
		String identifiantFacebook = this.facebookManager
				.getIdentifiantFacebook(request);

		utilisateurConnecter.setIdentifiantFacebook(identifiantFacebook);

		this.utilisateurManager.update(utilisateurConnecter);
		System.out.println("UseUtilisateurConnecterController : redirect");
		return new ModelAndView("redirect:/facebook/acceuil.do");
	}

}
