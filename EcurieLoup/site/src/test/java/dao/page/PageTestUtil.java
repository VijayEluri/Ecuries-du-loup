package dao.page;

import static org.junit.Assert.assertEquals;
import donnees.page.Page;

public class PageTestUtil {
	public static void compareJUnit(Page page1, Page page2) {
		assertEquals(page1.getId(), page2.getId());
		assertEquals(page1.getLien(), page2.getLien());
		assertEquals(page1.getOrdre(), page2.getOrdre());
		assertEquals(page1.getContenu(), page2.getContenu());
		assertEquals(page1.isVisible(), page2.isVisible());

	}

	public static Page getNewObject() {
		Page page = new Page();
		int id = (int) (Math.random() * 10000);
		page.setId(id);
		page.setContenu("Contenu !!");
		page.setLien("lien :p");
		page.setVisible(true);
		page.setOrdre(10);

		return page;
	}

	public static void modificationObject(Page page) {
		page.setContenu("nouveau contenu");

	}
}
