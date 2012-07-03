package mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UtilisateurManager;
import service.photo.MediaManager;

@Controller
public class FacebookDisplayPhotoController {
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

    @ModelAttribute("mediaId")
    protected long getMediaId(HttpServletRequest request) {
	long mediaId = this.getParamsId(request, "mediaId");
	if (mediaId == 0) {
	    // last method
	    mediaId = this.getParamsId(request, "idPhoto");
	}
	return mediaId;
    }

    private long getParamsId(HttpServletRequest request, String paramsName) {
	String params = this.getParams(request, paramsName);
	return ((params != null) && !params.equals("")) ? Long.parseLong(params) : 0;
    }

    private String getParams(HttpServletRequest request, String paramsName) {
	String params = request.getParameter(paramsName);
	return (params != null) ? params : "";
    }

    @RequestMapping(value = "/facebook/albumPhoto/affichagePhoto.do", method = RequestMethod.GET)
    public String showForm(@RequestParam("idPhoto") long idPhoto) {
	if (this.utilisateurManager.getUtilisateurCourant() == null) {
	    return "/login";
	} else {
	    return "redirect:/albumPhoto/affichagePhoto.do?idPhoto=" + idPhoto;
	}
    }
}
