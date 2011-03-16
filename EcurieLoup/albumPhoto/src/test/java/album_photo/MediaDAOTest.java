package album_photo;

import integration.AlbumInBase;
import integration.ContextManager;

import org.junit.Before;

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
	public void testFindById() {
		this.notCheckedValue.add("getCommentaires");
		this.notCheckedValue.add("getTags");
		super.testFindById();
	}
	
	@Override
	public void testFindAll() {
		this.notCheckedValue.add("getCommentaires");
		this.notCheckedValue.add("getTags");
		super.testFindAll();
	}

}
