package dao.smiley;

import donnees.smiley.Smiley;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class SmileyDaoImpl extends HibernateIdLongBySpringDao<Smiley> implements SmileyDao {

	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY t.ordre ASC";
	}
}
