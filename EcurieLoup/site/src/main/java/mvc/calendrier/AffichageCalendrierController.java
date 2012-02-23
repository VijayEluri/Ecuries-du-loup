package mvc.calendrier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AffichageCalendrierController {
	

	@RequestMapping("/calendrier/affichage.do")
	public ModelAndView handleRequest() throws Exception {
		

		return new ModelAndView("/calendrier/affichageCalendrier");
	}
}