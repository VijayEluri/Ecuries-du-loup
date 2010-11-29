package dao.news;

import java.util.ArrayList;
import java.util.List;

import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class NouvelleDAOHibernate extends HibernateIdLongBySpringDao<Nouvelle> implements NouvelleDAO{

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Nouvelle> getDernieresNouvelles(int nombreVoullu) {
		//List<Nouvelle> find = this.getHibernateTemplate().find("FROM nouvelle ORDER BY date_creation DESC LIMIT 0,"+nombre);
		List<Nouvelle> find = this.getHibernateTemplate().loadAll(Nouvelle.class);
		//find = find.subList(Math.max(find.size()-1-nombre, 0), find.size()-1);
		
		find =this.trierNouvelleParDate(find);
		find = this.recupererNbElementVoullu(find, nombreVoullu);
		return find;
	
	}

	private List<Nouvelle> trierNouvelleParDate(List<Nouvelle> listeNouvelles){
		List<Nouvelle> listeNouvellesOrdonnee = new ArrayList<Nouvelle>();
		//FIXME: attention ne marche que pour le cas présent a savoir que la récupération se fait dans lordre inverse de l'ordre voullu
		for(Nouvelle nouvelle : listeNouvelles){
			listeNouvellesOrdonnee.add(0, nouvelle);
		}
		return listeNouvellesOrdonnee;
	}
	
	private List<Nouvelle> recupererNbElementVoullu(List<Nouvelle> listeNouvelles, int nombreVoullu){
		int fin = Math.min(nombreVoullu, listeNouvelles.size());
		return listeNouvelles.subList(0, fin);
	}
	
}
