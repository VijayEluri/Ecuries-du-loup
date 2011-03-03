package album_photo;

import static org.junit.Assert.assertEquals;
import integration.AlbumInBase;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public class AlbumPhotoTestUtil {

	public static Album getNewAlbum() {
		Album album = new Album();
		int id = (int) (Math.random()*10000);
		album.setId(id);
		album.setTitre("titre de test");

		return album;
	}

	public static void modificationObject(Album t) {
		t.setTitre("titre modifer");

	}

	public static Photo getNewPhoto() {
		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);
		photo.setDescription("description");
		photo.setAlbum(AlbumInBase.getAlbum());
		photo.setPosteur(AlbumInBase.getUtilisateurToutDroit());
		photo.setDatePostage(123456789);
		photo.setTypeAdding("notifier");

		return photo;
	}

	public static void modification(Photo t) {
		t.setDescription("description modifier");

	}


	public static Commentaire getNewCommentaire() {
		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);
		commentaire.setContenu("contenu");
		commentaire.setDate(123456789);
		commentaire.setPhoto(AlbumInBase.getPhoto());
		commentaire.setPosteur(AlbumInBase.getUtilisateurToutDroit());
		return commentaire;
	}

	public static void modification(Commentaire t) {
		t.setContenu("contenu modifier");

	}

	public static Tag getNewTag() {
		Tag tag = new Tag();
		int id = (int) (Math.random()*10000);
		tag.setId(id);
		tag.setNom("nom");
		tag.setPhoto(AlbumInBase.getPhoto());
		tag.setX(125.01);
		tag.setY(0.000051);
		return tag;
	}

	public static void modification(Tag t) {
		t.setNom("nouveau nom");		
	}
}
