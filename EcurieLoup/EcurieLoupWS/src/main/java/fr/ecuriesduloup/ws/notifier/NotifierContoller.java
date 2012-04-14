package fr.ecuriesduloup.ws.notifier;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.ecuriesduloup.ws.AbstractWsController;


@Controller
public class NotifierContoller extends AbstractWsController{

	@Autowired
	private NotifierService notifierService;
 
	@RequestMapping(value = "/status/forum")
	public ModelAndView getStatusForum(HttpServletRequest request) {
		Status status = this.notifierService.getForumStatus();		
		return this.ChooseView(request, "forum", status);
	} 
	
	@RequestMapping(value = "/status/photos")
	public ModelAndView getStatusPhotos(HttpServletRequest request) {
		Status status = this.notifierService.getAlbumPhotoStatus();
		return this.ChooseView(request, "photo", status);
	} 
}
