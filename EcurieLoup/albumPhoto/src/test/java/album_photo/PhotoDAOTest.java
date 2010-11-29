package album_photo;

import integration.ContextManager;
import integration.AlbumInBase;

import org.junit.Before;

import donnees.photo.Photo;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class PhotoDAOTest extends DaoIdLongUtilTest<Photo>{

	@Before
	public void setUp() throws Exception {
		this.dao = (PhotoDAO) ContextManager.getContext().getBean("photoDAOTest");
		
	}
	@Override
	protected void compareJUnit(Photo t1, Photo t2) {
		AlbumPhotoTestUtil.compareJUnit(t1, t2);
		
	}

	@Override
	protected Photo getNewObject() {
		return AlbumPhotoTestUtil.getNewPhoto();
	}

	@Override
	protected Photo getObjectInBase() {
		return AlbumInBase.getPhoto();
	}

	@Override
	protected void modificationObject(Photo t) {
		AlbumPhotoTestUtil.modification(t);
		
	}

}
