package mvc.forum.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministrationForumController{

	@RequestMapping("/forum/administration/administration.do")
	public String handleRequest(){
		return "forum/administration/forumAdministration";
	}
}
