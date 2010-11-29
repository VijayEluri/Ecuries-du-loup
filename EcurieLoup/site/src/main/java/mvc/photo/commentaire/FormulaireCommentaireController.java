package mvc.photo.commentaire;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UtilisateurManager;
import service.photo.AlbumPhotoManager;
import service.smiley.SmileyManager;
import donnees.photo.Photo;
import donnees.photo.commentaire.Commentaire;
import donnees.smiley.CategorieSmiley;

@Controller
public class FormulaireCommentaireController{
	@Autowired
	@Qualifier("albumPhotoManager")
	private AlbumPhotoManager albumPhotoManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;
	@Autowired
	private PhotoEditor photoEditor;

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}

	public void setPhotoEditor(PhotoEditor photoEditor) {
		this.photoEditor = photoEditor;
	}

	@InitBinder
	public void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

		binder.registerCustomEditor(Photo.class, this.photoEditor);
	}

	@ModelAttribute("commentaire")
	public Commentaire formBackingObject(@RequestParam(value="commentaire", required=false)String paramCommentaire, @RequestParam(value="photo", required=false)String paramPhoto)
			throws ServletException {

		if ((paramCommentaire == null) && (paramPhoto != null)) {
			Commentaire commentaire = new Commentaire();

			long idPhoto = Integer.parseInt(paramPhoto);
			commentaire.setPhoto(this.albumPhotoManager.recupererPhoto(idPhoto));

			return commentaire;
		}

		if (paramCommentaire != null) {
			int idCommentaire = Integer.parseInt(paramCommentaire);
			Commentaire commentaire = this.albumPhotoManager
					.recupererCommentaire(idCommentaire);

			return commentaire;
		}
		return null;
	}

	@ModelAttribute("categoriesSmiley")
	public List<CategorieSmiley> referenceData() {
		return  smileyManager.recupererToutesLesCategoriesSmiley();
	}

	@RequestMapping(value="/albumPhoto/formulaireCommentaire.do", method=RequestMethod.GET)
	public String showForm(){
		return "photo/formulaireCommentaire";
	}
	
	@RequestMapping(value="/albumPhoto/formulaireCommentaire.do", method=RequestMethod.POST)
	public String onSubmit(Commentaire commentaire){


		if (this.estUneModificationAlbum(commentaire)) {
			this.albumPhotoManager.modifierCommentaire(commentaire);
		} else {

			commentaire.setDate(new Date().getTime());
			commentaire.setPosteur(this.utilisateurManager
					.getUtilisateurCourant());
			this.albumPhotoManager.creerCommentaire(commentaire);
		}
		return "redirect:affichagePhoto.do?idPhoto="+ commentaire.getPhoto().getId();

	}

	private boolean estUneModificationAlbum(Commentaire commentaire) {
		return commentaire.getId() != 0;
	}
}