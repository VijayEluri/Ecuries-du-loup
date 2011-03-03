package forum.dao;

import integration.ForumInBase;
import integration.UserInBase;

import java.util.HashSet;

import donnees.Role;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public class ForumTestUtil {

	public static Message getNewMessage() {
		Message message = new Message();
		message.setContenu("contenu ajouter");
		message.setAuteur(UserInBase.getUtilisateurToutDroit());
		message.setDateModification(0);
		message.setDatePostage(123456789);
		message.setTopic(ForumInBase.getTopic());
		return message;
	}

	public static void modificationObject(Message message) {
		message.setContenu("contenu modifier");
	}

	

	public static Topic getNewTopic() {
		Topic topic = new Topic();
		topic.setTitre("titre de la categorie");
		topic.setOuvert(true);
		topic.setCreateur(UserInBase.getUtilisateurToutDroit());
		topic.setCategorie(ForumInBase.getCatergorie());

		return topic;
	}

	public static void modificationObject(Topic topic) {
		topic.setTitre("nouveau titre");
	}

	public static void modificationObject(Categorie categorie) {
		categorie.setDescription("nouvelle description");
		
	}

	public static Categorie getNewCategorie() {
		Categorie categorie = new Categorie();
		categorie.setTitre("titre de la categorie");
		categorie.setDescription("description de la categorie");
		categorie.setRoleAutoriser(new HashSet<Role>());

		return categorie;
	}


}
