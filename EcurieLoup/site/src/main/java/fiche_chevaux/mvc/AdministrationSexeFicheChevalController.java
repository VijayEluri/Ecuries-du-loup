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

import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.service.ExistFicheWithThisSexeException;
import fiche_chevaux.service.FicheChevauxManager;
import fr.ecuriesduloup.util.message.MessageI18nManager;

@Controller
public class AdministrationSexeFicheChevalController{
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

	@RequestMapping("/ficheChevaux/administration/choixSexe.do")
	public ModelAndView handleRequest() throws Exception {

		List<Sexe> listChoise = this.ficheChevauxManager.recupererTousLesSexes();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nomChoix", "Sexe");
		model.put("listChoise", listChoise);
		return new ModelAndView("ficheChevaux/affichageChoix", model);
	}

	@RequestMapping(value="/ficheChevaux/administration/choixSexe.do", params="suppression")
	public String gestionSuppression(@RequestParam("suppression")long idSupprimer) {

		Sexe sexe = this.ficheChevauxManager.recupererSexe(idSupprimer);
		try {
			this.ficheChevauxManager.supprimerSexeCheval(sexe);

		} catch (ExistFicheWithThisSexeException e) {
			/*request
						.setAttribute(
								"message",
								this.messageManager
										.getMessage("ficheChevaux.choise_list.error.existHorseWithThisSexe"));
			 */
			//TODO remettre un message d'erreur 
		}
		return "redirect:choixSexe.do";
	}

}
