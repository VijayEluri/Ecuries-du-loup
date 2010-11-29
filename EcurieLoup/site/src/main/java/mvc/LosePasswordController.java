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
import fr.ecuriesduloup.ecurieLoup.email.service.user.SendEmailUser;

@Controller
public class LosePasswordController{
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
	public User formBackingObject(){	

		return new User();
	}
	
	@RequestMapping(value = "/passwordLose.do", method = RequestMethod.GET)
	public String showForm(){		
		return "losePassword";
	}

	
	@RequestMapping(value = "/passwordLose.do", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user")User userLosePAsswordInForm, BindingResult result){
		
		new LosePasswordValidator().validate(userLosePAsswordInForm, result);
		if(result.hasErrors()){
			return "losePassword";
		}
		User userLosePAsswordFull = this.utilisateurManager.getById(userLosePAsswordInForm.getId());
		if(userLosePAsswordFull!=null){
			this.sendEmailUser.sendEmailLosePassword(userLosePAsswordFull);
		}
		return "redirect:/login.do";

	}
}
