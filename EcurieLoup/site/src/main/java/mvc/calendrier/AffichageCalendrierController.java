package mvc.calendrier;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AffichageCalendrierController {

    @RequestMapping("/calendrier/affichage.do")
    public ModelAndView handleRequest() throws Exception {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("headPageTitle", "Le calendrier");
	model.put("headPageDescription", "Retrouvez les évènments des écuries du loup : concours, stages, galops, fêtes...");

	return new ModelAndView("/calendrier/affichageCalendrier", model);
    }
}