package fr.ecuriesduloup.save.photo.data.service;

import org.easymock.EasyMock;
import org.junit.Before;

import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;
import fr.ecuriesduloup.save.photo.dao.PhotoBackupDAO;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;
import fr.ecuriesduloup.save.photo.service.PhotoBackupManagerImpl;
import fr.ecuriesduloup.save.photo.test.PhotoBackupTestUtil;


public class PhotoBackupManagerImplUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<PhotoBackup>{

	
	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(PhotoBackupDAO.class);
		this.service = new PhotoBackupManagerImpl();
		this.service.setDao(this.dao);
	}
	@Override
	protected PhotoBackup getNewObject() {
		return PhotoBackupTestUtil.getNewObject();
	}

}
