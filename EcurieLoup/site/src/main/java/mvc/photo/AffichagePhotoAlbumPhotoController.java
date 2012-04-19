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

	@ModelAttribute("searchtagParameter")
	protected String getParams(HttpServletRequest request) {

		String params = request.getParameter("searchtag");
		if(params != null){
			return "&searchtag="+params;
		}
		return "";
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
	public Media getPreviousMediaSpecific(@RequestParam("idPhoto") long mediaId, @RequestParam( value = "searchtag", required=false)  String searchtag){
		return returnDeltaMedia(mediaId, searchtag, -1);

	}
	@ModelAttribute("photoSuivante")
	public Media getNextMedia(@RequestParam("idPhoto") long mediaId, @RequestParam( value = "searchtag", required=false)  String searchtag){
		return returnDeltaMedia(mediaId, searchtag, +1);
	}

	private Media returnDeltaMedia(long mediaId, String searchtag, int delta){
		if(searchtag != null){
			return getDeltaMediaInTagAlbum(mediaId, searchtag, delta);
		}else{
			return getDeltaMediaInMediaAlbum(mediaId, delta);

		}
	}

	public Media getDeltaMediaInTagAlbum(long mediaId, String userLogin, int delta){
		User user = this.utilisateurManager.getById(userLogin);
		if(user != null){
			List<Media> photos = this.mediaManager.getTagContent(user);
			int indexPhoto = searchIndex(photos, mediaId);
			return returnDeltaMedia(photos, indexPhoto, delta);
		}else{
			try{
				long horseId = Long.parseLong(userLogin);
				List<Media> photos = this.mediaManager.getTagContent(horseId);
				int indexPhoto = searchIndex(photos, mediaId);
				return returnDeltaMedia(photos, indexPhoto, delta);
			}catch (NumberFormatException e) {
				return null;
			}
		}
	}
	private int searchIndex(List<Media> medias, long mediaId){
		int index = -1;
		for(int i = 0; i < medias.size(); i++){
			if(medias.get(i).getId() == mediaId){
				index = i;
				break;
			}
		}		
		return index;
	}
	private Media returnDeltaMedia(List<Media> photos, int indexPhoto, int delta){
		int deltaMedia = indexPhoto +delta;
		if (deltaMedia >= 0 && deltaMedia < photos.size()) {
			return photos.get(deltaMedia);
		} else {
			return null;
		}
	}


	public Media getDeltaMediaInMediaAlbum(long idPhoto, int delta){
		Media photo = this.mediaManager.recupererMedia(idPhoto);
		List<Media> photos = photo.getAlbum().getMedias();
		int indexPhoto = photos.indexOf(photo);
		return returnDeltaMedia(photos, indexPhoto, delta);
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
