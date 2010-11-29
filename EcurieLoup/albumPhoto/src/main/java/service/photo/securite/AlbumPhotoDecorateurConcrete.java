package service.photo.securite;

import java.io.File;
import java.util.List;

import service.UtilisateurManager;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public class AlbumPhotoDecorateurConcrete extends AlbumPhotoSecuriteDecorateur {
	
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}
	
	private boolean aDroitAlbum(User utilisateur){
		Role roleForum = new Role();
		roleForum.setRole(RoleEnum.ROLE_ADMINISTRATEUR_PHOTO.toString());
		for(Role roleCompare : utilisateur.getRoles()){
			if(roleCompare.equals(roleForum)){
				return true;
			}
		}
		
		//car le getUtilisateurcourent renvoi null dans un autre thread
		return true;
		//return false;
	}
	
	private boolean aDroitUtilisateur(User utilisateur) {
		Role roleForum = new Role();
		roleForum.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		for(Role roleCompare : utilisateur.getRoles()){
			if(roleCompare.equals(roleForum)){
				return true;
			}
		}
		
		//car le getUtilisateurcourent renvoi null dans un autre thread
		return true;
		//return false;
	}
	
	@Override
	public void creerAlbum(Album album) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.creerAlbum(album);
		}
	}
	@Override
	public void creerAlbum(File fichierZip, User posteur, String pathPhoto) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		System.out.println(utilisateur);
		if(this.aDroitAlbum(posteur)){
			this.albumPhotoManager.creerAlbum(fichierZip, posteur, pathPhoto);
		}
	}
	@Override
	public void creerPhoto(Photo photo, File fichierPhoto, String pathPhoto) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.creerPhoto(photo, fichierPhoto, pathPhoto);
		}
	}

	@Override
	public void modifierAlbum(Album album) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.modifierAlbum(album);
		}
	}

	@Override
	public void modifierPhoto(Photo photo) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.modifierPhoto(photo);
		}
	}

	@Override
	public Album recupererAlbum(long id) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitUtilisateur(utilisateur)){
			return this.albumPhotoManager.recupererAlbum(id);
		}
		return null;
	}

	@Override
	public Photo recupererPhoto(long id) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitUtilisateur(utilisateur)){
			return this.albumPhotoManager.recupererPhoto(id);
		}
		return null;
	}

	@Override
	public List<Album> recupererTousLesAlbums() {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitUtilisateur(utilisateur)){
			return this.albumPhotoManager.recupererTousLesAlbums();
		}
		return null;
	}
	@Override
	public Commentaire recupererCommentaire(long idCommentaire) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitUtilisateur(utilisateur)){
			return this.albumPhotoManager.recupererCommentaire(idCommentaire);
		}
		return null;
	}

	@Override
	public void supprimerAlbum(Album album, String pathServeur) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.supprimerAlbum(album, pathServeur);
		}
	}

	@Override
	public void supprimerPhoto(Photo photo, String pathServeur) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.supprimerPhoto(photo, pathServeur);
		}
	}

	@Override
	public void creerCommentaire(Commentaire commentaire) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitUtilisateur(utilisateur)){
			this.albumPhotoManager.creerCommentaire(commentaire);
		}
	}

	@Override
	public void modifierCommentaire(Commentaire commentaire) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.modifierCommentaire(commentaire);
		}
	}

	@Override
	public void creerTag(Tag tag) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitUtilisateur(utilisateur)){
			this.albumPhotoManager.creerTag(tag);
		}
	}

	@Override
	public void supprimerCommentaire(Commentaire commentaire) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.supprimerCommentaire(commentaire);
		}
	}

	@Override
	public void supprimerTag(Tag tag) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(utilisateur)){
			this.albumPhotoManager.supprimerTag(tag);
		}
	}

	@Override
	public void creerZipPhoto(File fichierZip, Album album, User posteur,
			String pathServeur) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitAlbum(posteur)){
			this.albumPhotoManager.creerZipPhoto(fichierZip, album, posteur, pathServeur);
		}
	}

	@Override
	public void visionnnageAlbum(Album album) {
		this.albumPhotoManager.visionnnageAlbum(album);
		
	}

	@Override
	public boolean hasNouvellesPhotos() {
		return this.albumPhotoManager.hasNouvellesPhotos();
		
	}

	@Override
	public int getNombreNouvellesPhotos() {
		return this.albumPhotoManager.getNombreNouvellesPhotos();
	}

	@Override
	public List<Photo> recupererPhotosNonVu() {
		return this.albumPhotoManager.recupererPhotosNonVu();
	}

	@Override
	public Photo getLastPhoto() {
		return this.albumPhotoManager.getLastPhoto();
	}	

}
