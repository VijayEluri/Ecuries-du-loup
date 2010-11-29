package forum.dao;

import donnees.User;
import forum.donnees.Message;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface TopicDao extends DaoIdLongUtil<Topic>{
	public void readTopic(Topic topic, User userConnected);

	public long getReadingDate(Topic topic, User userConnected);

	public Message getFirstMessageNotRead(Topic topic, User utilisateurConnecte);

	public Message getLastMessage(Topic topic);
}
