package dao.news;

import static org.junit.Assert.assertEquals;
import integration.ContextManager;
import integration.NewsInBase;

import java.util.ArrayList;
import java.util.List;

import news.test.NewsTestUtil;

import org.junit.Before;
import org.junit.Test;

import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;
import fr.ecurie_du_loup.generique_util.test.Comparator;

public class NouvelleDAOHibernateTest extends DaoIdLongUtilTest<Nouvelle>{

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		this.dao = (DaoIdLongUtil<Nouvelle>) ContextManager.getContext().getBean("nouvelleDaoTest");
		
	}
	@Test
	public void testGetLaDernieresNouvelles() {
		Nouvelle nouvelleAjoutee = this.getNewObject();
		
		this.dao.add(nouvelleAjoutee);
		
		List<Nouvelle> listeNouvelle =  ((NouvelleDAO) this.dao).getDernieresNouvelles(1);
		assertEquals(1, listeNouvelle.size());
		Comparator.compareJUnit(listeNouvelle.get(0), nouvelleAjoutee);
		
	}
	
	@Test
	public void testGet5DernieresNouvelles() {
		List<Nouvelle> nouvelleAjouterDansOrdre = new ArrayList<Nouvelle>();
		for(int i = 0; i < 5; i++){
			Nouvelle nouvelleAjoutee = this.getNewObject();
			this.dao.add(nouvelleAjoutee);
			nouvelleAjouterDansOrdre.add(nouvelleAjoutee);
		}
		
		List<Nouvelle> listeNouvelle =  ((NouvelleDAO) this.dao).getDernieresNouvelles(5);
		assertEquals(5, listeNouvelle.size());
		int j = 0;
		for(int i = 4; i >=0; i--){
			Comparator.compareJUnit(listeNouvelle.get(j), nouvelleAjouterDansOrdre.get(i));
			j++;
		}
		
		
	}

	@Override
	protected Nouvelle getNewObject() {
		return NewsTestUtil.getNewObject();
	}

	@Override
	protected Nouvelle getObjectInBase() {
		return NewsInBase.getNouvelle();
	}

	@Override
	protected void modificationObject(Nouvelle t) {
		NewsTestUtil.modificationObject(t);
		
	}

}
