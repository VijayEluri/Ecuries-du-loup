package album_photo;

import integration.ContextManager;
import integration.AlbumInBase;

import org.junit.Before;

import donnees.photo.commentaire.Commentaire;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;


public class CommentaireDAOTest extends DaoIdLongUtilTest<Commentaire>{

	@Before
	public void setUp() throws Exception {
		this.dao = (CommentaireDAO) ContextManager.getContext().getBean("commentaireDAOTest");
		
	}
	@Override
	protected void compareJUnit(Commentaire t1, Commentaire t2) {
		AlbumPhotoTestUtil.compareJUnit(t1, t2);
		
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

}
