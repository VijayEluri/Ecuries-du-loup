package mvc.forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;
import forum.service.ForumManager;

@Controller
public class AffichageForumController{
	@Autowired
	@Qualifier("forumManager")
	private ForumManager forumManager;
	@Autowired
	private EdlCode edlCode;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}	
	public void setEdlCode(EdlCode edlCode) {
		this.edlCode = edlCode;
	}

	
	//CATEGORIE
	@RequestMapping(value = "/forum/affichage.do")
	public ModelAndView affichageCategories(){
		List<Categorie> listeCategorie = this.forumManager.getAllCategories();

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		renvoyer.put("listeCategorieForum", listeCategorie);

		return new ModelAndView("forum/visualisationCategorie", renvoyer);
	}
	
	@RequestMapping(value = "/forum/affichage.do", params={"suppression"})
	public String suppressionCategorie(@RequestParam("suppression")int idSuppression) {
		Categorie categorie = this.forumManager.getCategorie(idSuppression);
		this.forumManager.delete(categorie);
		
		return "redirect:affichage.do";
		
	}
	//topics
	
	@RequestMapping(value = "/forum/affichage.do", params={"categorie"})
	public ModelAndView affichageTopics(@RequestParam("categorie")int idCategorie, HttpServletRequest request){	
	
		List<Topic> listeTopics = this.forumManager.getAllTopicCategories(idCategorie);
		Categorie categorie = this.forumManager.getCategorie(idCategorie);

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		renvoyer.put("listeTopicForum", listeTopics);
		renvoyer.put("categorie", categorie);
		renvoyer.put("loginUtilisateurConnecte", request.getUserPrincipal().getName());
		return new ModelAndView("forum/visualisationTopics", renvoyer);
	}
	
	

	
	
	@RequestMapping(value = "/forum/affichage.do", params={"categorie", "suppression"})
	public String suppressionTopic(@RequestParam("suppression")long idSuppression, @RequestParam("categorie")long categorie) {
		Topic topic = this.forumManager.getTopic(idSuppression);
			this.forumManager.delete(topic);
		return "redirect:affichage.do?categorie="+categorie;
	}
	
	@RequestMapping(value = "/forum/affichage.do", params={"categorie", "fermer"})
	public String fermerTopic(@RequestParam("categorie")int categorie, @RequestParam("fermer")long topicAFermer) {
		Topic topicOuvert = this.forumManager.getTopic(topicAFermer);
		this.forumManager.fermerTopic(topicOuvert);
		return "redirect:affichage.do?categorie="+categorie;

	}

	
	@RequestMapping(value = "/forum/affichage.do", params={"categorie", "ouvrir"})
	public String ouvrirTopic(@RequestParam("categorie")int categorie, @RequestParam("ouvrir")long topicAOuvrir) {
		Topic topicOuvert = this.forumManager.getTopic(topicAOuvrir);
		this.forumManager.ouvrirTopic(topicOuvert);
		return "redirect:affichage.do?categorie="+categorie;

	}
//MESSAGE
	
	@RequestMapping(value = "/forum/affichage.do", params={"topic"})
	public ModelAndView affichageMessages(@RequestParam("topic")long idTopic, HttpServletRequest request){

		List<Message> listeMessage = this.forumManager.getAllMessagesTopic(idTopic);
		Topic topic = this.forumManager.getTopic(idTopic);

		 this.forumManager.lectureTopic(topic);

		listeMessage = this.moulinetteEdlCode(listeMessage, request);

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		renvoyer.put("listeMessageForum", listeMessage);
		renvoyer.put("topic", topic);
		renvoyer.put("loginUtilisateurConnecte", request.getUserPrincipal().getName());
		return new ModelAndView("forum/visualisationMessages", renvoyer);
	}

	@RequestMapping(value = "/forum/affichage.do", params={"topic", "suppression"})
	public String suppressionMessage(@RequestParam("suppression")long idSuppression, @RequestParam("topic")long idTopic) {
		Message message = this.forumManager.getMessage(idSuppression);
		this.forumManager.delete(message);
		return "redirect:affichage.do?topic="+idTopic;
		
	}

	private List<Message> moulinetteEdlCode(List<Message> listeAvant, HttpServletRequest request){
		List<Message> listeModifier = new ArrayList<Message>();

		for(Message message : listeAvant){
			Message messageEdlCode = new Message();
			
			messageEdlCode.setAuteur(message.getAuteur());
			messageEdlCode.setDateModification(message.getDateModification());
			messageEdlCode.setDatePostage(message.getDatePostage());
			messageEdlCode.setId(message.getId());
			messageEdlCode.setTopic(message.getTopic());
			String contenuMouline;
			try {
				contenuMouline = this.edlCode.parse(message.getContenu());
			} catch (EdlCodeEncodageException e) {
				contenuMouline = message.getContenu();
			}
			messageEdlCode.setContenu(contenuMouline);

			listeModifier.add(messageEdlCode);
		}

		return listeModifier;
	}
	
	//TOPIC NON LU	
	@RequestMapping(value = "/forum/affichage.do", params={"nonLu"})
	public ModelAndView affichagTopicsNonLu() {
		List<Topic> topicsNonLus = this.forumManager.recupererTopicAvecMessageNonLu();

		Map<String, Object> renvoyer = new HashMap<String, Object>();
		renvoyer.put("listeTopicForum", topicsNonLus);
		Categorie nonLu = new Categorie();
		nonLu.setTitre("non Lu");
		renvoyer.put("categorie",nonLu);
		return new ModelAndView("forum/visualisationTopics", renvoyer);
	}
}
