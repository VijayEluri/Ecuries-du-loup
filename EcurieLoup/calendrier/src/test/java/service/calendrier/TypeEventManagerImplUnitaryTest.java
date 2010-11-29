package service.calendrier;

import org.easymock.EasyMock;
import org.junit.Before;

import dao.calendrier.CalendrierTestUtil;
import dao.calendrier.TypeEventDao;
import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;


public class TypeEventManagerImplUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<TypeEvenement>{

	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(TypeEventDao.class);
		this.service = new TypeEventManagerImpl();
		this.service.setDao(this.dao);
	}
	
	@Override
	protected TypeEvenement getNewObject() {
		return CalendrierTestUtil.getNewTypeEvent();
	}
	
	

}
