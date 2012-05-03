package fr.ecuriesduloup.ws.albumPhoto.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import service.photo.MediaManager;
import donnees.User;
import donnees.photo.Media;
import donnees.photo.Tag;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;
import fr.ecuriesduloup.ws.AbstractWsController;
import fr.ecuriesduloup.ws.Id;

@Controller
public class MediaTagController extends AbstractWsController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;

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

	@RequestMapping(value = "/albumPhoto/tag/{mediaId}/tags",method=RequestMethod.GET)
	public ModelAndView getAllTagMedia(HttpServletRequest request, @PathVariable long mediaId) {

		Media media = this.mediaManager.recupererMedia(mediaId);
		tagsManagement(media);
		
		List<Tag> mediasTag = media.getTags();
		List<TagDto> mediasTagDto = new ArrayList<TagDto>();	
		for(Tag tag : mediasTag){
			mediasTagDto.add(new TagDto(tag));
		}
		return this.ChooseView(request, "tags", mediasTagDto);
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
}
