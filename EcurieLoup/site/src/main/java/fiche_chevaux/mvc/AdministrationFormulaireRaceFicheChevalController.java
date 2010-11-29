package fiche_chevaux.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiche_chevaux.donnees.Race;
import fiche_chevaux.service.FicheChevauxManager;
@Controller
public class AdministrationFormulaireRaceFicheChevalController{
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}
	
	@ModelAttribute("choix")
	public Race formBackingObject(HttpServletRequest request){
		String param = request.getParameter("id");
		if (param == null) {
			Race race = new Race();
			return race;
		}
		int idRace = Integer.parseInt(param);
		Race race = this.ficheChevauxManager.recupererRace(idRace);
		return race;
	}

	@ModelAttribute("nomChoix")
	public String getChoix(){
		return "Race";
	}

	@RequestMapping(value= "/ficheChevaux/administration/formulaireRace.do", method= RequestMethod.GET)
	public String showChooseForm(){
		return "/ficheChevaux/formulaireChoix";
	}
	
	@RequestMapping(value= "/ficheChevaux/administration/formulaireRace.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("choix")Race race)
			throws Exception {
		if (this.estUneModification(race)) {
			this.ficheChevauxManager.modifierRaceCheval(race);
		} else {

			this.ficheChevauxManager.creerRaceCheval(race);

		}

		return "redirect:choixRace.do";
	}

	private boolean estUneModification(Race race) {
		return race.getId() != 0;
	}
}
