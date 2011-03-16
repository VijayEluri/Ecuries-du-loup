package fr.ecuriesduloup.site.facebook;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.photo.MediaManager;
import forum.service.ForumManager;

public class FacebookController implements Controller {
	private ForumManager forumManager;
	private MediaManager mediaManager;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("forumNombreNouveauxMessages", this.forumManager
				.getNombreNouveauxMessages());
		model.put("albumPhotoNombreNouvellesPhotos", this.mediaManager
				.getNombreNouvellesMedias());

		return new ModelAndView("facebook/acceuil", model);
	}

}
