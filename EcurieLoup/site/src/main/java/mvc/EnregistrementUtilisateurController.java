package mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.User;

@Controller
public class EnregistrementUtilisateurController {
    @Autowired
    @Qualifier("utilisateurManager")
    private UtilisateurManager utilisateurManager;

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    @ModelAttribute("user")
    public User formBackingObject() {
	return new User();
    }

    @RequestMapping(value = "/inscription.do", method = RequestMethod.GET)
    public ModelAndView showForm() {
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("headPageTitle", "Inscription");
	model.put("headPageDescription", "Inscrivez-vous pour accèder aux fonctionnalités des membres.");

	return new ModelAndView("enregistrementUtilisateur", model);
    }

    @RequestMapping(value = "/inscription.do", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("user") User utilisateur, BindingResult result) {
	EnregistrementUtilisateurValidator validator = new EnregistrementUtilisateurValidator();
	validator.setUtilisateurManager(this.utilisateurManager);
	validator.validate(utilisateur, result);
	if (result.hasErrors()) {
	    return "enregistrementUtilisateur";
	}

	this.utilisateurManager.add(utilisateur);
	return "redirect:/login.do";
    }
}
