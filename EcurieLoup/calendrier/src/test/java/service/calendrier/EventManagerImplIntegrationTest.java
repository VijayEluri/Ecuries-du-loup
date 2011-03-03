package service.calendrier;

import integration.ContextManager;
import integration.EventInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import dao.calendrier.CalendrierTestUtil;
import donnees.calendrier.Evenement;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;


public class EventManagerImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<Evenement>{

	private ApplicationContext context;
	
	public EventManagerImplIntegrationTest(){
		this.context = ContextManager.getContext();
		
	}
	
	@Before
	public void setUp(){		
		this.service = (EventManager) this.context.getBean("eventManagerTest");
	}

	@Override
	protected Evenement getNewObject() {
		
		return CalendrierTestUtil.getNewObject();
	}

	@Override
	protected Evenement getObjectInBase() {
		return EventInBase.getEvent();
	}

	@Override
	protected void modificationObject(Evenement event) {
		CalendrierTestUtil.modificationObject(event);
		
	}
}
