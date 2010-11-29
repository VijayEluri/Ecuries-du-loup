package forum.dao;

import java.util.List;

import donnees.User;
import forum.donnees.Message;
import forum.donnees.Topic;

public interface ForumDAO {
	
	
	
	
	public List<Topic> getTopicsCatgeries(int idCategorie);
	public Message getLastMessage(Topic topic);
	public long getDateLecture(Topic topic, User utilisateurConnecte);
	public Message getPremierMessageNonLu(Topic topic, User utilisateurConnecte);
	public void lectureTopic(Topic topic, User utilisateurConnecte);
	public int getNombreNouveauxMessage(User utilisateurConnecte);

}
