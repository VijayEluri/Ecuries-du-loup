package fr.ecurie_du_loup.generique_util.service;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import fr.ecurie_du_loup.generique_util.dao.ContextManager;
import fr.ecurie_du_loup.generique_util.dao.ObjectTestSampleTestUtil;
import fr.ecurie_du_loup.generique_util.data.ObjectTestSample;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;


public class ObjectTestSampleDataBaseServiceWithDaoUtilAndLongIdImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<ObjectTestSample>{
	private ApplicationContext context;
	
	public ObjectTestSampleDataBaseServiceWithDaoUtilAndLongIdImplIntegrationTest(){
		this.context = ContextManager.getContext();
	}
	
	@Before
	public void setUp(){		
		this.service =  (ObjectTestSampleDataBaseServiceWithDaoUtilAndLongId) this.context.getBean("objectTestService");
	}

	@Override
	protected ObjectTestSample getNewObject() {
		return ObjectTestSampleTestUtil.getNewObject();
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
