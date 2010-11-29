package fiche_chevaux.dao;


import java.util.Date;

import org.junit.Before;

import fiche_chevaux.donnees.Race;
import fiche_chevaux.test.ChoixChevauxTestUtil;
import fiche_chevaux.test.ContextManager;
import fiche_chevaux.test.DataInBase;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class RaceChevauxDAOHibernateTest extends DaoIdLongUtilTest<Race>{

	@Before
	public void setUp() throws Exception {
		this.dao = (RaceChevauxDAO) ContextManager.getContext().getBean("raceChevauxDaoTest");
		
	}

	@Override
	protected void compareJUnit(Race t1, Race t2) {
		ChoixChevauxTestUtil.compareJUnit(t1, t2);
		
	}

	@Override
	protected Race getNewObject() {
		Race race = new Race();
		race.setNom("nom Race nouveau"+new Date().getTime());
		return race;
	}

	@Override
	protected Race getObjectInBase() {
		return DataInBase.getRace();
	}

	@Override
	protected void modificationObject(Race t) {
		ChoixChevauxTestUtil.modificationObject(t);
		
	}

}
