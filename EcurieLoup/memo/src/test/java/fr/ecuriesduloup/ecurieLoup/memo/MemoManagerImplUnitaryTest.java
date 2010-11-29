package fr.ecuriesduloup.ecurieLoup.memo;

import org.easymock.EasyMock;
import org.junit.Before;

import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;
import fr.ecuriesduloup.ecurieLoup.memo.dao.MemoDao;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.ecurieLoup.memo.service.MemoManagerImpl;

public class MemoManagerImplUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<Memo>{
	
	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(MemoDao.class);
		this.service = new MemoManagerImpl();
		((MemoManagerImpl)this.service).setDao(this.dao);
	}

	@Override
	protected Memo getNewObject() {
		return MemoTestUtil.getNewObject();
	}

}
