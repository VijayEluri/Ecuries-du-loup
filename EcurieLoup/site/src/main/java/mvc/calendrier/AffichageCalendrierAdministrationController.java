package mvc.calendrier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AffichageCalendrierAdministrationController{

	@RequestMapping("/calendrier/administration/administration.do")
	public String handleRequest(){
		return "calendrier/affichageAdministration";
	}
}
