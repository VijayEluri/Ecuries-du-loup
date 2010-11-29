package fr.ecuriesduloup.save.photo.dao;

import org.junit.Before;

import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;
import fr.ecuriesduloup.save.photo.test.ContextManagerPhotoBackup;
import fr.ecuriesduloup.save.photo.test.PhotoBackupTestUtil;


public class PhotoBackupDaoHibernateTest extends DaoIdLongUtilTest<PhotoBackup>{

	@Before
	public void setUp() throws Exception {
		this.dao = (PhotoBackupDAO) ContextManagerPhotoBackup.getContext().getBean("photoBackupDaoTest");
		
	}
	
	@Override
	protected void compareJUnit(PhotoBackup t1, PhotoBackup t2) {
		PhotoBackupTestUtil.compareJUnit(t1, t2);
		
	}

	@Override
	protected PhotoBackup getNewObject() {
		return PhotoBackupTestUtil.getNewObject();
	}

	@Override
	protected PhotoBackup getObjectInBase() {
		return PhotoBackupTestUtil.getObjectInBase();
	}

	@Override
	protected void modificationObject(PhotoBackup t) {
		PhotoBackupTestUtil.modificationObject(t);		
	}

}
