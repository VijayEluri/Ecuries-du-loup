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

import fiche_chevaux.donnees.Robe;
import fiche_chevaux.service.ExistFicheWithThisRobeException;
import fiche_chevaux.service.FicheChevauxManager;
import fr.ecuriesduloup.util.message.MessageI18nManager;

@Controller
public class AdministrationRobeFicheChevalController{
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

	@RequestMapping("/ficheChevaux/administration/choixRobe.do")
	public ModelAndView showList() {
		List<Robe> listChoise = this.ficheChevauxManager
		.recupererToutesLesRobes();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nomChoix", "Robe");
		model.put("listChoise", listChoise);
		return new ModelAndView("ficheChevaux/affichageChoix", model);
	}
	
	@RequestMapping(value="/ficheChevaux/administration/choixRobe.do", params="suppression")
	public String gestionSuppression(@RequestParam("suppression")long idRobe) {

		Robe robe = this.ficheChevauxManager.recupererRobe(idRobe);
		try {
			this.ficheChevauxManager.supprimerRobeCheval(robe);
		} catch (ExistFicheWithThisRobeException e) {
			/*request
						.setAttribute(
								"message",
								this.messageManager
										.getMessage("ficheChevaux.choise_list.error.existHorseWithThisRobe"));
			 */
			//TODO remettre un message d'erreur 
		}
		return "redirect:choixRobe.do";
	}

}
