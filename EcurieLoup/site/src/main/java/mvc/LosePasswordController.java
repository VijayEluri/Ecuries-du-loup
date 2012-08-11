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
import fr.ecuriesduloup.ecurieLoup.email.service.user.SendEmailUser;

@Controller
public class LosePasswordController {
    @Autowired
    @Qualifier("utilisateurManager")
    private UtilisateurManager utilisateurManager;
    @Autowired
    private SendEmailUser sendEmailUser;

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    public void setSendEmailUser(SendEmailUser sendEmailUser) {
	this.sendEmailUser = sendEmailUser;
    }

    @ModelAttribute("user")
    public User formBackingObject() {

	return new User();
    }

    @RequestMapping(value = "/passwordLose.do", method = RequestMethod.GET)
    public ModelAndView showForm() {
	Map<String, Object> model = new HashMap<String, Object>();

	model.put("headPageTitle", "Mot de passe perdu");
	model.put("headPageDescription", "Retrouvez votre mot de passe oublié ou perdu.");
	return new ModelAndView("losePassword", model);
    }

    @RequestMapping(value = "/passwordLose.do", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("user") User userLosePAsswordInForm, BindingResult result) {

	new LosePasswordValidator().validate(userLosePAsswordInForm, result);
	if (result.hasErrors()) {
	    return "losePassword";
	}
	User userLosePAsswordFull = this.utilisateurManager.getById(userLosePAsswordInForm.getId());
	if (userLosePAsswordFull != null) {
	    this.sendEmailUser.sendEmailLosePassword(userLosePAsswordFull);
	}
	return "redirect:/login.do";

    }
}
