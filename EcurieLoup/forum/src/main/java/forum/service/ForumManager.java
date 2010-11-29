package forum.service;

import java.util.List;

import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public interface ForumManager {

	public void add(Categorie categorie);
	public void add(Topic topic, Message firstMessage);
	public void add(Message message);

	public void update(Categorie categorie);
	public void update(Topic topic);
	public void update(Message message);

	public void delete(Categorie categorie);
	public void delete(Topic topic);
	public void delete(Message message);

	public List<Categorie> getAllCategories();
	public List<Topic> getAllTopicCategories(int categorieDesTopics);
	public List<Message> getAllMessagesTopic(long topicDesMessages);

	public Categorie getCategorie(long idCategorie);
	public Topic getTopic(long idTopic);
	public Message getMessage(long idMessage);

	public void fermerTopic(Topic topicOuvert);
	public void ouvrirTopic(Topic topicFermer);
	
	public void lectureTopic(Topic topic);
	
	public boolean hasNouveauxMessages();
	public int getNombreNouveauxMessages();
	public List<Topic> recupererTopicAvecMessageNonLu();
	
	public Message getLastMessage();
}
