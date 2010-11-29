package fiche_chevaux.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;

public class AffichageListeFicheChevauxController implements Controller {
	private FicheChevauxManager ficheChevauxManager;

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (this.gestionSuppression(request)) {
			String redirect = "redirect:affichage.do";
			return new ModelAndView(redirect);
		}

		List<Fiche> fiches = this.ficheChevauxManager
				.recupererToutesLesFiches();
		Map<String, Object> renvoyer = new HashMap<String, Object>();

		renvoyer.put("fichesChevaux", fiches);
		return new ModelAndView("ficheChevaux/affichageListeFicheChevaux",
				renvoyer);
	}

	private boolean gestionSuppression(HttpServletRequest request) {
		String suppression = request.getParameter("suppression");
		if (suppression != null) {
			int idFiche = Integer.parseInt(suppression);
			Fiche fiche = this.ficheChevauxManager.recupererFiche(idFiche);
			this.ficheChevauxManager.supprimerFicheChevaux(fiche);
			return true;

		}
		return false;
	}

}
