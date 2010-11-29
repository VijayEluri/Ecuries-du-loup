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
		this.service = (TopicManager) this.context.getBean("topicManagerTest");
	}
	@Override
	protected void compareJUnit(Topic topic1, Topic topic2) {
		ForumTestUtil.compareJUnit(topic1, topic2);
		
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


}
