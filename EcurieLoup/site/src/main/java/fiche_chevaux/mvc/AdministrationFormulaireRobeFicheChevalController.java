package fiche_chevaux.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiche_chevaux.donnees.Robe;
import fiche_chevaux.service.FicheChevauxManager;
@Controller
public class AdministrationFormulaireRobeFicheChevalController {
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}
	@ModelAttribute("choix")
	public Robe formBackingObject(HttpServletRequest request)
			throws ServletException {
		String param = request.getParameter("id");
		if (param == null) {
			Robe robe = new Robe();
			return robe;
		}
		int idRobe = Integer.parseInt(param);
		Robe robe = this.ficheChevauxManager.recupererRobe(idRobe);
		return robe;
	}

	@ModelAttribute("nomChoix")
	public String getChoix(){
		return "Robe";
	}
	

	@RequestMapping(value= "/ficheChevaux/administration/formulaireRobe.do", method= RequestMethod.GET)
	public String showChooseForm(){
		return "/ficheChevaux/formulaireChoix";
	}

	@RequestMapping(value= "/ficheChevaux/administration/formulaireRobe.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("choix") Robe robe){
		if (this.estUneModification(robe)) {
			this.ficheChevauxManager.modifierRobeCheval(robe);
		} else {
			this.ficheChevauxManager.creerRobeCheval(robe);
		}

		return  "redirect:choixRobe.do";
	}

	private boolean estUneModification(Robe robe) {
		return robe.getId() != 0;
	}
}
