package forum.service;

import donnees.User;
import forum.donnees.Message;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;


public interface TopicManager extends DataBaseServiceWithLongId<Topic>{

	public void readTopic(Topic topic, User userConnected);

	public long getReadingDate(Topic topic, User utilisateurConnecte);

	public Message getFirtstMessageNotRead(Topic topic, User connectedUser);
	
	public Message getLastMessage(Topic topic);
}
