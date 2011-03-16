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

import com.google.code.facebookapi.schema.Photo;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.PhotoNouvelle;
@Controller
public class FormulaireNouvellePhotoAlbumPhotoController{
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
	public PhotoNouvelle formBackingObject(HttpServletRequest request){
		String param = request.getParameter("album");

		int idAlbum = Integer.parseInt(param);

		PhotoNouvelle photoNouvelle = new PhotoNouvelle();
		photoNouvelle.setAlbum(idAlbum);

		return photoNouvelle;
	}

	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder){
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	@RequestMapping(value= "/albumPhoto/formulaireNouvellePhoto.do", method=RequestMethod.GET)
	public String showForm(){
		return "photo/formulaireAjoutPhoto";
	}
	
	@RequestMapping(value= "/albumPhoto/formulaireNouvellePhoto.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("photo") PhotoNouvelle nouvellePhoto, BindingResult result, HttpServletRequest request){
		if (nouvellePhoto.getFichier() != null) {

			return this.ajoutPhotoSimple(nouvellePhoto, result, request);
		} else {
			return this.ajoutPhotoZip(nouvellePhoto, result, request);
		}


	}

	private String ajoutPhotoSimple(PhotoNouvelle nouvellePhoto, BindingResult result, HttpServletRequest request){
		Media photo = null;

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile fichier = multipartRequest.getFile("fichier");

		photo = this.construirePhoto(nouvellePhoto);
		photo.setTypeAdding("form");
		if (fichier.isEmpty()) {
			// TODO : voir pk sa affiche pas l'erreur
			result.rejectValue("fichier", "", "Fichier vide");
			return this.showForm();

		}

		if(!this.isSupportedPicture(fichier)){
			result.rejectValue("fichier", "", "Ce n'est pas une image.");
			return this.showForm();
		}
		String chemin = "tmp";
		chemin += this.utilisateurManager.getUtilisateurCourant().getLogin();
		chemin += "_" + new Date().getTime();
		chemin += (int) (Math.random() * 10000);

		File temporaire = new File(chemin);
		try {
			fichier.transferTo(temporaire);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathPhoto = request.getSession().getServletContext()
		.getRealPath("/");

		this.mediaManager.creerMedia(photo, temporaire, pathPhoto);

		temporaire.delete();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", "album_photo.photo.zip.notification_message.add_photo");
		//TODO : remettre le message
		return "redirect:affichage.do?idAlbum="+ nouvellePhoto.getAlbum();
	}

	private boolean isSupportedPicture(MultipartFile compressezFile){
		String extention = compressezFile.getContentType();

		return extention.startsWith("image/");
	}

	private Media construirePhoto(PhotoNouvelle photoNouvelle) {
		Album album = this.mediaManager.recupererAlbum(photoNouvelle
				.getAlbum());
		User posteur = this.utilisateurManager.getUtilisateurCourant();

		Media photo = new Media();
		photo.setAlbum(album);
		photo.setDescription(photoNouvelle.getDescription());
		photo.setPosteur(posteur);
		photo.setDatePostage(new Date().getTime());

		return photo;
	}

	private String ajoutPhotoZip(PhotoNouvelle nouvellePhoto, BindingResult result, HttpServletRequest request){

	
		final Media photo = this.construirePhoto(nouvellePhoto);
		photo.setTypeAdding("zip");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile fichierZip = multipartRequest.getFile("zip");

		if (fichierZip.isEmpty()) {
			result.rejectValue("zip", "", "Pas de zip");
			return this.showForm();
		}
		if(!this.isSupportedCompressedFile(fichierZip)){
			result.rejectValue("zip", "", "Fichier compresser non supporté.");
			return this.showForm();
		}

		String chemin = fichierZip.getOriginalFilename() + "_tmpZip";
		chemin += "_" + new Date().getTime();
		chemin += (int) (Math.random() * 10000);

		final File temporaire = new File(chemin + "temporaire.zip");
		try {
			fichierZip.transferTo(temporaire);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final User posteur = this.utilisateurManager.getUtilisateurCourant();

		final String pathServeur = request.getSession().getServletContext()
		.getRealPath("/");

		Executors.newCachedThreadPool().execute(new Runnable() {

			@Override
			public void run() {
				mediaManager.creerZipMedia(temporaire, photo.getAlbum(),posteur, pathServeur);
				temporaire.delete();
			}
		});


		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", "album_photo.photo.zip.notification_message.add_zip_photo");
		//TODO : remettre le message
		return "redirect:affichage.do?idAlbum="+ nouvellePhoto.getAlbum();


	}

	private boolean isSupportedCompressedFile(MultipartFile compressezFile){
		String extention = compressezFile.getContentType();

		return extention.equals("application/zip");
	}
}
