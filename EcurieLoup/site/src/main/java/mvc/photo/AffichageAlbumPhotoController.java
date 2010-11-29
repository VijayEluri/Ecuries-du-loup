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

import service.photo.AlbumPhotoManager;
import donnees.photo.Album;
import donnees.photo.Photo;

@Controller
public class AffichageAlbumPhotoController {
	@Autowired
	@Qualifier("albumPhotoManager")
	private AlbumPhotoManager albumPhotoManager;

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}
	
	
	@RequestMapping("/albumPhoto/affichage.do")
	public ModelAndView affichageTousLesAlbums(HttpServletRequest request) {
		List<Album> listeAlbum = this.albumPhotoManager
				.recupererTousLesAlbums();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listeAlbums", listeAlbum);
		if(request.getParameter("message")!=null){
			model.put("message", request.getParameter("message"));
		}
		return new ModelAndView("photo/affichageTousLesAbums", model);
	}
	
	
	
	
	@RequestMapping(value="/albumPhoto/affichage.do", params="idAlbum")
	public ModelAndView affichageAlbum(@RequestParam("idAlbum")long idAlbum, HttpServletRequest request) {
		Album album = this.albumPhotoManager.recupererAlbum(idAlbum);
		this.albumPhotoManager.visionnnageAlbum(album);

		List<Photo> listePhoto = new ArrayList<Photo>(album.getPhotos());

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", album);

		model.put("listePhoto", listePhoto);

		if(request.getParameter("message")!=null){
			model.put("message", request.getParameter("message"));
		}
		return new ModelAndView("photo/affichageAbum", model);
	}


	@RequestMapping(value="/albumPhoto/affichage.do", params="nonVu")
	public ModelAndView affichagePhotosNonVu() {
		List<Photo> listePhoto = this.albumPhotoManager.recupererPhotosNonVu();

		for (Photo photo : listePhoto) {
			this.albumPhotoManager.visionnnageAlbum(photo.getAlbum());
		}

		Map<String, Object> model = new HashMap<String, Object>();
		Album album = new Album();
		album.setTitre("non vu");
		model.put("album", album);

		model.put("listePhoto", listePhoto);

		return new ModelAndView("photo/affichageAbum", model);
	}
	
	@RequestMapping(value="/albumPhoto/affichage.do", params="deleteAlbum")
	public String suppressionAlbum(@RequestParam("deleteAlbum") long idAlbum, HttpServletRequest request) {
		
		Album album = this.albumPhotoManager.recupererAlbum(idAlbum);

		String pathServeur = request.getSession().getServletContext()
				.getRealPath("/");

		this.albumPhotoManager.supprimerAlbum(album, pathServeur);
		
		return "redirect:affichage.do";
	}
	
	@RequestMapping(value="/albumPhoto/affichage.do", params="deletePhoto")
	public String suppressionPhoto(@RequestParam("deletePhoto") long idPhoto,@RequestParam("idAlbum") long idAlbum,  HttpServletRequest request) {
		
		Photo photo = this.albumPhotoManager.recupererPhoto(idPhoto);

		String pathServeur = request.getSession().getServletContext()
				.getRealPath("/");

		this.albumPhotoManager.supprimerPhoto(photo, pathServeur);
		return "redirect:affichage.do?idAlbum="+idAlbum;
	}


}
