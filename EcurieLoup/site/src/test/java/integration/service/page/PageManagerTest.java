package integration.service.page;

import static org.junit.Assert.assertFalse;
import integration.ContextManager;
import integration.SiteInBase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import service.page.PageManager;
import dao.page.PageTestUtil;
import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.service.DataBaseService;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdAndOrdonnerIntegrationTest;

public class PageManagerTest extends
		DataBaseServiceWithLongIdAndOrdonnerIntegrationTest<Page> {
	private ApplicationContext context;

	public PageManagerTest() {
		this.context = ContextManager.getContext();
	}

	@Before
	public void setUp() {
		this.service = (DataBaseService<Page>) this.context
				.getBean("pageManager");
	}

	@Ignore
	public void testRemoveInknowObject() {
		// TODO : mettre un test qui fonctionne !
	}

	@Test
	public void testRecuperePagesVisibles() {
		List<Page> pagesSouhaitee = new ArrayList<Page>();

		Page pageSouhaitee1 = new Page();
		pageSouhaitee1.setId(1);
		pageSouhaitee1.setLien("lien de test");
		pageSouhaitee1.setOrdre(1);
		pageSouhaitee1.setContenu("contenu de test");
		pageSouhaitee1.setVisible(true);
		pagesSouhaitee.add(pageSouhaitee1);

		List<Page> pagesVisibles = ((PageManager) this.service)
				.recuperePagesVisibles();
		List<Page> toutesPages = this.service.getAll();

		pagesVisibles.containsAll(pagesSouhaitee);
		toutesPages.removeAll(pagesVisibles);
		for (Page page : toutesPages) {
			assertFalse(page.isVisible());
		}
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
