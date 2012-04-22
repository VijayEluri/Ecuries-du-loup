package fr.ecuriesduloup.ws.user;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import donnees.Role;
import fr.ecuriesduloup.ws.AbstractWsController;

@Controller
public class UserController extends AbstractWsController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/rights")
	public ModelAndView getStatusForum(HttpServletRequest request) {
		Collection<Role> roles = this.userService.getRolesOfConnectedUser();
		ListOfRoles listOfRoles = new ListOfRoles();
		for(Role role : roles){
			listOfRoles.add(role.getRole());
		}
		return this.ChooseView(request, "user", listOfRoles);
	} 
	@RequestMapping(value = "/usershorses",method=RequestMethod.GET)
	public ModelAndView getSuggestListUserAndHorses(HttpServletRequest request){
		List<SuggestListItem> items = this.userService.getItemSuggestList(true, true);
		return this.ChooseView(request, "suggestliste", items);		
	}
	@RequestMapping(value = "/users",method=RequestMethod.GET)
	public ModelAndView getSuggestListUsers(HttpServletRequest request){
		List<SuggestListItem> items = this.userService.getItemSuggestList(false, true);
		return this.ChooseView(request, "suggestliste", items);		
	}
}
