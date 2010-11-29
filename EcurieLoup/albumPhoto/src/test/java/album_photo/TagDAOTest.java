package album_photo;

import integration.ContextManager;
import integration.AlbumInBase;

import org.junit.Before;

import donnees.photo.Tag;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class TagDAOTest extends DaoIdLongUtilTest<Tag>{

	@Before
	public void setUp() throws Exception {
		this.dao = (TagDAO) ContextManager.getContext().getBean("tagDAOTest");
		
	}
	@Override
	protected void compareJUnit(Tag t1, Tag t2) {
		AlbumPhotoTestUtil.compareJUnit(t1, t2);
		
	}

	@Override
	protected Tag getNewObject() {
		return AlbumPhotoTestUtil.getNewTag();
	}

	@Override
	protected Tag getObjectInBase() {
		return AlbumInBase.getTag();
	}

	@Override
	protected void modificationObject(Tag t) {
		AlbumPhotoTestUtil.modification(t);
		
	}

}
