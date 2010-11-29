package dao.calendrier;

import integration.ContextManager;
import integration.EventInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class TypeEventDaoImplTest  extends DaoIdLongUtilTest<TypeEvenement>{

	private ApplicationContext context;

	public TypeEventDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.dao = (TypeEventDao) this.context.getBean("typeEventDAOTest");
	}
	
	@Override
	protected void compareJUnit(TypeEvenement te1, TypeEvenement te2) {
		CalendrierTestUtil.compareJUnit(te1, te2);
		
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
