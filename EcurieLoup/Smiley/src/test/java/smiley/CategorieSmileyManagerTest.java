package smiley;


import org.junit.Before;
import org.springframework.context.ApplicationContext;

import service.smiley.CategorieSmileyManager;
import donnees.smiley.CategorieSmiley;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdAndOrdonnerIntegrationTest;

public class CategorieSmileyManagerTest extends DataBaseServiceWithLongIdAndOrdonnerIntegrationTest<CategorieSmiley>{
	private ApplicationContext context;

	public CategorieSmileyManagerTest(){
		this.context = ContextManager.getContext();
	}

	@Before
	public void setUp(){	
		this.notCheckedValue.clear();
		this.service = (CategorieSmileyManager) this.context.getBean("categorieSmileyManagerTest");
	}

	@Override
	protected CategorieSmiley getNewObject() {
		return SmileyTestUtil.getNewCategorieSmiley();
	}

	@Override
	protected CategorieSmiley getObjectInBase() {
		return DataInBase.getCategorieSmiley();
	}

	@Override
	protected void modificationObject(CategorieSmiley categorieSmiley) {
		SmileyTestUtil.modificationObject(categorieSmiley);
	}
	
	@Override
	public void testGetById() {
		this.notCheckedValue.add("getSmileys");
		super.testGetById();
	}
	
	@Override
	public void testGetAll() {
		this.notCheckedValue.add("getSmileys");
		super.testGetAll();
	}


}
