package mvc.calendrier;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.calendrier.CalendrierManager;
import donnees.calendrier.Evenement;

@Controller
public class AffichageListeEvenementController {
	@Autowired
	@Qualifier("calendrierManager")
	private CalendrierManager calendrierManager;

	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}

	@RequestMapping("/calendrier/administration/affichageEvenement.do")
	public ModelAndView handleRequest() throws Exception {
		Map<String, Object> renvoyer = new HashMap<String, Object>();
		renvoyer.put("listeEvenement", this.calendrierManager.getAllEvents());

		return new ModelAndView("/calendrier/affichageListeEvenement", renvoyer);
	}
	@RequestMapping(value = "/calendrier/administration/affichageEvenement.do", params= "suppression")
	public String suppressionEvenement(@RequestParam("suppression")String suppression) {

		long id = Long.parseLong(suppression);
		Evenement evenement = this.calendrierManager.getEvent(id);
		this.calendrierManager.delete(evenement);
		return "redirect:affichageEvenement.do";
	}
}