package service.news;

import java.util.List;

import dao.news.NouvelleDAO;
import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;

public class NouvelleManagerImpl extends DataBaseServiceWithDaoIdLongUtilAndLongId<Nouvelle>implements NouvelleManager {
	
	@Override
	public List<Nouvelle> recupererDernieresNouvelles(int nombreDerniereNouvelle) {
		return ((NouvelleDAO) this.dao).getDernieresNouvelles(nombreDerniereNouvelle);
	}

	
}
