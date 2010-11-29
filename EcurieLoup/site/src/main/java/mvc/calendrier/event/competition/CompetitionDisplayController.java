package mvc.calendrier.event.competition;

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
public class CompetitionDisplayController{
	@Autowired
	@Qualifier("calendrierManager")
	public CalendrierManager calendrierManager;
		
	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}


	@RequestMapping("/calendrier/event/viewConcours.do")
	public ModelAndView showPage(@RequestParam("id")long idEvent){
				
		Evenement event= this.calendrierManager.getEvent(idEvent);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("event", event);
		return new ModelAndView("calendrier/event/competition/CompetitionDisplay", model);
	}

}
