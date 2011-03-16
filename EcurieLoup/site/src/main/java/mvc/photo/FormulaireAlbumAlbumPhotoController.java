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
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		if (albumLight.getTitre() != null) {
			if (this.estUneModificationAlbum(albumLight)) {
				Album album = this.mediaManager.recupererAlbum(albumLight.getId());
				album.setTitre(albumLight.getTitre());

				this.mediaManager.modifierAlbum(album);
			} else {
				Album album = new Album();
				album.setTitre(albumLight.getTitre());
				this.mediaManager.creerAlbum(album);
			}
		} else {

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

			final String pathPhoto = request.getSession().getServletContext()
					.getRealPath("/");
			Executors.newCachedThreadPool().execute(new Runnable() {
				
				@Override
				public void run() {
					mediaManager.creerAlbum(temporaire, posteur, pathPhoto);
					temporaire.delete();
				}
			});
			model.put("message", "album_photo.photo.zip.notification_message.add_zip_album");
		}
		//TODO : ajouté le message !!
		return "redirect:affichage.do";
	}

	private boolean estUneModificationAlbum(AlbumLight album) {
		return album.getId() != 0;
	}
	
	private boolean isSupportedCompressedFile(MultipartFile compressezFile){
		String extention = compressezFile.getContentType();
		
		return extention.equals("application/zip");
	}

}
