package mvc.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.photo.AlbumPhotoManager;
import donnees.photo.Photo;
import donnees.photo.Tag;

@Controller
public class EnregistrementTagAjaxController{
	@Autowired
	@Qualifier("albumPhotoManager")
	private AlbumPhotoManager albumPhotoManager;

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	@RequestMapping("/albumPhoto/tagage.do")
	public String saveTag(@RequestParam("nom")String nom, @RequestParam("x")double x, @RequestParam("y")double y, @RequestParam("photo")long idPhoto) {

		Photo photoTag = this.albumPhotoManager.recupererPhoto(idPhoto);
		
		
		Tag tag = new Tag();
		tag.setNom(nom);
		tag.setPhoto(photoTag);
		tag.setX(x);
		tag.setY(y);

		this.albumPhotoManager.creerTag(tag);

		return "";
	}
	
	@RequestMapping("/albumPhoto/visionneuse.do")
	public String showVisionneuse() {
		return "photo/visionneuse";
	}
}
