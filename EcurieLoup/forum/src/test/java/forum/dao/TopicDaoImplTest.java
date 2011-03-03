package forum.dao;


import integration.ContextManager;
import integration.ForumInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class TopicDaoImplTest extends DaoIdLongUtilTest<Topic>{

	private ApplicationContext context;

	public TopicDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.notCheckedValue.clear();
		this.dao = (TopicDao) this.context.getBean("topicDAOTest");
	}

	@Override
	protected Topic getNewObject() {
		
		return ForumTestUtil.getNewTopic();
	}

	@Override
	protected Topic getObjectInBase() {
		return ForumInBase.getTopic();
	}

	@Override
	protected void modificationObject(Topic event) {
		ForumTestUtil.modificationObject(event);
		
	}
	
	@Override
	public void testFindById() {
		this.notCheckedValue.add("getMessages");
		super.testFindById();
	}
	
	@Override
	public void testFindAll() {
		this.notCheckedValue.add("getMessages");
		super.testFindAll();
	}

}
