package unitaire.service.page;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import service.page.PageManagerImpl;
import dao.page.PageDAO;
import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdAndOrdonnerUnitaryTest;

public class PageManagerImplTest extends
		DataBaseServiceWithLongIdAndOrdonnerUnitaryTest<Page> {

	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(PageDAO.class);
		this.service = new PageManagerImpl();
		this.service.setDao(this.dao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Override
	protected Page getNewObject() {
		Page page = new Page();
		int id = (int) (Math.random() * 10000);
		page.setId(id);
		page.setContenu("Contenu !!");
		page.setLien("lien :p");
		page.setVisible(true);

		return page;
	}

	@Override
	protected List<Page> getListObjectOrdonner() {
		List<Page> listPages = super.getListObjectOrdonner();
		for (Page page : listPages) {
			int visible = (int) (Math.random() * 2);
			if (visible == 0) {
				page.setVisible(false);
			} else {

				page.setVisible(true);
			}
		}
		return listPages;
	}

	@Test
	public void testRecuperationPagesVisible() throws Throwable {

		List<Page> pages = this.getListObjectOrdonner();
		List<Page> pagesVisible = new ArrayList<Page>();

		for (Page page : pages) {
			if (page.isVisible()) {
				pagesVisible.add(page);
			}
		}

		EasyMock.expect(((PageDAO) this.dao).findVisiblePages()).andReturn(
				pagesVisible);
		EasyMock.replay(this.dao);

		List<Page> pagesRecuperer = ((PageManagerImpl) this.service)
				.recuperePagesVisibles();
		assertTrue(pagesVisible.containsAll(pagesRecuperer));
		assertTrue(pagesRecuperer.containsAll(pagesVisible));
		for (Page page : pagesRecuperer) {

			assertTrue(page.isVisible());
		}
		EasyMock.verify(this.dao);
	}
}
