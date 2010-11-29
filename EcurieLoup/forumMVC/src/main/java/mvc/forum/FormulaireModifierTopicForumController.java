package mvc.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forum.donnees.Topic;
import forum.service.ForumManager;

@Controller
public class FormulaireModifierTopicForumController{
	@Autowired
	@Qualifier("forumManager")
	private ForumManager forumManager;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}


	@ModelAttribute("topic")
	public Topic formBackingObject(@RequestParam("topic") int idTopic) {
		return this.forumManager.getTopic(idTopic);
	}
	
	@RequestMapping(value="/forum/formulaireTopicModifier.do", method=RequestMethod.GET)
	public String showForm(){
		return "/forum/formulaireTopicModifier";
	}

	@RequestMapping(value="/forum/formulaireTopicModifier.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("topic")Topic topic){
		this.forumManager.update(topic);

		return "redirect:affichage.do?categorie="+topic.getCategorie().getId();
	}
}
