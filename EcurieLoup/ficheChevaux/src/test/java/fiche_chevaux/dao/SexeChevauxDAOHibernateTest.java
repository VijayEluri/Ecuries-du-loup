package fiche_chevaux.dao;



import java.util.Date;

import org.junit.Before;

import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.test.ChoixChevauxTestUtil;
import fiche_chevaux.test.ContextManager;
import fiche_chevaux.test.DataInBase;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class SexeChevauxDAOHibernateTest extends DaoIdLongUtilTest<Sexe>{

	@Before
	public void setUp() throws Exception {
		this.dao = (SexeChevauxDAO) ContextManager.getContext().getBean("sexeChevauxDaoTest");
		
	}

	@Override
	protected void compareJUnit(Sexe t1, Sexe t2) {
		ChoixChevauxTestUtil.compareJUnit(t1, t2);
		
	}

	@Override
	protected Sexe getNewObject() {
		Sexe sexe = new Sexe();
		sexe.setNom("nom Sexe nouveau"+new Date().getTime());
		return sexe;
	}

	@Override
	protected Sexe getObjectInBase() {
		return DataInBase.getSexe();
	}

	@Override
	protected void modificationObject(Sexe t) {
		ChoixChevauxTestUtil.modificationObject(t);
		
	}

}
