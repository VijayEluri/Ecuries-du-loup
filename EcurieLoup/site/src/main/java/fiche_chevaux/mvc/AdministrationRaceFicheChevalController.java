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

import fiche_chevaux.donnees.Race;
import fiche_chevaux.service.ExistFicheWithThisRaceException;
import fiche_chevaux.service.FicheChevauxManager;
import fr.ecuriesduloup.util.message.MessageI18nManager;

@Controller
public class AdministrationRaceFicheChevalController{
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;
	@Autowired
	private MessageI18nManager messageManager;

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}

	public void setMessageManager(MessageI18nManager messageManager) {
		this.messageManager = messageManager;
	}

	@RequestMapping("/ficheChevaux/administration/choixRace.do")
	public ModelAndView handleRequest() {
		List<Race> listChoise = this.ficheChevauxManager
				.recupererToutesLesRaces();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nomChoix", "Race");
		model.put("listChoise", listChoise);
		return new ModelAndView("ficheChevaux/affichageChoix", model);
	}
	@RequestMapping(value="/ficheChevaux/administration/choixRace.do", params="suppression")
	public String gestionSuppression(@RequestParam("suppression")long idRace) {
		
			Race race = this.ficheChevauxManager.recupererRace(idRace);
			try {
				this.ficheChevauxManager.supprimerRaceCheval(race);
				
			} catch (ExistFicheWithThisRaceException e) {
				/*request.setAttribute(
								"message",
								this.messageManager
										.getMessage("ficheChevaux.choise_list.error.existHorseWithThisRace"));*/
				//TODO remettre un message d'erreur 
			}
		return "redirect:choixRace.do";
	}

}
