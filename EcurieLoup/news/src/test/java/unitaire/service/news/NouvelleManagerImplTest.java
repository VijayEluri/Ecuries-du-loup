package unitaire.service.news;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import integration.UserInBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import service.news.NouvelleManagerImpl;
import dao.news.NouvelleDAO;
import donnees.news.Nouvelle;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;

public class NouvelleManagerImplTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<Nouvelle>{

	

	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(NouvelleDAO.class);
		this.service = new NouvelleManagerImpl();
		this.service.setDao(this.dao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRecupererDernieresNouvelles() {
		List<Nouvelle> listNouvelle = new ArrayList<Nouvelle>();
		for(int i = 0; i < 2; i++){
			Nouvelle nouvelle = new Nouvelle();
			int id = (int) Math.random()*10000;
			nouvelle.setId(id);
			listNouvelle.add(nouvelle);
		}
		EasyMock.expect(((NouvelleDAO) this.dao).getDernieresNouvelles(2)).andReturn(listNouvelle);

		EasyMock.replay(this.dao);

		List<Nouvelle> listeNouvelleRecuperer = ((NouvelleManagerImpl) this.service).recupererDernieresNouvelles(2);

		assertEquals(listeNouvelleRecuperer, listNouvelle);
		EasyMock.verify(this.dao);
	}
	
	@Test
	public void testRecupererDernieresNouvellesVide() {
		List<Nouvelle> listNouvelle = new ArrayList<Nouvelle>();
		
		EasyMock.expect(((NouvelleDAO) this.dao).getDernieresNouvelles(2)).andReturn(listNouvelle);

		EasyMock.replay(this.dao);

		List<Nouvelle> listeNouvelleRecuperer = ((NouvelleManagerImpl) this.service).recupererDernieresNouvelles(2);

		assertEquals(listeNouvelleRecuperer, listNouvelle);
		assertTrue(listeNouvelleRecuperer.isEmpty());
		EasyMock.verify(this.dao);
	}

	

	@Override
	protected Nouvelle getNewObject() {
		Nouvelle nouvelle = new Nouvelle();
		long id = ((int)Math.random()*50000);
		nouvelle.setId(id);
		nouvelle.setTitre("titre "+id);
		nouvelle.setAuteur(UserInBase.getUtilisateurSansDroit());
		nouvelle.setContenu("contenu "+id);
		nouvelle.setDateCreation(new Date().getTime());
		return nouvelle;
	}


}
