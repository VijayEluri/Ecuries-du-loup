package forum.service;

import donnees.User;
import forum.donnees.Categorie;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;


public interface CategorieManager extends DataBaseServiceWithLongId<Categorie>{

	public int countNewMessage(User userConnected);
}
