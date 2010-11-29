package album_photo;

import integration.ContextManager;
import integration.AlbumInBase;

import org.junit.Before;

import dao.photo.AlbumDAO;
import donnees.photo.Album;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class AlbumDAOTest extends DaoIdLongUtilTest<Album>{

	@Before
	public void setUp() throws Exception {
		this.dao = (AlbumDAO) ContextManager.getContext().getBean("albumDAOTest");
		
	}
	@Override
	protected void compareJUnit(Album t1, Album t2) {
		AlbumPhotoTestUtil.compareJUnit(t1, t2);
		
	}

	@Override
	protected Album getNewObject() {
		return AlbumPhotoTestUtil.getNewAlbum();
	}

	@Override
	protected Album getObjectInBase() {
		return AlbumInBase.getAlbum();
	}

	@Override
	protected void modificationObject(Album t) {
		AlbumPhotoTestUtil.modificationObject(t);
		
	}

}
