package fr.ecuriesduloup.ecurieLoup.memo;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.ecurieLoup.memo.service.MemoManager;


public class MemoManagerImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<Memo>{
	private ApplicationContext context;

	public MemoManagerImplIntegrationTest(){
		this.context = MemoContextManager.getContext();
	}

	@Before
	public void setUp(){
		this.service = (MemoManager) this.context.getBean("memoManager");
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
