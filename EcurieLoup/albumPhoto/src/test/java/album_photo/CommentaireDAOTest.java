package album_photo;

import integration.ContextManager;
import integration.AlbumInBase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import donnees.photo.commentaire.Commentaire;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class CommentaireDAOTest extends DaoIdLongUtilTest<Commentaire>{

	@Before
	public void setUp() throws Exception {
		this.dao = (CommentaireDAO) ContextManager.getContext().getBean("commentaireDAOTest");

	}
	@Test
	@Override
	public void testAdd() {
		// TODO Auto-generated method stub
		super.testAdd();
	}
	@Override
	protected Commentaire getNewObject() {
		return AlbumPhotoTestUtil.getNewCommentaire();
	}

	@Override
	protected Commentaire getObjectInBase() {
		return AlbumInBase.getCommentaire();
	}

	@Override
	protected void modificationObject(Commentaire t) {
		AlbumPhotoTestUtil.modification(t);

	}
	@Test
@Override
public void testFindAll() {
	// TODO Auto-generated method stub
	super.testFindAll();
}
	@Override
	@Test
	public void testUpdate() {
		// TODO Auto-generated method stub
		super.testUpdate();
	}
	
	@Override
	@Test
	public void testFindById() {
		// TODO Auto-generated method stub
		super.testFindById();
	}
}
