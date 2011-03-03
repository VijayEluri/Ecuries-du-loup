package fr.ecurie_du_loup.generique_util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;
import fr.ecurie_du_loup.generique_util.data.ObjectTest2;
import fr.ecurie_du_loup.generique_util.data.ObjectTestSample;
import fr.ecurie_du_loup.generique_util.test.Comparator;

public class HibernateBySpringDaoTest extends DaoIdLongUtilTest<ObjectTestSample>{
	private DaoUtil<ObjectTest2> dao2;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		
		this.dao = (DaoIdLongUtil<ObjectTestSample>) ContextManager.getContext().getBean("objectTestDAO");
		this.dao2 = (DaoUtil<ObjectTest2>) ContextManager.getContext().getBean("objectTestDAO2");
	}

	@After
	public void tearDown() throws Exception {
	}

	private void testPresenceEqualsInBase(ObjectTestSample objectTest){
		List<ObjectTestSample> listFindAll = this.dao.findAll();
		
		assertTrue(listFindAll.contains(objectTest));
		for(ObjectTestSample object : listFindAll){
			if(object.equals(objectTest)){
				Comparator.compareJUnit(objectTest, object);
			}
		}
	}
	private void testPresenceEqualsInBase(ObjectTest2 objectTest){
		List<ObjectTest2> listFindAll = this.dao2.findAll();
		
		assertTrue(listFindAll.contains(objectTest));
		for(ObjectTest2 object : listFindAll){
			if(object.equals(objectTest)){
				Comparator.compareJUnit(objectTest, object);
			}
		}
	}


	@Test
	public void testAddObjetAvecDependance() {

		ObjectTestSample obj1 = this.getNewObject();
		this.dao.add(obj1);
		ObjectTest2 obj2 = this.getDataObjectTest2();
		obj2.setObjectTest(obj1);
		this.dao2.add(obj2);

		this.testPresenceEqualsInBase(obj2);

	}
	
	@Ignore("Parce que sa ne fonctionne pas comme cela. Vérifier si ce n'est pas possible de renvoyer une excepetion si on souhaite détruire un objet avec des références sur lui")
	@Test
	public void testRemoveNoDependanceWichDependance() {
		ObjectTestSample obj1 =  this.getNewObject();
		this.dao.add(obj1);
		ObjectTest2 obj2 = this.getDataObjectTest2();
		obj2.setObjectTest(obj1);
		this.dao2.add(obj2);

		try{
			this.dao.remove(obj1);
			fail("desctruction alors que l'objet pointe dessus");
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.testPresenceEqualsInBase(obj1);

		this.dao2.remove(obj2);
		this.dao.remove(obj1);

		List<ObjectTestSample> listFindAll = this.dao.findAll();
		assertFalse(listFindAll.contains(obj1));
		List<ObjectTest2> listFindAll2 = this.dao2.findAll();
		assertFalse(listFindAll2.contains(obj2));
		
	}
	

	@Override
	protected ObjectTestSample getNewObject() {
		ObjectTestSample objectTest  = ObjectTestSampleTestUtil.getNewObject();
		return objectTest;
	}

	public ObjectTest2 getDataObjectTest2() {
		return new ObjectTest2();
	}
	
	@Override
	protected ObjectTestSample getObjectInBase() {
		return ObjectTestSampleTestUtil.getObjectInBase();
	}

	@Override
	protected void modificationObject(ObjectTestSample t) {
		ObjectTestSampleTestUtil.modificationObject(t);
	}

}
