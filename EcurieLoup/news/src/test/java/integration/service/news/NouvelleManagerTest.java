package integration.service.news;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import integration.ContextManager;
import integration.NewsInBase;

import java.util.ArrayList;
import java.util.List;

import news.test.NewsTestUtil;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import service.news.NouvelleManager;
import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;
import fr.ecurie_du_loup.generique_util.test.Comparator;

public class NouvelleManagerTest extends  DataBaseServiceWithLongIdIntegrationTest<Nouvelle>{
	private ApplicationContext context;
	
	public NouvelleManagerTest(){
		this.context = ContextManager.getContext();
	}
	
	@Before
	public void setUp(){		
		this.service = (NouvelleManager) this.context.getBean("nouvelleManager");
	}
	

	@Test
	public void testGetLaDernieresNouvelles() {
		Nouvelle nouvelleAjoutee = this.getNewObject();
		
		this.service.add(nouvelleAjoutee);
		
		List<Nouvelle> listeNouvelle =  ((NouvelleManager) this.service).recupererDernieresNouvelles(1, "");
		assertEquals(1, listeNouvelle.size());
		Comparator.compareJUnit(listeNouvelle.get(0), nouvelleAjoutee);
		
	}
	
	@Test
	public void testGet5DernieresNouvelles() {
		List<Nouvelle> nouvelleAjouterDansOrdre = new ArrayList<Nouvelle>();
		for(int i = 0; i < 5; i++){
			Nouvelle nouvelleAjoutee = this.getNewObject();
			this.service.add(nouvelleAjoutee);
			nouvelleAjouterDansOrdre.add(nouvelleAjoutee);
		}
		
		List<Nouvelle> listeNouvelle =  ((NouvelleManager) this.service).recupererDernieresNouvelles(5, "");
		assertEquals(5, listeNouvelle.size());
		int j = 0;
		for(int i = 4; i >=0; i--){
			Comparator.compareJUnit(listeNouvelle.get(j), nouvelleAjouterDansOrdre.get(i));
			j++;
		}
		
		
	}
	
	
	@Test
	public void testRecupererDernieresNouvellesPlus() {

		List<Nouvelle> nouvellesRecuperer = ((NouvelleManager) this.service).recupererDernieresNouvelles(10000, "");
	
		assertTrue(nouvellesRecuperer.size() < 10000);
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
