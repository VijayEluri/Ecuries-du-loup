package forum.service;

import forum.donnees.Message;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;


public interface MessageManager extends DataBaseServiceWithLongId<Message>{

	public Message getLastMessage();
}
