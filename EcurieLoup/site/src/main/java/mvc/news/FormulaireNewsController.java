package mvc.news;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import service.news.NouvelleManager;
import service.smiley.SmileyManager;
import donnees.User;
import donnees.news.Nouvelle;
import donnees.smiley.CategorieSmiley;

@Controller
public class FormulaireNewsController {
    @Autowired
    @Qualifier("nouvelleManager")
    private NouvelleManager nouvelleManager;
    @Autowired
    @Qualifier("utilisateurManager")
    private UtilisateurManager utilisateurManager;
    @Autowired
    @Qualifier("smileyManager")
    private SmileyManager smileyManager;

    public void setSmileyManager(SmileyManager smileyManager) {
	this.smileyManager = smileyManager;
    }

    public void setNouvelleManager(NouvelleManager nouvelleManager) {
	this.nouvelleManager = nouvelleManager;
    }

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    @ModelAttribute("nouvelle")
    public Nouvelle formBackingObject(HttpServletRequest request) throws ServletException {
	String param = request.getParameter("idNouvelle");
	if (param == null) {
	    return new Nouvelle();
	}

	int idNouvelle = Integer.parseInt(param);
	Nouvelle nouvelle = this.nouvelleManager.getById(idNouvelle);

	return nouvelle;
    }

    @ModelAttribute("categoriesSmiley")
    public List<CategorieSmiley> referenceDataCategoriesSmiley() {
	return this.smileyManager.recupererToutesLesCategoriesSmiley();
    }

    @RequestMapping(value = "/administration/news/formulaireNews.do", method = RequestMethod.GET)
    public ModelAndView showForm() {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("headPageTitle", "formulaire de news");

	return new ModelAndView("/news/formulaireNews", model);
    }

    @RequestMapping(value = "/administration/news/formulaireNews.do", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("nouvelle") Nouvelle nouvelle, BindingResult result) {

	if (this.estUneModificationNouvelle(nouvelle)) {
	    nouvelle.setDateDerniereModification(new Date().getTime());
	    this.nouvelleManager.update(nouvelle);
	} else {
	    User utilisateurCourant = this.utilisateurManager.getUtilisateurCourant();
	    nouvelle.setAuteur(utilisateurCourant);
	    nouvelle.setDateCreation(new Date().getTime());

	    this.nouvelleManager.add(nouvelle);
	}

	return new ModelAndView("redirect:/index.do");
    }

    private boolean estUneModificationNouvelle(Nouvelle nouvelle) {
	return nouvelle.getId() != 0;
    }
}
