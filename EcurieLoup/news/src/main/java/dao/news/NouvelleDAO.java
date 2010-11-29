package dao.news;

import java.util.List;

import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface NouvelleDAO extends DaoIdLongUtil<Nouvelle>{

	public List<Nouvelle> getDernieresNouvelles(int nombre);
}
