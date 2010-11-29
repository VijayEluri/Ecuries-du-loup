package mvc.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AffichageAdministrationController{
	@RequestMapping("/administration/affichage.do")
	public String handleRequest() throws Exception {
		return "administration/affichageAdministration";
	}

}
