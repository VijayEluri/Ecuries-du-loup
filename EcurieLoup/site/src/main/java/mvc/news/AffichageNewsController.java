package mvc.news;

import java.util.ArrayList;
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
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;

@Controller
public class AffichageNewsController{
	@Autowired
	@Qualifier("nouvelleManager")
	private NouvelleManager nouvelleManager;
	
	@Autowired
	@Qualifier("vracManager")
	private VracManager vracManager;
	@Autowired
	private EdlCode edlCode;
	
	public void setEdlCode(EdlCode edlCode) {
		this.edlCode = edlCode;
	}
	public void setVracManager(VracManager vracManager) {
		this.vracManager = vracManager;
	}
	public void setNouvelleManager(NouvelleManager nouvelleManager) {
		this.nouvelleManager = nouvelleManager;
	}

	@RequestMapping(value = {"/index.do", "/news/affichageNews.do"})
	public ModelAndView handleRequest(HttpServletRequest request){

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		String pathServeur = request.getContextPath();

		List<Nouvelle> listeNews = this.nouvelleManager.recupererDernieresNouvelles(5);

		listeNews = this.moulinetteEdlCode(listeNews, request);
		renvoyer.put("listeNews", listeNews);

		String edito = "";
		try {
			edito = this.edlCode.parse(this.vracManager.recupererVrac(
					"edito").getContenu(), pathServeur);
		} catch (EdlCodeEncodageException e) {
			e.printStackTrace();
		}
		renvoyer.put("edito", edito);

		return new ModelAndView("news/visualisationNews", renvoyer);
	}
	
	@RequestMapping(value = "/news/show.do", params = "newsId")
	public ModelAndView showNews(HttpServletRequest request, @RequestParam("newsId") long newsId){

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		
		Nouvelle news = this.nouvelleManager.getById(newsId);

		news = this.moulinetteEdlCode(news, request);
		renvoyer.put("news", news);

		

		return new ModelAndView("news/showSingleNew", renvoyer);
	}
	
	
	@RequestMapping(value = {"/index.do", "/news/affichageNews.do"}, params= "deleteNouvelle")
	public ModelAndView handleRequestDelete(@RequestParam("deleteNouvelle") int idNouvelle){
		Nouvelle nouvelle = this.nouvelleManager.getById(idNouvelle);
		this.nouvelleManager.delete(nouvelle);
		
		return new ModelAndView("redirect:/index.do");
	}
			

	

	private List<Nouvelle> moulinetteEdlCode(List<Nouvelle> listeAvant,
			HttpServletRequest request) {
		List<Nouvelle> listeModifier = new ArrayList<Nouvelle>();
		for (Nouvelle nouvelle : listeAvant) {
			listeModifier.add(moulinetteEdlCode(nouvelle, request));	
		}

		return listeModifier;
	}
	
	private Nouvelle moulinetteEdlCode(Nouvelle nouvelle, HttpServletRequest request){
		Nouvelle nouvelleEdlCode = new Nouvelle();
		nouvelleEdlCode.setAuteur(nouvelle.getAuteur());
		nouvelleEdlCode.setDateCreation(nouvelle.getDateCreation());
		nouvelleEdlCode.setDateDerniereModification(nouvelle
				.getDateDerniereModification());
		nouvelleEdlCode.setId(nouvelle.getId());
		nouvelleEdlCode.setTitre(nouvelle.getTitre());

		String contenuMouline;
		try {
			String pathServeur = request.getContextPath();

			contenuMouline = this.edlCode.parse(nouvelle.getContenu(),	pathServeur);
		} catch (EdlCodeEncodageException e) {
			contenuMouline = nouvelle.getContenu();
		}
		nouvelleEdlCode.setContenu(contenuMouline);
		return nouvelleEdlCode;
	}
}
