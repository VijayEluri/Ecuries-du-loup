package forum.service;

import donnees.User;
import forum.dao.CategorieDao;
import forum.donnees.Categorie;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;

public class CategorieManagerImpl extends
		DataBaseServiceWithDaoIdLongUtilAndLongId<Categorie> implements CategorieManager {

	@Override
	public int countNewMessage(User userConnected) {
		return ((CategorieDao) this.dao).countNewMessage(userConnected);
	}



}
