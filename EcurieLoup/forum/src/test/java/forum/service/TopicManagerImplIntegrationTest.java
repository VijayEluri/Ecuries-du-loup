package forum.service;

import integration.ContextManager;
import integration.ForumInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import forum.dao.ForumTestUtil;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;


public class TopicManagerImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<Topic>{

	private ApplicationContext context;
	
	public TopicManagerImplIntegrationTest(){
		this.context = ContextManager.getContext();
		
	}
	
	@Before
	public void setUp(){		
		this.notCheckedValue.clear();
		
		this.service = (TopicManager) this.context.getBean("topicManagerTest");
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
	public void testGetById() {
		this.notCheckedValue.add("getMessages");
		super.testGetById();
	}
	
	@Override
	public void testGetAll() {
		this.notCheckedValue.add("getMessages");
		super.testGetAll();
	}

}
