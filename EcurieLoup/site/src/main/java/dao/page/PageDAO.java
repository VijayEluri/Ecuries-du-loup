package dao.page;

import java.util.List;

import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface PageDAO extends DaoIdLongUtil<Page> {

	public List<Page> findVisiblePages();
}
