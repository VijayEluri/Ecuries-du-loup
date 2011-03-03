package fr.ecuriesduloup.save.photo.dao;

import org.junit.Before;

import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;
import fr.ecuriesduloup.save.photo.test.ContextManagerPhotoBackup;
import fr.ecuriesduloup.save.photo.test.PhotoBackupTestUtil;


public class PhotoBackupDaoHibernateTest extends DaoIdLongUtilTest<PhotoBackup>{

	@Before
	public void setUp() throws Exception {
		this.notCheckedValue.clear();
		this.dao = (PhotoBackupDAO) ContextManagerPhotoBackup.getContext().getBean("photoBackupDaoTest");
		
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
	
	@Override
	public void testFindById() {
		this.notCheckedValue.add("getFile");
		super.testFindById();
	}
	
	@Override
	public void testFindAll() {
		this.notCheckedValue.add("getFile");
		
		super.testFindAll();
	}
	
	@Override
	public void testAdd() {
		this.notCheckedValue.add("getFile");
		
		super.testAdd();
	}
	
	@Override
	public void testUpdate() {
		this.notCheckedValue.add("getFile");
		
		super.testUpdate();
	}

}
