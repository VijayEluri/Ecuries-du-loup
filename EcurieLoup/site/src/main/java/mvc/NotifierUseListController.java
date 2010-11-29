package mvc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.User;
@Controller
public class NotifierUseListController {
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	
	@RequestMapping(value= "/notifier/list.do", method= RequestMethod.GET)
	public ModelAndView showForm(){
		List<User> users = this.utilisateurManager.getAll();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", users);
		model.put("now", new Date().getTime());
		
		return new ModelAndView("/notifier/list", model);
	
	}
}
