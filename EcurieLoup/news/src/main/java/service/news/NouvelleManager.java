package service.news;

import java.util.List;

import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;

public interface NouvelleManager extends DataBaseServiceWithLongId<Nouvelle>{
	public List<Nouvelle> recupererDernieresNouvelles(int nombreDerniereNouvelle);
}
