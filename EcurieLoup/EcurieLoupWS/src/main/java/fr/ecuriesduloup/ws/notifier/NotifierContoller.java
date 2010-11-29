package fr.ecuriesduloup.ws.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NotifierContoller {

	@Autowired
	private NotifierService notifierService;
 
	@RequestMapping(value = "/status/forum")
	public ModelAndView getStatusForum() {
		Status status = this.notifierService.getForumStatus();
		ModelAndView mav = 
			new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + "forum", status);
		return mav;
	} 
	
	@RequestMapping(value = "/status/photos")
	public ModelAndView getStatusPhotos() {
		Status status = this.notifierService.getAlbumPhotoStatus();
		ModelAndView mav = 
			new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + "photo", status);
		return mav;
	} 
}
