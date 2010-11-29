package forum.service;


import org.easymock.EasyMock;
import org.junit.Before;

import forum.dao.CategorieDao;
import forum.dao.ForumTestUtil;
import forum.donnees.Categorie;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;


public class CategorieManagerImplUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<Categorie>{

	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(CategorieDao.class);
		this.service = new CategorieManagerImpl();
		this.service.setDao(this.dao);
	}
	
	@Override
	protected Categorie getNewObject() {
		return ForumTestUtil.getNewCategorie();
	}
	
	
}
