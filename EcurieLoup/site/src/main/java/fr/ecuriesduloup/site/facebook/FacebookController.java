package fr.ecuriesduloup.site.facebook;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.photo.AlbumPhotoManager;
import forum.service.ForumManager;

public class FacebookController implements Controller {
	private ForumManager forumManager;
	private AlbumPhotoManager albumPhotoManager;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("forumNombreNouveauxMessages", this.forumManager
				.getNombreNouveauxMessages());
		model.put("albumPhotoNombreNouvellesPhotos", this.albumPhotoManager
				.getNombreNouvellesPhotos());

		return new ModelAndView("facebook/acceuil", model);
	}

}
