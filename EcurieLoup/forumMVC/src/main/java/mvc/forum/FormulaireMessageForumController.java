package mvc.forum;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UtilisateurManager;
import service.smiley.SmileyManager;
import donnees.smiley.CategorieSmiley;
import forum.donnees.Message;
import forum.donnees.MessageLight;
import forum.donnees.Topic;
import forum.service.ForumManager;

@Controller
public class FormulaireMessageForumController{
	@Autowired
	@Qualifier("forumManager")
	private ForumManager forumManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}



	@ModelAttribute("message")
	public MessageLight formBackingObject(HttpServletRequest request) {
		String param = request.getParameter("message");
		if(param==null){
			Message message =  new Message();

			int idTopic = Integer.parseInt(request.getParameter("topic"));
			Topic topic = this.forumManager.getTopic(idTopic);
			message.setTopic(topic); 


			MessageLight messageLight = new MessageLight();
			messageLight.setId(message.getId());
			messageLight.setTopic(message.getTopic().getId());
			messageLight.setContenu(message.getContenu());
			return messageLight;
		}
		int idMessage = Integer.parseInt(param);
		Message message = this.forumManager.getMessage(idMessage);
		MessageLight messageLight = new MessageLight();
		messageLight.setId(message.getId());
		messageLight.setTopic(message.getTopic().getId());
		messageLight.setAuteur(message.getAuteur().getLogin());
		messageLight.setContenu(message.getContenu());

		return messageLight;
	}

	@ModelAttribute("categoriesSmiley")
	public List<CategorieSmiley> getCatorgieSmiley(){
		return this.smileyManager.recupererToutesLesCategoriesSmiley();
	}
	@RequestMapping(value="/forum/formulaireMessage.do", method=RequestMethod.GET)
	public String showForm(){
		return "forum/formulaireMessage";
	}
	
	@RequestMapping(value="/forum/formulaireMessage.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("message")MessageLight messageLight){
		
		Topic topic =this.forumManager.getTopic(messageLight.getTopic());
		if(this.estUneModificationMessage(messageLight)){
			Message message = this.forumManager.getMessage(messageLight.getId());

			message.setDateModification(new Date().getTime());
			message.setContenu(messageLight.getContenu());

			this.forumManager.update(message);
		}else{
			Message message = new Message();
			message.setAuteur(this.utilisateurManager.getUtilisateurCourant());
			message.setContenu(messageLight.getContenu());
			message.setDatePostage(new Date().getTime());

			
			message.setTopic(topic);

			this.forumManager.add(message);

		}
		
		return "redirect:affichage.do?topic="+messageLight.getTopic()+"#message_"+topic.getDernierMessage().getId();
	}

	private boolean estUneModificationMessage(MessageLight message) {
		return message.getId()!=0;
	}
}