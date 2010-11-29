package dao.calendrier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import integration.ContextManager;
import integration.EventInBase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class EventDaoImplTest extends DaoIdLongUtilTest<Evenement>{

	private ApplicationContext context;

	public EventDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.dao = (EventDao) this.context.getBean("eventDAOTest");
	}
	
	@Test
	public void testHasEvenementOfTypeWithDataInBase() {
		boolean isAlreadyInBase = ((EventDao)this.dao).hasEvenementOfType(EventInBase.getTypeEvent());
		assertTrue(isAlreadyInBase);
	}

	@Test
	public void testHasEvenementOfTypeWithDataNotInBase() {
		boolean isAlreadyInBase = ((EventDao)this.dao).hasEvenementOfType(new TypeEvenement());
		assertFalse(isAlreadyInBase);
	}
	@Override
	protected void compareJUnit(Evenement evenement1, Evenement evenement2) {
		CalendrierTestUtil.compareJUnit(evenement1, evenement2);
		
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
