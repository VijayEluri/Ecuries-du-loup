package smiley;


import org.junit.Before;
import org.springframework.context.ApplicationContext;

import service.smiley.SmileyManagerData;
import donnees.smiley.Smiley;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdAndOrdonnerIntegrationTest;

public class SmileyManagerDataTest extends DataBaseServiceWithLongIdAndOrdonnerIntegrationTest<Smiley>{
	private ApplicationContext context;

	public SmileyManagerDataTest(){
		this.context = ContextManager.getContext();
	}

	@Before
	public void setUp(){		
		this.service = (SmileyManagerData) this.context.getBean("smileyManagerDataTest");
	}

	

	@Override
	protected void compareJUnit(Smiley smiley1, Smiley smiley2) {
		SmileyTestUtil.compareJUnit(smiley1, smiley2);

	}

	@Override
	protected Smiley getNewObject() {
		return SmileyTestUtil.getNewSmiley();
	}

	@Override
	protected Smiley getObjectInBase() {
		return DataInBase.getSmiley();
	}

	@Override
	protected void modificationObject(Smiley smiley) {
		SmileyTestUtil.modificationObject(smiley);
	}


}
