package smiley;



import org.junit.Before;
import org.springframework.context.ApplicationContext;

import dao.smiley.CategorieSmileyDao;
import donnees.smiley.CategorieSmiley;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class CategorieSmileyDaoImplTest extends DaoIdLongUtilTest<CategorieSmiley>{

	private ApplicationContext context;

	public CategorieSmileyDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.notCheckedValue.clear();
		this.dao = (CategorieSmileyDao) this.context.getBean("categorieSmileyDAOTest");
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
	protected void modificationObject(CategorieSmiley t) {
		SmileyTestUtil.modificationObject(t);
		
	}
	
	@Override
	public void testFindAll() {
		this.notCheckedValue.add("getSmileys");
		
		super.testFindAll();
	}
	
	@Override
	public void testFindById() {
		this.notCheckedValue.add("getSmileys");
		
		super.testFindById();
	}
	
	

}
