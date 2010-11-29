package service.page;

import java.util.List;

import dao.page.PageDAO;
import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWhithLongAndOrdonneeImpl;

public class PageManagerImpl extends
		DataBaseServiceWhithLongAndOrdonneeImpl<Page> implements PageManager {

	@Override
	public List<Page> recuperePagesVisibles() {
		List<Page> pages = ((PageDAO) this.dao).findVisiblePages();
		return pages;
	}

}
