package mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.UtilisateurManager;
import donnees.User;

public class LienInterceptor extends HandlerInterceptorAdapter {
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		List<User> listeUtilisateur = this.utilisateurManager.getAll();

		List<String> liens = new ArrayList<String>();

		for (User utilisateur : listeUtilisateur) {
			if (!utilisateur.getSite().equals("")) {
				liens.add(utilisateur.getSite());
			}
		}
		if (modelAndView == null) {
			modelAndView = new ModelAndView();
		}
		modelAndView.addObject("listeLien", liens);
	}

}
