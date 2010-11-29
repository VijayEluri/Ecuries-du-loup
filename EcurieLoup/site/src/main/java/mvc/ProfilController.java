package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UtilisateurManager;
import donnees.User;

@Controller
public class ProfilController{
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@ModelAttribute("profil")
	public User formBackingObject(){
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		System.out.println(utilisateur);
		return utilisateur;
	}

	@RequestMapping(value= "/compte/profil.do", method= RequestMethod.GET)
	public String showForm(){
		return "/compte/profil";
	
	}
	
	@RequestMapping(value= "/compte/profil.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("profil")User user, BindingResult result){
		new ProfilValidateur().validate(user, result);
		if(!result.hasErrors()){
			this.utilisateurManager.update(user);
		}
		return "/compte/profil";
	}
}