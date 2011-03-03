package forum.service;

import integration.ContextManager;
import integration.ForumInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import forum.dao.ForumTestUtil;
import forum.donnees.Message;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;


public class MessageManagerImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<Message>{

	private ApplicationContext context;
	
	public MessageManagerImplIntegrationTest(){
		this.context = ContextManager.getContext();
		
	}
	
	@Before
	public void setUp(){		
		this.service = (MessageManager) this.context.getBean("messageManagerTest");
	}

	@Override
	protected Message getNewObject() {
		
		return ForumTestUtil.getNewMessage();
	}

	@Override
	protected Message getObjectInBase() {
		return ForumInBase.getMessage();
	}

	@Override
	protected void modificationObject(Message event) {
		ForumTestUtil.modificationObject(event);
		
	}

}
