package mvc.administration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.User;

@Controller
public class GestionUtilisateurController{
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@RequestMapping("/administration/gestionUtilisateur.do")
	public ModelAndView handleRequest(HttpServletRequest request){

		this.gestionActivationUtilisateur(request);
		Map<String, Object> retour = new HashMap<String, Object>();
		retour.put("listeUtilisateur", this.utilisateurManager.getAll());
		return new ModelAndView("administration/gestionUtilisateur", retour);
	}

	private void gestionActivationUtilisateur(HttpServletRequest request) {
		String paramActivation = request.getParameter("activation");
		if (paramActivation != null) {
			User utilisateur = this.utilisateurManager.getById(paramActivation);
			if (utilisateur != null) {
				utilisateur.setEnabled(!utilisateur.isEnabled());
				this.utilisateurManager.update(utilisateur);
			}
		}

	}
}
