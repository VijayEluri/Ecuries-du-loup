package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.UtilisateurManager;
import donnees.User;
import forum.service.ForumManager;

public class NouveauMessageForumInterceptor extends HandlerInterceptorAdapter {
	private UtilisateurManager utilisateurManager;
	private ForumManager forumManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		User utilistateurCourant = this.utilisateurManager
				.getUtilisateurCourant();
		if (utilistateurCourant != null) {
			boolean hasNouveauxMessages = this.forumManager
					.hasNouveauxMessages();
			if(modelAndView != null){
				modelAndView.addObject("hasNouveauMessageForum",
						hasNouveauxMessages);
				int nombreNouveauxMessages = this.forumManager
						.getNombreNouveauxMessages();
				modelAndView.addObject("nombreNouveauxMessages",
						nombreNouveauxMessages);
			}
		}
	}
}
