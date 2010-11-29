package fiche_chevaux.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;

@Controller
public class AffichageFicheChevauxControlleur{
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}

	@RequestMapping("/ficheChevaux/affichageFiche.do")
	public ModelAndView handleRequest(@RequestParam("id") long id){
		Fiche fiche = this.ficheChevauxManager.recupererFiche(id);

		while (fiche.getSurnoms().remove(null)) {
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ficheCheval", fiche);
		return new ModelAndView("ficheChevaux/affichageFicheCheval", model);
	}
	
	
	
	@RequestMapping("/ficheChevaux/affichage.do")
	public ModelAndView showFicheList(){
		List<Fiche> fiches = this.ficheChevauxManager.recupererToutesLesFiches();
		Map<String, Object> renvoyer = new HashMap<String, Object>();

		renvoyer.put("fichesChevaux", fiches);
		return new ModelAndView("ficheChevaux/affichageListeFicheChevaux",renvoyer);
	}


	@RequestMapping(value="/ficheChevaux/affichage.do", params= "suppression")
	public String deleteFiche(@RequestParam("suppression") long idFiche){
		Fiche fiche = this.ficheChevauxManager.recupererFiche(idFiche);
		this.ficheChevauxManager.supprimerFicheChevaux(fiche);
		return "redirect:affichage.do";
	}

}
