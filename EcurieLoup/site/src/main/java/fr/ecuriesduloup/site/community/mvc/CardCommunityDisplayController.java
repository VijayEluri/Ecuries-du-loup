package fr.ecuriesduloup.site.community.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import donnees.User;

import service.UtilisateurManager;

public class CardCommunityDisplayController implements Controller {
	private UtilisateurManager utilisateurManager;
	
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String login = request.getParameter("login");
		if(login !=null){
			User userOfCard = this.utilisateurManager.getById(login);
			if(userOfCard!=null){
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("userOfCard", userOfCard);
				return new ModelAndView("community/card", model);
			}
			return new ModelAndView("redirect:list.do");
		}
		return new ModelAndView("redirect:list.do");
	}

}
