package smiley;


import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;

import service.smiley.CategorieSmileyManagerImpl;
import dao.smiley.CategorieSmileyDao;
import donnees.smiley.CategorieSmiley;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdAndOrdonnerUnitaryTest;


public class CategorieSmileyManagerImplTest extends DataBaseServiceWithLongIdAndOrdonnerUnitaryTest<CategorieSmiley>{


	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(CategorieSmileyDao.class);
		this.service = new CategorieSmileyManagerImpl();
		this.service.setDao(this.dao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Override
	protected CategorieSmiley getNewObject() {
		return SmileyTestUtil.getNewCategorieSmiley();
	}
	
	

}
