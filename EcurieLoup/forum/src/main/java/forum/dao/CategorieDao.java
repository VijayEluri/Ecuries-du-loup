package forum.dao;

import donnees.User;
import forum.donnees.Categorie;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface CategorieDao extends DaoIdLongUtil<Categorie>{

	public int countNewMessage(User userConnected);

}
