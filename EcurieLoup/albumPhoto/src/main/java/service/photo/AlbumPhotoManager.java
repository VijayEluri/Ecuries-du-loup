package service.photo;

import java.io.File;
import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

public interface AlbumPhotoManager {
	
	public List<Album> recupererTousLesAlbums();
	
	public Album recupererAlbum(long id);
	public void creerAlbum(Album album);
	public void creerAlbum(File fichierZip, User posteur, String pathServeur);
	public void modifierAlbum(Album album);
	public void supprimerAlbum(Album album, String pathServeur);

	public Photo recupererPhoto(long id);
	public void creerPhoto(Photo photo, File fichierPhoto, String pathServeur);
	public void creerZipPhoto(File fichierZip, Album album, User posteur, String pathServeur);
	public void modifierPhoto(Photo photo);
	public void supprimerPhoto(Photo photo, String pathServeur);
	

	public Commentaire recupererCommentaire(long idCommentaire);
	public void creerCommentaire(Commentaire commentaire);
	public void modifierCommentaire(Commentaire commentaire);
	public void supprimerCommentaire(Commentaire commentaire);
	
	
	public void creerTag(Tag tag);
	public void supprimerTag(Tag tag);
	
	public void visionnnageAlbum(Album album);
	public boolean hasNouvellesPhotos();
	public int getNombreNouvellesPhotos();
	public List<Photo> recupererPhotosNonVu();
	

	public Photo getLastPhoto();
}
