package fiche_chevaux.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.service.FicheChevauxManager;
@Controller
public class AdministrationFormulaireSexeFicheChevalController{
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;

	public void setFicheChevauxManager(FicheChevauxManager ficheChevauxManager) {
		this.ficheChevauxManager = ficheChevauxManager;
	}
	@ModelAttribute("choix")
	public Sexe getChoix(HttpServletRequest request){
		String param = request.getParameter("id");
		if (param == null) {
			Sexe sexe = new Sexe();
			return sexe;
		}
		int idSexe = Integer.parseInt(param);
		Sexe sexe = this.ficheChevauxManager.recupererSexe(idSexe);
		return sexe;
	}

	@ModelAttribute("nomChoix")
	public String getChoix(){
		return "Sexe";
	}


	@RequestMapping(value= "/ficheChevaux/administration/formulaireSexe.do", method= RequestMethod.GET)
	public String showChooseForm(){
		return "/ficheChevaux/formulaireChoix";
	}
	
	@RequestMapping(value= "/ficheChevaux/administration/formulaireSexe.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("choix") Sexe sexe){
		if (this.estUneModification(sexe)) {
			this.ficheChevauxManager.modifierSexeCheval(sexe);
		} else {
			this.ficheChevauxManager.creerSexeCheval(sexe);
		}

		return "redirect:choixSexe.do";
	}

	private boolean estUneModification(Sexe sexe) {
		return sexe.getId() != 0;
	}
}
