package mvc.photo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UtilisateurManager;
import service.photo.AlbumPhotoManager;
import donnees.User;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;
@Controller
public class AffichagePhotoAlbumPhotoController{
	@Autowired
	@Qualifier("albumPhotoManager")
	private AlbumPhotoManager albumPhotoManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;
	@Autowired
	private EdlCode edlCode;

	public void setEdlCode(EdlCode edlCode) {
		this.edlCode = edlCode;
	}

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	
	
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}

	@ModelAttribute("photo")
	protected Photo formBackingObject(HttpServletRequest request) {
		long idPhoto = Long.parseLong(request.getParameter("idPhoto"));
		Photo photo = this.albumPhotoManager.recupererPhoto(idPhoto);
		
		
		this.tagsManagement(photo);
		
		List<Commentaire> nouvelleList = new ArrayList<Commentaire>();

		for (Commentaire commentaire : photo.getCommentaires()) {
			if (commentaire != null) {
				try {
					String pathServeur = request.getContextPath();
					commentaire.setContenu(this.edlCode.parse(commentaire
							.getContenu(), pathServeur));
				} catch (EdlCodeEncodageException e) {
					e.printStackTrace();
				}

				nouvelleList.add(commentaire);

			}

		}
		photo.setCommentaires(nouvelleList);

		return photo;
	}
	
	private void tagsManagement(Photo photo){
		for(Tag tag : photo.getTags()){
			//TODO : trop laid , changer sa 
			try{
				long idHorse = Long.parseLong(tag.getNom());
				
				Fiche fiche = this.ficheChevauxManager.recupererFiche(idHorse);
				if(fiche != null){
					tag.setPath("/ficheChevaux/affichageFiche.do?id="+idHorse);
					tag.setDisplay(fiche.getNom());
				}else{
					tag.setDisplay(tag.getNom());
				}
			}catch (NumberFormatException e) {
				User user = this.utilisateurManager.getById(tag.getNom());
				if(user != null){
					tag.setPath("/community/card.do?login="+user.getLogin());
					tag.setDisplay(user.getLogin()+" ("+user.getPrenom()+" "+user.getNom()+")");
				}else{
					tag.setDisplay(tag.getNom());
				}
			}
		}
		
	}

	@ModelAttribute("photoPrecedente")
	public Photo getPhotoPrecedente(@RequestParam("idPhoto") long idPhoto ){
		Photo photo = this.albumPhotoManager.recupererPhoto(idPhoto);
		List<Photo> photos = photo.getAlbum().getPhotos();
		int indexPhoto = photos.indexOf(photo);

		if (indexPhoto > 0) {
			Photo photoPrecedente = photos.get(indexPhoto - 1);
			return photoPrecedente;
		} else {
			return null;
		}
	}
	
	@ModelAttribute("photoSuivante")
	public Photo getPhotoSuivante(@RequestParam("idPhoto") long idPhoto ){
		Photo photo = this.albumPhotoManager.recupererPhoto(idPhoto);
		List<Photo> photos = photo.getAlbum().getPhotos();
		int indexPhoto = photos.indexOf(photo);

		if (indexPhoto + 1 < photos.size()) {
			Photo photoSuivante = photos.get(indexPhoto + 1);
			return  photoSuivante;
		} else {
			return null;
		}
	}
	
	

	@RequestMapping(value="/albumPhoto/affichagePhoto.do", method=RequestMethod.GET)
	public String showForm(){
		return "photo/affichagePhoto";
	}
	
	@RequestMapping(value="/albumPhoto/affichagePhoto.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("photo")Photo photo) {
		this.albumPhotoManager.modifierPhoto(photo);
		
		return this.showForm();

	}
}
