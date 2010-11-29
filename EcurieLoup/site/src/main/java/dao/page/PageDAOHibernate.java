package dao.page;

import java.util.List;

import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class PageDAOHibernate extends HibernateIdLongBySpringDao<Page>
		implements PageDAO {

	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY t.ordre ASC";
	}

	@Override
	public List<Page> findVisiblePages() {
		return this.getHibernateTemplate().find(
				"Select t FROM " + this.parametreClass.getSimpleName()
						+ " t WHERE t.visible=true "
						+ this.getOrderByOfFindAll() + " ");
	}
}
