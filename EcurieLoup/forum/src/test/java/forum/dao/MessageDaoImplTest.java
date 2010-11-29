package forum.dao;


import integration.ContextManager;
import integration.ForumInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import forum.donnees.Message;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class MessageDaoImplTest extends DaoIdLongUtilTest<Message>{

	private ApplicationContext context;

	public MessageDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.dao = (MessageDao) this.context.getBean("messageDAOTest");
	}
	
	
	@Override
	protected void compareJUnit(Message message1, Message message2) {
		ForumTestUtil.compareJUnit(message1, message2);
		
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
