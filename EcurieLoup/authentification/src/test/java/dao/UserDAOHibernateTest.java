package dao;

import integration.ContextManager;
import integration.UserInBase;

import org.junit.Before;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdStringUtilTest;

public class UserDAOHibernateTest extends DaoIdStringUtilTest<User>{

	@Before
	public void setUp() throws Exception {
		this.dao = (UserDAO) ContextManager.getContext().getBean("userDAOTest");
		
	}
	
	@Override
	protected void compareJUnit(User utilisateur1, User utilisateur2) {
		AuthentificationTestUtil.compareJUnit(utilisateur1, utilisateur2);
		
	}

	@Override
	protected User getNewObject() {
		return AuthentificationTestUtil.getNewObject();
	}

	@Override
	protected User getObjectInBase() {
		return UserInBase.getUtilisateurSansDroit();
	}

	@Override
	protected void modificationObject(User t) {
		AuthentificationTestUtil.modificationObject(t);
		
	}

}
