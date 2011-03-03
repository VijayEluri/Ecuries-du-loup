package fiche_chevaux.dao;

import org.junit.Before;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.test.ContextManager;
import fiche_chevaux.test.DataInBase;
import fiche_chevaux.test.FicheChevauxTestUtil;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class FicheChevauxDAOHibernateTest extends DaoIdLongUtilTest<Fiche>{

	@Before
	public void setUp() throws Exception {
		this.dao = (FicheChevauxDAO) ContextManager.getContext().getBean("ficheChevauxDaoTest");
		
	}
	/*@Test
	public void testGetFichesChevauxSexe() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFichesChevauxRace() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFichesChevauxRobe() {
		fail("Not yet implemented");
	}
*/

	@Override
	protected Fiche getNewObject() {
		return FicheChevauxTestUtil.getNewObject();
	}

	@Override
	protected Fiche getObjectInBase() {
		return DataInBase.getFiche();
	}

	@Override
	protected void modificationObject(Fiche t) {
		FicheChevauxTestUtil.modificationObject(t);
		
	}

}
