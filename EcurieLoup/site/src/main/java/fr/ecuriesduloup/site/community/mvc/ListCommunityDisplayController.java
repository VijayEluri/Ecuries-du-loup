package fr.ecuriesduloup.site.community.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.UtilisateurManager;
import donnees.User;

public class ListCommunityDisplayController implements Controller{
	private UtilisateurManager utilisateurManager;
	
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		Map<String, Object> model = new HashMap<String, Object>();
		
		List<User> communityUsers = this.utilisateurManager.getAll();
		
		model.put("listCommunityUsers", communityUsers);
		
		
		return new ModelAndView("community/list", model);
	}

}
