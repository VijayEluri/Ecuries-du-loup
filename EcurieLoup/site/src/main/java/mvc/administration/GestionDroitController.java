package mvc.administration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.Role;
import donnees.User;

@org.springframework.stereotype.Controller
public class GestionDroitController{
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@RequestMapping("/administration/gestionDroit.do")
	public ModelAndView handleRequest(HttpServletRequest request) throws Exception {

		this.gestionModificationDroit(request);

		Map<String, Object> retour = new HashMap<String, Object>();
		retour.put("listeUtilisateur", this.utilisateurManager.getAll());
		retour.put("listeRole", this.utilisateurManager.recupererListeRole());
		return new ModelAndView("administration/gestionDesDroits", retour);
	}

	private void gestionModificationDroit(HttpServletRequest request) {
		String paramDroit = request.getParameter("droit");
		String paramUtilisateur = request.getParameter("utilisateur");

		if ((paramDroit != null) && (paramUtilisateur != null)) {
			Role role = this.getRole(paramDroit);

			User utilisateur = this.utilisateurManager
					.getById(paramUtilisateur);
			if (utilisateur != null) {

				if (role != null) {
					if (this.estDansRoleUtilisateur(utilisateur, role)) {
						Role roleDelete = this.getRoleDelete(utilisateur, role);
						utilisateur.getRoles().remove(roleDelete);
						this.utilisateurManager.update(utilisateur);
					} else {
						utilisateur.getRoles().add(role);
						this.utilisateurManager.update(utilisateur);
					}
				}

			}
		}

	}

	private Role getRoleDelete(User utilisateur, Role role) {
		for (Role roleBoucle : utilisateur.getRoles()) {
			if (role.equals(roleBoucle)) {
				return roleBoucle;
			}
		}
		return null;
	}

	private boolean estDansRoleUtilisateur(User utilisateur, Role role) {
		boolean aRole = false;

		for (Role roleUtilisteur : utilisateur.getRoles()) {
			if (role.equals(roleUtilisteur)) {
				aRole = true;
			}
		}
		return aRole;
	}

	private Role getRole(String nomRole) {

		List<Role> listeRole = this.utilisateurManager.recupererListeRole();
		for (Role role : listeRole) {
			if (role.getRole().equals(nomRole)) {
				return role;
			}
		}
		return null;
	}
}
