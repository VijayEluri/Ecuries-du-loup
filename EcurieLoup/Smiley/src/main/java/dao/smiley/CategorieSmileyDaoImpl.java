package dao.smiley;

import donnees.smiley.CategorieSmiley;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class CategorieSmileyDaoImpl extends HibernateIdLongBySpringDao<CategorieSmiley> implements CategorieSmileyDao {

	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY t.ordre ASC";
	}
}
