package dao.page;

import static org.junit.Assert.assertEquals;
import donnees.page.Page;

public class PageTestUtil {
    public static void compareJUnit(Page page1, Page page2) {
	assertEquals(page1.getId(), page2.getId());
	assertEquals(page1.getTitle(), page2.getTitle());
	assertEquals(page1.getDescription(), page2.getDescription());
	assertEquals(page1.getOrdre(), page2.getOrdre());
	assertEquals(page1.getContent(), page2.getContent());
	assertEquals(page1.isVisible(), page2.isVisible());

    }

    public static Page getNewObject() {
	Page page = new Page();
	int id = (int) (Math.random() * 10000);
	page.setId(id);
	page.setTitle("title !!");
	page.setContent("Contenu !!");
	page.setDescription("Description");
	page.setVisible(true);
	page.setOrdre(10);

	return page;
    }

    public static void modificationObject(Page page) {
	page.setContent("nouveau contenu");

    }
}
