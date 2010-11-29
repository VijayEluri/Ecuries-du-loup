package forum.service;


import org.easymock.EasyMock;
import org.junit.Before;

import forum.dao.ForumTestUtil;
import forum.dao.TopicDao;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;


public class TopicManagerImplUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<Topic>{

	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(TopicDao.class);
		this.service = new TopicManagerImpl();
		this.service.setDao(this.dao);
	}
	
	@Override
	protected Topic getNewObject() {
		return ForumTestUtil.getNewTopic();
	}
	
	
}
