package mvc.photo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.photo.MediaManager;
import donnees.photo.Album;
import donnees.photo.Media;

@Controller
public class AffichageAlbumPhotoController {
    @Autowired
    @Qualifier("mediaManager")
    private MediaManager mediaManager;

    public void setAlbumPhotoManager(MediaManager albumPhotoManager) {
	this.mediaManager = albumPhotoManager;
    }

    @RequestMapping("/albumPhoto/affichage.do")
    public ModelAndView affichageTousLesAlbums(HttpServletRequest request) {
	List<Album> listeAlbum = this.mediaManager.getAllAlbumsLigth();
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("listeAlbums", listeAlbum);
	if (request.getParameter("message") != null) {
	    model.put("message", request.getParameter("message"));
	}
	model.put("headPageTitle", "Liste des albums photos");
	model.put("headPageDescription", "Les albums photos des cavaliers et chevaux des écuries du loup.");

	return new ModelAndView("photo/affichageTousLesAbums", model);
    }

    @RequestMapping(value = "/albumPhoto/affichage.do", params = "idAlbum")
    public ModelAndView affichageAlbum(@RequestParam("idAlbum") long idAlbum, HttpServletRequest request) {
	Album album = this.mediaManager.recupererAlbumLight(idAlbum);

	List<Media> listePhoto = new ArrayList<Media>(album.getMedias());

	Map<String, Object> model = new HashMap<String, Object>();
	model.put("album", album);

	model.put("listePhoto", listePhoto);

	if (request.getParameter("message") != null) {
	    model.put("message", request.getParameter("message"));
	}
	model.put("headPageTitle", album.getTitre());

	return new ModelAndView("photo/affichageAbum", model);
    }

    @RequestMapping(value = "/albumPhoto/affichage.do", params = "nonVu")
    public ModelAndView affichagePhotosNonVu() {
	List<Media> listePhoto = this.mediaManager.recupererMediasNonVu();

	Map<String, Object> model = new HashMap<String, Object>();
	Album album = new Album();
	album.setId(0);
	album.setTitre("non vu");
	model.put("album", album);

	model.put("optionsUrlParameter", "&options=notread");

	model.put("listePhoto", listePhoto);

	model.put("headPageTitle", "Photos non vues");
	model.put("headPageDescription", "La liste des photos que vous n'avez pas encore vu.");

	return new ModelAndView("photo/affichageAbum", model);
    }
}
