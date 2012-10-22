package fiche_chevaux.mvc;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DurationFieldType;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fiche_chevaux.donnees.Category;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;

@Controller
public class AffichageFicheChevauxControlleur {
    @Autowired
    @Qualifier("ficheChevauxManager")
    private FicheChevauxManager ficheChevauxManager;

    public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
	this.ficheChevauxManager = ficheChevauxManager;
    }

    @RequestMapping("/ficheChevaux/affichageFiche.do")
    public ModelAndView handleRequest(@RequestParam("id") long id) {
	Fiche fiche = this.ficheChevauxManager.recupererFiche(id);

	if ("".equals(fiche.getDescription())) {
	    fiche.setDescription(null);
	}
	while (fiche.getSurnoms().remove(null)) {
	}

	Map<String, Object> model = new HashMap<String, Object>();
	model.put("ficheCheval", fiche);
	Date bd = null;
	if (fiche.getDateNaissance() != 0) {
	    Calendar birthDay = Calendar.getInstance();
	    birthDay.clear();
	    birthDay.setTimeInMillis(fiche.getDateNaissance());

	    bd = birthDay.getTime();

	} else {
	    Calendar firstDayOfBirthYear = Calendar.getInstance();
	    firstDayOfBirthYear.clear();
	    firstDayOfBirthYear.set(fiche.getAnneeNaissance(), 00, 01);
	    bd = firstDayOfBirthYear.getTime();

	}
	Calendar now = Calendar.getInstance();

	Period p = new Period(bd.getTime(), now.getTime().getTime(), PeriodType.yearMonthDay());
	model.put("yearhorseAge", p.get(DurationFieldType.years()));
	model.put("monthhorseAge", p.get(DurationFieldType.months()));
	model.put("dayhorseAge", p.get(DurationFieldType.days()));

	model.put("headPageTitle", fiche.getNom());
	model.put("headPageDescription", fiche.getDescription());

	return new ModelAndView("ficheChevaux/affichageFicheCheval", model);
    }

    @RequestMapping("/ficheChevaux/affichage.do")
    public ModelAndView showFicheList(@RequestParam("id") long id) {
	Category category = this.ficheChevauxManager.getCategory(id);
	List<Fiche> fiches = this.ficheChevauxManager.getHorseCardCategory(id);
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("category", category);
	model.put("fichesChevaux", fiches);
	if (category != null) {
	    model.put("headPageTitle", category.getName());
	} else {
	    model.put("headPageTitle", "non classé");

	}
	return new ModelAndView("ficheChevaux/affichageListeFicheChevaux", model);
    }

    @RequestMapping("/ficheChevaux/categoryslist.do")
    public ModelAndView showCategoryList() {
	List<Category> categorys = this.ficheChevauxManager.getAllCategorys();
	Map<String, Object> model = new HashMap<String, Object>();

	model.put("categorys", categorys);

	model.put("headPageTitle", "Notre cavalerie éclectique");
	return new ModelAndView("ficheChevaux/showHorseCardCategorys", model);
    }

    @RequestMapping(value = "/ficheChevaux/affichage.do", params = "suppression")
    public String deleteFiche(@RequestParam("suppression") long idFiche) {
	// TODO : make this with javascript and REST
	Fiche fiche = this.ficheChevauxManager.recupererFiche(idFiche);
	this.ficheChevauxManager.supprimerFicheChevaux(fiche);
	return "redirect:affichage.do";
    }

}
