package smiley;


import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;

import service.smiley.SmileyManagerDataImpl;
import dao.smiley.SmileyDao;
import donnees.smiley.Smiley;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdAndOrdonnerUnitaryTest;


public class SmileyManagerDataImplTest extends DataBaseServiceWithLongIdAndOrdonnerUnitaryTest<Smiley>{


	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(SmileyDao.class);
		this.service = new SmileyManagerDataImpl();
		this.service.setDao(this.dao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Override
	protected Smiley getNewObject() {
		return SmileyTestUtil.getNewSmiley();
	}
	
	

}
