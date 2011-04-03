package mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import service.photo.MediaManager;
import donnees.photo.Media;
@Controller
public class FacebookDisplayPhotoController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;	
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@ModelAttribute("photo")
	protected Media formBackingObject(HttpServletRequest request) {
		long idPhoto = Long.parseLong(request.getParameter("idPhoto"));
		Media photo = this.mediaManager.recupererMedia(idPhoto);

		return photo;
	}

	@RequestMapping(value="/facebook/albumPhoto/affichagePhoto.do", method=RequestMethod.GET)
	public String showForm(@RequestParam("idPhoto") long idPhoto){
		if(this.utilisateurManager.getUtilisateurCourant() == null){
			return "/login";
		}else{
			return "redirect:/albumPhoto/affichagePhoto.do?idPhoto="+idPhoto;
		}
	}
}
