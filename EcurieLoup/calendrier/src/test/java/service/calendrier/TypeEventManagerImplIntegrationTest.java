package service.calendrier;

import integration.ContextManager;
import integration.EventInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import dao.calendrier.CalendrierTestUtil;
import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;


public class TypeEventManagerImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<TypeEvenement>{

	private ApplicationContext context;
	
	public TypeEventManagerImplIntegrationTest(){
		this.context = ContextManager.getContext();
		
	}
	
	@Before
	public void setUp(){		
		this.service = (TypeEventManager) this.context.getBean("typeEventManagerTest");
	}
	
	@Override
	protected TypeEvenement getNewObject() {
		
		return CalendrierTestUtil.getNewTypeEvent();
	}

	@Override
	protected TypeEvenement getObjectInBase() {
		return EventInBase.getTypeEvent();
	}

	@Override
	protected void modificationObject(TypeEvenement event) {
		CalendrierTestUtil.modificationObject(event);
		
	}
}
