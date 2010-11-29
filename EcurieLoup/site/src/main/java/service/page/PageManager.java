package service.page;

import java.util.List;

import donnees.page.Page;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongIdAndOrdonner;

public interface PageManager extends DataBaseServiceWithLongIdAndOrdonner<Page> {
	public List<Page> recuperePagesVisibles();

}
