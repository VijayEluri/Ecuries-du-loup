package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.news.NouvelleManager;
import donnees.news.Nouvelle;

@Controller
public class RssController {

    @Autowired
    @Qualifier("nouvelleManager")
    private NouvelleManager nouvelleManager;

    public void setNouvelleManager(NouvelleManager nouvelleManager) {
	this.nouvelleManager = nouvelleManager;
    }

    @RequestMapping(value = "/rssfeed.do", method = RequestMethod.GET)
    public ModelAndView getFeedInRss(HttpServletRequest request) {

	List<Nouvelle> items = this.nouvelleManager.recupererDernieresNouvelles(5);

	ModelAndView mav = new ModelAndView();
	mav.setViewName("rssViewer");
	mav.addObject("feedContent", items);

	return mav;
    }

}
