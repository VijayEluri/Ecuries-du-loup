package mvc.photo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import service.UtilisateurManager;
import service.photo.MediaManager;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.AlbumLight;
@Controller
public class FormulaireAlbumAlbumPhotoController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;
	
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	private String pathPhotoInProjet;
	
	
	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setPathPhotoInProjet(String pathPhotoInProjet) {
		this.pathPhotoInProjet = pathPhotoInProjet;
	}

	@ModelAttribute("album")
	public AlbumLight formBackingObject(HttpServletRequest request) {
		String param = request.getParameter("album");
		if (param == null)
			return new AlbumLight();

		int idAlbum = Integer.parseInt(param);
		Album album = this.mediaManager.recupererAlbum(idAlbum);

		AlbumLight albumLight = new AlbumLight();
		albumLight.setId(album.getId());
		albumLight.setTitre(album.getTitre());
		return albumLight;
	}

	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		binder.registerCustomEditor(byte[].class,new ByteArrayMultipartFileEditor());
	}
	@RequestMapping(value="/albumPhoto/formulaireAlbum.do", method=RequestMethod.GET)
	public String showForm(){
		return "photo/formulaireAlbum";
	}
	@RequestMapping(value="/albumPhoto/formulaireAlbum.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("album") AlbumLight albumLight,BindingResult result, HttpServletRequest request){

		new AlbumPhotoValidateur().validate(albumLight, result);
		
		if(result.hasErrors()){
			return this.showForm();
		}
		Album album = null;
		if (this.estUneModificationAlbum(albumLight)) {
			album = this.mediaManager.recupererAlbum(albumLight.getId());
			album.setTitre(albumLight.getTitre());

			this.mediaManager.modifierAlbum(album);
		} else {
			album = new Album();
			album.setTitre(albumLight.getTitre());
			this.mediaManager.creerAlbum(album);
		}
		
		return "redirect:affichage.do?idAlbum="+album.getId();
	}

	private boolean estUneModificationAlbum(AlbumLight album) {
		return album.getId() != 0;
	}

}
