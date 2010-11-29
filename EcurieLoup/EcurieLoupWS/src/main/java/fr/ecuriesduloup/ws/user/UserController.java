package fr.ecuriesduloup.ws.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import donnees.Role;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/rights")
	public ModelAndView getStatusForum() {
		Collection<Role> roles = this.userService.getRolesOfConnectedUser();
		ListOfRoles listOfRoles = new ListOfRoles();
		for(Role role : roles){
			listOfRoles.add(role.getRole());
		}
		ModelAndView mav = 
			new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + "user", listOfRoles);
		return mav;
	} 
}
