package fiche_chevaux.dao;



import java.util.Date;

import org.junit.Before;

import fiche_chevaux.donnees.Robe;
import fiche_chevaux.test.ChoixChevauxTestUtil;
import fiche_chevaux.test.ContextManager;
import fiche_chevaux.test.DataInBase;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class RobeChevauxDAOHibernateTest extends DaoIdLongUtilTest<Robe>{

	@Before
	public void setUp() throws Exception {
		this.dao = (RobeChevauxDAO) ContextManager.getContext().getBean("robeChevauxDAOTest");
		
	}

	@Override
	protected Robe getNewObject() {
		Robe robe = new Robe();
		robe.setNom("nom Robe nouveau"+new Date().getTime());
		return robe;
	}

	@Override
	protected Robe getObjectInBase() {
		return DataInBase.getRobe();
	}

	@Override
	protected void modificationObject(Robe t) {
		ChoixChevauxTestUtil.modificationObject(t);
		
	}

}
