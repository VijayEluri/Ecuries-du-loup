package fr.ecuriesduloup.ws.albumPhoto.tag;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.photo.MediaManager;
import donnees.photo.Media;
import donnees.photo.Tag;
import fr.ecuriesduloup.ws.AbstractWsController;
import fr.ecuriesduloup.ws.Id;

@Controller
public class MediaTagController extends AbstractWsController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	@RequestMapping(value = "/albumPhoto/tag/{media}/{name}",method=RequestMethod.POST)
	public ModelAndView saveTag(HttpServletRequest request, @PathVariable int media, @PathVariable String name, @RequestParam("x")double x, @RequestParam("y")double y) {

		Media tagMedia = this.mediaManager.recupererMedia(media);

		Tag tag = new Tag();
		tag.setNom(name);
		tag.setPhoto(tagMedia);
		tag.setX(x);
		tag.setY(y);

		this.mediaManager.creerTag(tag);
		
		Id id = new Id();
		id.setValue(tag.getId());

		return this.ChooseView(request, "tag", id);
	}
}