package album_photo;

import integration.AlbumInBase;
import integration.ContextManager;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class MediaDAOTest extends DaoIdLongUtilTest<Media>{

	@Before
	public void setUp() throws Exception {
		this.notCheckedValue.clear();
		this.dao = (MediaDAO) ContextManager.getContext().getBean("photoDAOTest");
		
	}

	@Override
	protected Media getNewObject() {
		return AlbumPhotoTestUtil.getNewMedia();
	}

	@Override
	protected Media getObjectInBase() {
		return AlbumInBase.getMedia();
	}

	@Override
	protected void modificationObject(Media t) {
		AlbumPhotoTestUtil.modification(t);
		
	}
	
	@Override
	@Test
	@Ignore
	public void testFindById() {
		this.notCheckedValue.add("getCommentaires");
		this.notCheckedValue.add("getTags");
		super.testFindById();
	}
	
	@Override
	@Test
	@Ignore
	public void testFindAll() {
		this.notCheckedValue.add("getCommentaires");
		this.notCheckedValue.add("getTags");
		super.testFindAll();
	}

	@Override
	@Test
	@Ignore
	public void testAdd() {
		// TODO Auto-generated method stub
		super.testAdd();
	}
	
	@Override
	@Test
	@Ignore
	public void testUpdate() {
		// TODO Auto-generated method stub
		super.testUpdate();
	}
	
}
