package fr.ecuriesduloup.ecurieLoup.memo;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;
import fr.ecuriesduloup.ecurieLoup.memo.dao.MemoDao;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;


public class MemoDaoImplTest extends DaoIdLongUtilTest<Memo>{
	private ApplicationContext context;

	public MemoDaoImplTest(){
		this.context = MemoContextManager.getContext();
		
	}
	
	@Before
	public void setUp(){		
		this.dao = (MemoDao) this.context.getBean("memoDaoTest");
	}
	@Override
	protected void compareJUnit(Memo memo1, Memo memo2) {
		MemoTestUtil.compareJUnit(memo1, memo2);
		
	}

	@Override
	protected Memo getNewObject() {
		return MemoTestUtil.getNewObject();
	}

	@Override
	protected Memo getObjectInBase() {
		return MemoInBase.getMemo();
	}

	@Override
	protected void modificationObject(Memo t) {
		MemoTestUtil.modificationObject(t);		
	}

}
