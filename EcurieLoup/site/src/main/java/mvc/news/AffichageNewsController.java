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
public class AffichageNewsController{
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

	@RequestMapping(value = {"/index.do", "/news/affichageNews.do"})
	public ModelAndView handleRequest(HttpServletRequest request){

		Map<String, Object> renvoyer = new HashMap<String, Object>();

		List<Nouvelle> listeNews = this.nouvelleManager.recupererDernieresNouvelles(5);

		renvoyer.put("listeNews", listeNews);

		String edito = this.vracManager.getFormatedVrac("edito").getContenu();
		
		renvoyer.put("edito", edito);

		return new ModelAndView("news/visualisationNews", renvoyer);
	}
	
	@RequestMapping(value = "/news/show.do", params = "newsId")
	public ModelAndView showNews(HttpServletRequest request, @RequestParam("newsId") long newsId){

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		
		Nouvelle news = this.nouvelleManager.getFormatedNews(newsId);

		renvoyer.put("news", news);

		

		return new ModelAndView("news/showSingleNew", renvoyer);
	}
	
	
	@RequestMapping(value = {"/index.do", "/news/affichageNews.do"}, params= "deleteNouvelle")
	public ModelAndView handleRequestDelete(@RequestParam("deleteNouvelle") int idNouvelle){
		Nouvelle nouvelle = this.nouvelleManager.getById(idNouvelle);
		this.nouvelleManager.delete(nouvelle);
		
		return new ModelAndView("redirect:/index.do");
	}
			

	

	
}
