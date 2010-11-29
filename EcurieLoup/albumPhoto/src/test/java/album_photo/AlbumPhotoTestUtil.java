package album_photo;

import static org.junit.Assert.assertEquals;
import integration.AlbumInBase;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public class AlbumPhotoTestUtil {


	public static void compareJUnit(Album album1, Album album2) {
		assertEquals(album1.getId(), album2.getId());
		assertEquals(album1.getTitre(), album2.getTitre());
		assertEquals(album1.getDateLecture(), album2.getDateLecture());

	}

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

	public static void compareJUnit(Photo photo1, Photo photo2) {
		assertEquals(photo1.getId(), photo2.getId());
		assertEquals(photo1.getAlbum(), photo2.getAlbum());
		assertEquals(photo1.getDatePostage(), photo2.getDatePostage());
		assertEquals(photo1.getDescription(), photo2.getDescription());
		assertEquals(photo1.getPosteur(), photo2.getPosteur());

	}

	public static Photo getNewPhoto() {
		Photo photo = new Photo();
		int id = (int) (Math.random()*10000);
		photo.setId(id);
		photo.setDescription("description");
		photo.setAlbum(AlbumInBase.getAlbum());
		photo.setPosteur(AlbumInBase.getUtilisateurToutDroit());
		photo.setDatePostage(123456789);

		return photo;
	}

	public static void modification(Photo t) {
		t.setDescription("description modifier");

	}

	public static void compareJUnit(Commentaire commentaire1, Commentaire commentaire2) {
		assertEquals(commentaire1.getId(), commentaire2.getId());
		assertEquals(commentaire1.getContenu(), commentaire2.getContenu());
		assertEquals(commentaire1.getDate(), commentaire2.getDate());
		assertEquals(commentaire1.getPhoto(), commentaire2.getPhoto());
		assertEquals(commentaire1.getPosteur(), commentaire2.getPosteur());
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

	public static void compareJUnit(Tag tag1, Tag tag2) {
		assertEquals(tag1.getId(), tag2.getId());
		assertEquals(tag1.getNom(), tag2.getNom());
		assertEquals(tag1.getPhoto(), tag2.getPhoto());
		assertEquals(tag1.getX(), tag2.getX(), 00);
		assertEquals(tag1.getY(), tag2.getY(), 00);
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
