package album_photo;

import integration.ContextManager;
import integration.AlbumInBase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dao.photo.AlbumDAO;
import donnees.photo.Album;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class AlbumDAOTest extends DaoIdLongUtilTest<Album>{

	@Before
	public void setUp() throws Exception {
		this.notCheckedValue.clear();
		this.dao = (AlbumDAO) ContextManager.getContext().getBean("albumDAOTest");

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

	@Override
	@Test
	public void testFindById() {
		this.notCheckedValue.add("getMedias");
		this.notCheckedValue.add("getPhotoNonVu");

		super.testFindById();
	}

	@Override
	@Test
	public void testFindAll() {
		this.notCheckedValue.add("getMedias");
		this.notCheckedValue.add("getPhotoNonVu");

		super.testFindAll();
	}
	
	@Override
	@Test
	public void testAdd() {
		this.notCheckedValue.add("getMedias");
		this.notCheckedValue.add("getPhotoNonVu");

		super.testAdd();
	}
	
	@Override
	@Test
	public void testUpdate() {
		this.notCheckedValue.add("getMedias");
		this.notCheckedValue.add("getPhotoNonVu");

		super.testUpdate();
	}
}
