package dao.page;

import integration.ContextManager;
import integration.SiteInBase;

import org.junit.Before;

import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class PageDAOHibernateTest extends DaoIdLongUtilTest<Page> {

	@Before
	public void setUp() throws Exception {
		this.dao = (PageDAO) ContextManager.getContext().getBean("pageDaoTest");

	}

	@Override
	protected Page getNewObject() {
		return PageTestUtil.getNewObject();
	}

	@Override
	protected Page getObjectInBase() {
		return SiteInBase.getPage();
	}

	@Override
	protected void modificationObject(Page page) {
		PageTestUtil.modificationObject(page);
	}

}
