package mvc.calendrier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.calendrier.CalendrierManager;
import service.calendrier.DeleteTypeEvenementException;
import donnees.calendrier.TypeEvenement;

@Controller
public class AffichageTypeEvenementController{
	@Autowired
	@Qualifier("calendrierManager")
	private CalendrierManager calendrierManager;

	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}

	@RequestMapping("/calendrier/administration/affichageTypeEvenement.do")
	public ModelAndView handleRequest() throws Exception {


		Map<String, Object> renvoyer = new HashMap<String, Object>();

		List<TypeEvenement> listeTypeEvenement = this.calendrierManager
		.getAllTypeEvents();
		renvoyer.put("listeTypeEvenement", listeTypeEvenement);
		return new ModelAndView("calendrier/affichageTypeEvenement", renvoyer);

	}
	@RequestMapping(value = "/calendrier/administration/affichageTypeEvenement.do", params = "suppression")
	public String suppressionTypeEvenement(@RequestParam("suppression")int id) {

		TypeEvenement typeEvenement = this.calendrierManager.getTypeEvent(id);

		try {
			this.calendrierManager.delete(typeEvenement);
		} catch (DeleteTypeEvenementException e) {
			/*request
						.setAttribute("message",
								"Impossible de supprimer. Il existe encore des évenements de ce type.");

			 */
			//TODO affiché le message
		}
		return "redirect:affichageTypeEvenement.do";
	}
}