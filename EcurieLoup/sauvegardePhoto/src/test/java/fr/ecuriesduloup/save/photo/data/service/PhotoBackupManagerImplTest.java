package fr.ecuriesduloup.save.photo.data.service;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;
import fr.ecuriesduloup.save.photo.service.PhotoBackupManager;
import fr.ecuriesduloup.save.photo.test.ContextManagerPhotoBackup;
import fr.ecuriesduloup.save.photo.test.PhotoBackupTestUtil;


public class PhotoBackupManagerImplTest extends DataBaseServiceWithLongIdIntegrationTest<PhotoBackup>{

	private ApplicationContext context;

	public PhotoBackupManagerImplTest(){
		this.context = ContextManagerPhotoBackup.getContext();

	}

	@Before
	public void setUp(){		
		this.notCheckedValue.clear();
		this.service = (PhotoBackupManager) this.context.getBean("photoBackupManager");
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
	public void testGetById() {
		this.notCheckedValue.add("getFile");
		
		super.testGetById();
	}
	
	@Override
	public void testGetAll() {
		this.notCheckedValue.add("getFile");
		
		super.testGetAll();
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
