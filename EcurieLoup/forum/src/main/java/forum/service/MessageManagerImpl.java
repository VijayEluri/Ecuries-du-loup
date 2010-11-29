package forum.service;

import java.util.List;

import forum.donnees.Message;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;

public class MessageManagerImpl extends
		DataBaseServiceWithDaoIdLongUtilAndLongId<Message> implements MessageManager {


	public Message getLastMessage(){
		List<Message> messages = this.dao.findAll();
		int lastMessageIndex = messages.size() -1;
		return messages.get(lastMessageIndex);
	}
}
