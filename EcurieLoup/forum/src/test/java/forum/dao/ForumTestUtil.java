package forum.dao;

import static org.junit.Assert.assertEquals;
import integration.ForumInBase;
import integration.UserInBase;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public class ForumTestUtil {

	public static void compareJUnit(Message message1, Message message2) {
		assertEquals(message1.getId(), message2.getId());
		assertEquals(message1.getAuteur(), message2.getAuteur());
		assertEquals(message1.getContenu(), message2.getContenu());
		assertEquals(message1.getDateModification(), message2.getDateModification());
		assertEquals(message1.getDatePostage(), message2.getDatePostage());
		assertEquals(message1.getTopic(), message2.getTopic());

	}

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

	public static void compareJUnit(Topic topic1, Topic topic2) {
		assertEquals(topic1.getId(), topic2.getId());
		assertEquals(topic1.getTitre(), topic2.getTitre());
		assertEquals(topic1.getCategorie(), topic2.getCategorie());
		assertEquals(topic1.getCreateur(), topic2.getCreateur());
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

		return categorie;
	}

	public static void compareJUnit(Categorie categorie1, Categorie categorie2) {
		assertEquals(categorie1.getId(), categorie2.getId());
		assertEquals(categorie1.getTitre(), categorie2.getTitre());
		assertEquals(categorie1.getDescription(), categorie2.getDescription());
		//TODO : remettre
		//assertEquals(categorie1.getTopics(), categorie2.getTopics());
		
	}

}
