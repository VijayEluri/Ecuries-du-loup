package mvc.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.photo.MediaManager;
import donnees.photo.Media;
import donnees.photo.Tag;

@Controller
public class EnregistrementTagAjaxController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	@RequestMapping("/albumPhoto/tagage.do")
	public String saveTag(@RequestParam("nom")String nom, @RequestParam("x")double x, @RequestParam("y")double y, @RequestParam("photo")long idPhoto) {

		Media photoTag = this.mediaManager.recupererMedia(idPhoto);
		
		
		Tag tag = new Tag();
		tag.setNom(nom);
		tag.setPhoto(photoTag);
		tag.setX(x);
		tag.setY(y);

		this.mediaManager.creerTag(tag);

		return "";
	}
	
	@RequestMapping("/albumPhoto/visionneuse.do")
	public String showVisionneuse() {
		return "photo/visionneuse";
	}
}
