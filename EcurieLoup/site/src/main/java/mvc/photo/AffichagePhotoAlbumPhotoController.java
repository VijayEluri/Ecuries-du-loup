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
import service.photo.MediaManager;
import donnees.User;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;
@Controller
public class AffichagePhotoAlbumPhotoController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;
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

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}



	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}

	@ModelAttribute("photo")
	protected Media formBackingObject(HttpServletRequest request) {
		long idPhoto = Long.parseLong(request.getParameter("idPhoto"));
		Media photo = this.mediaManager.recupererMedia(idPhoto);


		this.tagsManagement(photo);

		List<Commentaire> nouvelleList = new ArrayList<Commentaire>();

		for (Commentaire commentaire : photo.getCommentaires()) {
			if (commentaire != null) {
				try {
					commentaire.setContenu(this.edlCode.parse(commentaire.getContenu()));
				} catch (EdlCodeEncodageException e) {
					e.printStackTrace();
				}

				nouvelleList.add(commentaire);

			}

		}
		photo.setCommentaires(nouvelleList);

		return photo;
	}

	private void tagsManagement(Media photo){
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
	public Media getPhotoPrecedente(@RequestParam("idPhoto") long idPhoto ){
		Media photo = this.mediaManager.recupererMedia(idPhoto);
		List<Media> photos = photo.getAlbum().getMedias();
		int indexPhoto = photos.indexOf(photo);

		if (indexPhoto > 0) {
			Media photoPrecedente = photos.get(indexPhoto - 1);
			return photoPrecedente;
		} else {
			return null;
		}
	}

	@ModelAttribute("photoSuivante")
	public Media getPhotoSuivante(@RequestParam("idPhoto") long idPhoto ){
		Media photo = this.mediaManager.recupererMedia(idPhoto);
		List<Media> photos = photo.getAlbum().getMedias();
		int indexPhoto = photos.indexOf(photo);

		if (indexPhoto + 1 < photos.size()) {
			Media photoSuivante = photos.get(indexPhoto + 1);
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
	public String onSubmit(@ModelAttribute("photo")Media photo) {
		this.mediaManager.modifierMedia(photo);

		return this.showForm();

	}
}
