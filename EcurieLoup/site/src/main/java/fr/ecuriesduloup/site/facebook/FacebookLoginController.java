package fr.ecuriesduloup.site.facebook;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.UtilisateurManager;
import fr.ecuriesduloup.site.facebook.api.FacebookManager;
import fr.ecuriesduloup.site.facebook.api.NoSessionKeyException;

public class FacebookLoginController implements Controller {
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
		return this.authentificationFacebook(request, response);
	}

	private ModelAndView authentificationFacebook(HttpServletRequest request,
			HttpServletResponse response) {

		String identifiantFacebook;
		try {

			identifiantFacebook = this.facebookManager
					.getIdentifiantFacebook(request);
			System.out.println("identifiantFacebook : " + identifiantFacebook);
		} catch (NoSessionKeyException e) {
			return this.redirectionFacebookLogin();
		}

		return this.gestionConnection(identifiantFacebook);
	}

	private ModelAndView redirectionFacebookLogin() {
		String apiKey = this.facebookManager.getApiKey();
		Map<String, Object> model = new HashMap<String, Object>();
		String url = "http://www.facebook.com/login.php?api_key=" + apiKey
				+ "&v=1.0&canvas&next=index";
		model.put("url", url);
		return new ModelAndView("facebook/redirectionLoginFacebook");
	}

	private ModelAndView gestionConnection(String identifiantFacebook) {
		donnees.User utilisateur = this.utilisateurManager
				.rechercheUtilisateurFacebook(identifiantFacebook);
		if (this.isAlreadyConnected(utilisateur)) {
			System.out.println("isAlreadyConnected");
			return new ModelAndView("redirect:/facebook/acceuil.do");
		} else {
			System.out.println("gestionUtilisateurNonConnecterOudifferent");
			return this.gestionUtilisateurNonConnecterOudifferent(utilisateur);
		}
	}

	private ModelAndView gestionUtilisateurNonConnecterOudifferent(
			donnees.User utilisateur) {
		if (this.isNewUserOfFacebookApplication(utilisateur)) {
			System.out.println("isNewUserOfFacebookApplication");
			return this.gestionNouvelUtilisateur();
		} else {
			this.connecterUtilisateur(utilisateur);
			System.out.println("isNewUserOfFacebookApplication else");
			return new ModelAndView("redirect:/facebook/acceuil.do");
		}

	}

	private boolean isNewUserOfFacebookApplication(donnees.User utilisateur) {
		return utilisateur == null;
	}

	private ModelAndView gestionNouvelUtilisateur() {
		donnees.User utilisateurConnecter = this.utilisateurManager
				.getUtilisateurCourant();
		if (utilisateurConnecter != null) {
			System.out.println("propose de se connecter "
					+ utilisateurConnecter.getLogin());
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("loginUser", utilisateurConnecter.getLogin());
			return new ModelAndView("/facebook/choixUtilisateur", model);
		} else {
			System.out.println("ici");
			return new ModelAndView("redirect:/facebook/entrerUtilisateur.do");
		}
	}

	private void connecterUtilisateur(donnees.User utilisateur) {
		// on met a jour sa date d'accès
		utilisateur.setLastAccessDate(new Date());
		this.utilisateurManager.update(utilisateur);

		System.out.println("---------\n" + utilisateur.toString()
				+ "\n---------");

		UtilitairePourFacebook.forceConnexion(utilisateur);

	}

	private boolean isAlreadyConnected(donnees.User utilisateurFacebook) {
		if (utilisateurFacebook == null) {
			return false;
		}
		donnees.User utilisateurConnecter = this.utilisateurManager
				.getUtilisateurCourant();

		return utilisateurFacebook.equals(utilisateurConnecter);

	}

}
