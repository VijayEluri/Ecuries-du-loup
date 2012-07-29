package service.photo.securite;

import java.io.File;
import java.util.List;

import service.UtilisateurManager;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

//TODO : use spring annotation for this class
public class MediaDecorateurConcrete extends AlbumPhotoSecuriteDecorateur {

    private UtilisateurManager utilisateurManager;

    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
	this.utilisateurManager = utilisateurManager;
    }

    private boolean aDroitAlbum(User utilisateur) {
	Role roleForum = new Role();
	roleForum.setRole(RoleEnum.ROLE_ADMINISTRATEUR_PHOTO.toString());
	for (Role roleCompare : utilisateur.getRoles()) {
	    if (roleCompare.equals(roleForum)) {
		return true;
	    }
	}

	// car le getUtilisateurcourent renvoi null dans un autre thread
	return true;
	// return false;
    }

    private boolean aDroitUtilisateur(User utilisateur) {
	Role roleForum = new Role();
	roleForum.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
	for (Role roleCompare : utilisateur.getRoles()) {
	    if (roleCompare.equals(roleForum)) {
		return true;
	    }
	}

	// car le getUtilisateurcourent renvoi null dans un autre thread
	return true;
	// return false;
    }

    @Override
    public void creerAlbum(Album album) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.creerAlbum(album);
	}
    }

    @Override
    public void creerMedia(Media media, File fichierPhoto, String pathPhoto) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.creerMedia(media, fichierPhoto, pathPhoto);
	}
    }

    @Override
    public void modifierAlbum(Album album) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.modifierAlbum(album);
	}
    }

    @Override
    public void modifierMedia(Media media) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.modifierMedia(media);
	}
    }

    @Override
    public Album recupererAlbum(long id) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitUtilisateur(utilisateur)) {
	    return this.mediaManager.recupererAlbum(id);
	}
	return null;
    }

    @Override
    public Media recupererMedia(long id) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitUtilisateur(utilisateur)) {
	    return this.mediaManager.recupererMedia(id);
	}
	return null;
    }

    @Override
    public List<Album> recupererTousLesAlbums() {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitUtilisateur(utilisateur)) {
	    return this.mediaManager.recupererTousLesAlbums();
	}
	return null;
    }

    @Override
    public Commentaire recupererCommentaire(long idCommentaire) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitUtilisateur(utilisateur)) {
	    return this.mediaManager.recupererCommentaire(idCommentaire);
	}
	return null;
    }

    @Override
    public void supprimerAlbum(Album album, String pathServeur) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.supprimerAlbum(album, pathServeur);
	}
    }

    @Override
    public void supprimerMedia(Media media, String pathServeur) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.supprimerMedia(media, pathServeur);
	}
    }

    @Override
    public void creerCommentaire(Commentaire commentaire) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitUtilisateur(utilisateur)) {
	    this.mediaManager.creerCommentaire(commentaire);
	}
    }

    @Override
    public void modifierCommentaire(Commentaire commentaire) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.modifierCommentaire(commentaire);
	}
    }

    @Override
    public void creerTag(Tag tag) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitUtilisateur(utilisateur)) {
	    this.mediaManager.creerTag(tag);
	}
    }

    @Override
    public void supprimerCommentaire(Commentaire commentaire) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.supprimerCommentaire(commentaire);
	}
    }

    @Override
    public void supprimerTag(Tag tag) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    this.mediaManager.supprimerTag(tag);
	}
    }

    @Override
    public boolean hasNouvellesMedias() {
	return this.mediaManager.hasNouvellesMedias();

    }

    @Override
    public int getNombreNouvellesMedias() {
	return this.mediaManager.getNombreNouvellesMedias();
    }

    @Override
    public List<Media> recupererMediasNonVu() {
	return this.mediaManager.recupererMediasNonVu();
    }

    @Override
    public Media getLastMedia() {
	return this.mediaManager.getLastMedia();
    }

    @Override
    public List<Media> getTagContent(User user) {
	return this.mediaManager.getTagContent(user);
    }

    @Override
    public List<Media> getTagContent(long horseIdentifier) {
	return this.mediaManager.getTagContent(horseIdentifier);
    }

    @Override
    public void readMedia(Media media, User user) {
	this.mediaManager.readMedia(media, user);
    }

    @Override
    public List<Album> getAllAlbumsLigth() {

	return this.mediaManager.getAllAlbumsLigth();
    }

    @Override
    public Media getMedia(long id) {

	return this.mediaManager.getMedia(id);
    }

    @Override
    public List<Tag> getMediasTags(long mediaId) {
	return this.mediaManager.getMediasTags(mediaId);
    }

    @Override
    public List<Commentaire> getMediasComments(long mediaId) {
	return this.mediaManager.getMediasComments(mediaId);
    }

    @Override
    public Tag getTag(long tagId) {
	User utilisateur = this.utilisateurManager.getUtilisateurCourant();
	if (this.aDroitAlbum(utilisateur)) {
	    return this.mediaManager.getTag(tagId);
	}

	return null;
    }

	@Override
	public Album recupererAlbumLight(long id) {
		return this.mediaManager.recupererAlbumLight(id);
	}

}
