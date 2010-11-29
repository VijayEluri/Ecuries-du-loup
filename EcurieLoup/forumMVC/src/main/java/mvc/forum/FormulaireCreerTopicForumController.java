package mvc.forum;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UtilisateurManager;
import service.smiley.SmileyManager;
import donnees.User;
import donnees.smiley.CategorieSmiley;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;
import forum.donnees.TopicNouveau;
import forum.service.ForumManager;
@Controller
public class FormulaireCreerTopicForumController{
	@Autowired
	@Qualifier("forumManager")
	private ForumManager forumManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}
	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}


	@ModelAttribute("topic")
	public TopicNouveau getTopic(HttpServletRequest request){
		String param = request.getParameter("categorie");

		int idCategorie = Integer.parseInt(param);
		Categorie categorie = this.forumManager.getCategorie(idCategorie);

		TopicNouveau topic = new  TopicNouveau();
		topic.setIdCategorie(categorie.getId());

		return topic;
	}

	@ModelAttribute("categoriesSmiley")
	public List<CategorieSmiley> getCategorieSmiley(HttpServletRequest request) throws Exception {
		return  this.smileyManager.recupererToutesLesCategoriesSmiley();
	}

	@RequestMapping(value="/forum/formulaireTopicCreer.do", method=RequestMethod.GET)
	public String showForm(){
		return "forum/formulaireTopicCreer";
	}
	
	@RequestMapping(value="/forum/formulaireTopicCreer.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("topic")TopicNouveau topicNouveau, BindingResult result){
		
		new CreationTopicForumValidateur().validate(topicNouveau, result);
		if(result.hasErrors()){
			return this.showForm();
		}

		this.enregistementTopicEtMessage(topicNouveau);

		return "redirect:affichage.do?categorie="+topicNouveau.getIdCategorie();
	}

	private void enregistementTopicEtMessage(TopicNouveau topicNouveau){
		User createur = this.utilisateurManager.getUtilisateurCourant();

		Topic topic = new Topic();
		Categorie categorie = this.forumManager.getCategorie(topicNouveau.getIdCategorie());
		topic.setCategorie(categorie);
		topic.setTitre(topicNouveau.getTitre());
		topic.setCreateur(createur);
		topic.setOuvert(true);

		Message message = new Message();
		message.setAuteur(createur);
		message.setContenu(topicNouveau.getContenu());
		message.setDatePostage(new Date().getTime());
		message.setTopic(topic);

		this.forumManager.add(topic, message);

	}
}
