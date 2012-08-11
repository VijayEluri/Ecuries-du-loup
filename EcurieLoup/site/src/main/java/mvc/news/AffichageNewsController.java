package mvc.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.VracManager;
import service.news.NouvelleManager;
import donnees.news.Nouvelle;

@Controller
public class AffichageNewsController {
    @Autowired
    @Qualifier("nouvelleManager")
    private NouvelleManager nouvelleManager;

    @Autowired
    @Qualifier("vracManager")
    private VracManager vracManager;

    public void setVracManager(VracManager vracManager) {
	this.vracManager = vracManager;
    }

    public void setNouvelleManager(NouvelleManager nouvelleManager) {
	this.nouvelleManager = nouvelleManager;
    }

    @RequestMapping(value = { "/index.do", "/news/affichageNews.do" })
    public ModelAndView handleRequest(HttpServletRequest request) {

	Map<String, Object> model = new HashMap<String, Object>();

	List<Nouvelle> listeNews = this.nouvelleManager.recupererDernieresNouvelles(5);

	model.put("listeNews", listeNews);

	String edito = this.vracManager.getFormatedVrac("edito").getContenu();

	model.put("edito", edito);
	model.put("headPageTitle", "L'équitation");
	model.put("headPageDescription",
		"Le site du centre équestre des écuries du loup, situé à Saint loup du Dorat en Mayenne (53), vous accueille pour de l'initiation, du perfectionnement, de la compétition à cheval ou à poneys.");

	return new ModelAndView("news/visualisationNews", model);
    }

    @RequestMapping(value = "/news/show.do", params = "newsId")
    public ModelAndView showSigleNews(HttpServletRequest request, @RequestParam("newsId") long newsId) {

	Map<String, Object> model = new HashMap<String, Object>();

	Nouvelle news = this.nouvelleManager.getFormatedNews(newsId);

	model.put("news", news);

	model.put("headPageTitle", news.getTitre());

	return new ModelAndView("news/showSingleNew", model);
    }

    @RequestMapping(value = { "/index.do", "/news/affichageNews.do" }, params = "deleteNouvelle")
    public ModelAndView handleRequestDelete(@RequestParam("deleteNouvelle") int idNouvelle) {
	// TODO : make this javascript + rest
	Nouvelle nouvelle = this.nouvelleManager.getById(idNouvelle);
	this.nouvelleManager.delete(nouvelle);

	return new ModelAndView("redirect:/index.do");
    }

}
