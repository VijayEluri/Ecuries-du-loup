package smiley;



import org.junit.Before;
import org.springframework.context.ApplicationContext;

import dao.smiley.SmileyDao;
import donnees.smiley.Smiley;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class SmileyDaoImplTest extends DaoIdLongUtilTest<Smiley>{

	private ApplicationContext context;

	public SmileyDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.dao = (SmileyDao) this.context.getBean("smileyDAOTest");
	}
	@Override
	protected void compareJUnit(Smiley t1, Smiley t2) {
		SmileyTestUtil.compareJUnit(t1, t2);
		
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
	protected void modificationObject(Smiley t) {
		SmileyTestUtil.modificationObject(t);
		
	}
	
	
	

}
