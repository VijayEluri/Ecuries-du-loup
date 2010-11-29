package fr.ecurie_du_loup.generique_util.service;

import org.easymock.EasyMock;
import org.junit.Before;

import fr.ecurie_du_loup.generique_util.dao.ObjectTestHibernateBySpringDao;
import fr.ecurie_du_loup.generique_util.dao.ObjectTestSampleTestUtil;
import fr.ecurie_du_loup.generique_util.data.ObjectTestSample;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;


public class ObjectTestSampleDataBaseServiceServiceWithDaoUtilAndLongIdUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<ObjectTestSample>{


	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(ObjectTestHibernateBySpringDao.class);
		this.service = new ObjectTestSampleDataBaseServiceWithDaoUtilAndLongIdImpl();
		this.service.setDao(this.dao);
	}
	@Override
	protected ObjectTestSample getNewObject() {
		ObjectTestSample objectTest  = ObjectTestSampleTestUtil.getNewObject();
		long id = (long) (Math.random()*50000);
		objectTest.setId(id);
		return objectTest;
	}

}
