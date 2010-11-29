package fiche_chevaux.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministrationFicheChevalController{

	@RequestMapping("/ficheChevaux/administration/administration.do")
	public String handleRequest(){
		return "ficheChevaux/affichageAdministration";
	}

}
