package album_photo;

import integration.AlbumInBase;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.TypeMedia;
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

	public static Media getNewMedia() {
		Media media = new Media();
		int id = (int) (Math.random()*10000);
		media.setId(id);
		media.setDescription("description");
		media.setAlbum(AlbumInBase.getAlbum());
		media.setPosteur(AlbumInBase.getUtilisateurToutDroit());
		media.setDatePostage(123456789);
		media.setTypeAdding("notifier");
		media.setType(TypeMedia.Photo.ordinal());

		return media;
	}

	public static void modification(Media t) {
		t.setDescription("description modifier");

	}


	public static Commentaire getNewCommentaire() {
		Commentaire commentaire = new Commentaire();
		int id = (int) (Math.random()*10000);
		commentaire.setId(id);
		commentaire.setContenu("contenu");
		commentaire.setDate(123456789);
		commentaire.setMedia(AlbumInBase.getMedia());
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
		tag.setPhoto(AlbumInBase.getMedia());
		tag.setX(125.01);
		tag.setY(0.000051);
		return tag;
	}

	public static void modification(Tag t) {
		t.setNom("nouveau nom");		
	}
}
