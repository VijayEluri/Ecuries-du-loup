package integration;

import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public class AlbumInBase {
	

	public static User getUtilisateurToutDroit(){
		User user = new User();
		user.setLogin("krack");

		Set<Role> roles = new HashSet<Role>();

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);

		Role roleForum = new Role();
		roleForum.setRole(RoleEnum.ROLE_ADMINISTRATEUR_FORUM.toString());
		roles.add(roleForum);

		user.setRoles(roles);
		return user;
	}
	
	public static User getUtilisateurSansDroit(){
		User user = new User();
		user.setLogin("loulou");

		return user;
	}

	
	public static Album getAlbum(){
		Album album = new Album();
		album.setId(1);
		album.setTitre("titre album");
		return album;
	}
	
	
	public static Commentaire getCommentaire(){
		Commentaire commentaire = new Commentaire();
		commentaire.setId(1);
		commentaire.setPhoto(AlbumInBase.getPhoto());
		commentaire.setPosteur(AlbumInBase.getUtilisateurToutDroit());
		commentaire.setDate(123456789);
		commentaire.setContenu("Commentaire test");
		return commentaire;
	}

	public static Photo getPhoto() {
		Photo photo = new Photo();
		photo.setId(1);
		photo.setPosteur(AlbumInBase.getUtilisateurToutDroit());
		photo.setAlbum(AlbumInBase.getAlbum());
		photo.setDatePostage(123456789);
		photo.setDescription("Description de la photo de test");
		photo.setTypeAdding("notifier");
		return photo;
	}
	
	public static Tag getTag() {
		Tag tag = new Tag();
		tag.setId(1);
		tag.setNom("Agathe");
		tag.setPhoto(AlbumInBase.getPhoto());
		tag.setX(152);
		tag.setY(154);
		return tag;
	}


}
