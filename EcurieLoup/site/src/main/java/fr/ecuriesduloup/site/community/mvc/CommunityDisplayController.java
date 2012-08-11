package fr.ecuriesduloup.site.community.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.User;

@Controller
public class CommunityDisplayController {
    @Autowired
    @Qualifier("utilisateurManager")
    private UtilisateurManager utilisateurManager;

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    @RequestMapping("/community/list.do")
    public ModelAndView showList() throws Exception {

	Map<String, Object> model = new HashMap<String, Object>();

	List<User> communityUsers = this.utilisateurManager.getAll();

	model.put("listCommunityUsers", communityUsers);
	model.put("headPageTitle", "Les utilisateurs du site");
	model.put("headPageDescription", "La liste des personnes inscrits sur ce site.");

	return new ModelAndView("community/list", model);
    }

    @RequestMapping("/community/card.do")
    public ModelAndView handleRequest(@RequestParam("login") String login) throws Exception {
	if (login != null) {
	    User userOfCard = this.utilisateurManager.getById(login);
	    if (userOfCard != null) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userOfCard", userOfCard);
		model.put("headPageTitle", userOfCard.getLogin() + " - " + userOfCard.getPrenom() + " " + userOfCard.getNom());

		return new ModelAndView("community/card", model);
	    }
	    return new ModelAndView("redirect:list.do");
	}
	return new ModelAndView("redirect:list.do");
    }
}
