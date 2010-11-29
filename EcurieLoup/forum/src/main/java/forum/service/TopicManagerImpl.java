package forum.service;

import donnees.User;
import forum.dao.TopicDao;
import forum.donnees.Message;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;

public class TopicManagerImpl extends
		DataBaseServiceWithDaoIdLongUtilAndLongId<Topic> implements TopicManager {

	@Override
	public void readTopic(Topic topic, User userConnected) {
		((TopicDao) this.dao).readTopic(topic, userConnected);
		
	}

	@Override
	public long getReadingDate(Topic topic, User connectedUser) {
		return ((TopicDao) this.dao).getReadingDate(topic, connectedUser);
	}

	@Override
	public Message getFirtstMessageNotRead(Topic topic, User connectedUser) {
		return ((TopicDao) this.dao).getFirstMessageNotRead(topic, connectedUser);
	}

	@Override
	public Message getLastMessage(Topic topic) {
		return ((TopicDao) this.dao).getLastMessage(topic);
	}

	

}
