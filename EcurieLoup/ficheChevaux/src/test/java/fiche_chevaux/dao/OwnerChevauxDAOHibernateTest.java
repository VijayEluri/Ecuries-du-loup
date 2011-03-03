package fiche_chevaux.dao;



import org.junit.Before;

import fiche_chevaux.donnees.Owner;
import fiche_chevaux.test.ChoixChevauxTestUtil;
import fiche_chevaux.test.ContextManager;
import fiche_chevaux.test.DataInBase;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class OwnerChevauxDAOHibernateTest extends DaoIdLongUtilTest<Owner>{

	@Before
	public void setUp() throws Exception {
		this.dao = (OwnerChevauxDAO) ContextManager.getContext().getBean("ownerChevauxDAOTest");
		
	}

	@Override
	protected Owner getNewObject() {
		Owner owner = new Owner();
		long id = (long) (Math.random() * 10000);
		owner.setId(id);
		owner.setName("nom owner nouveau");
		owner.setUser(DataInBase.getUser());
		return owner;
	}

	@Override
	protected Owner getObjectInBase() {
		return DataInBase.getOwner();
	}

	@Override
	protected void modificationObject(Owner t) {
		ChoixChevauxTestUtil.modificationObject(t);
		
	}

}
