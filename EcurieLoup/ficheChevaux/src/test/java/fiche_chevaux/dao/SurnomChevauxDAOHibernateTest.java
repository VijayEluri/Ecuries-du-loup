package fiche_chevaux.dao;



import java.util.Date;

import org.junit.Before;

import fiche_chevaux.donnees.Surnom;
import fiche_chevaux.test.ChoixChevauxTestUtil;
import fiche_chevaux.test.ContextManager;
import fiche_chevaux.test.DataInBase;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class SurnomChevauxDAOHibernateTest extends DaoIdLongUtilTest<Surnom>{

	@Before
	public void setUp() throws Exception {
		this.dao = (SurnomsChevauxDAO) ContextManager.getContext().getBean("surnomChevauxDaoTest");
		
	}

	@Override
	protected Surnom getNewObject() {
		Surnom surnom = new Surnom();
		surnom.setSurnom("nom surnom nouveau"+new Date().getTime());
		surnom.setFiche(DataInBase.getFiche2());
		return surnom;
	}

	@Override
	protected Surnom getObjectInBase() {
		return DataInBase.getSurnom();
	}

	@Override
	protected void modificationObject(Surnom t) {
		ChoixChevauxTestUtil.modificationObject(t);
		
	}

}
