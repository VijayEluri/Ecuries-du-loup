package fiche_chevaux.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.User;

@Controller
public class OwnerSuggestController{
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	
	
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}


	@RequestMapping("ficheChevaux/ajax/ownerSuggest.do")
	public ModelAndView handleRequest() throws Exception {
		List<User> users = this.utilisateurManager.getAll();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", users);
		
		return new ModelAndView("ficheChevaux/ownerSuggest", model);
	}

}
