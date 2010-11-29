package service.photo;

import java.io.File;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Photo;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

/**
 * This class is use to transaction on AlbumPhotoManager is make with recurcivity method.
 *
 */

//TODO : faire autrement! ce code est lamentable !!
public class AlbumPhotoManagerReflector implements AlbumPhotoManager, BeanFactoryAware{
	private AlbumPhotoManager albumPhotoManager;
	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory =  beanFactory;
		
		
	}
	
	public void init(){
		if(this.albumPhotoManager ==null){
			this.albumPhotoManager = (AlbumPhotoManager) beanFactory.getBean("albumPhotoManager");
	
		}
	}

	@Override
	public void creerAlbum(Album album) {
		this.init();
		albumPhotoManager.creerAlbum(album);
	}

	@Override
	public void creerAlbum(File fichierZip, User posteur, String pathServeur) {
		this.init();
		albumPhotoManager.creerAlbum(fichierZip, posteur, pathServeur);
	}

	@Override
	public void creerCommentaire(Commentaire commentaire) {
		this.init();
		albumPhotoManager.creerCommentaire(commentaire);
	}

	@Override
	public void creerPhoto(Photo photo, File fichierPhoto, String pathServeur) {
		this.init();
		albumPhotoManager.creerPhoto(photo, fichierPhoto, pathServeur);
	}

	@Override
	public void creerTag(Tag tag) {
		this.init();
		albumPhotoManager.creerTag(tag);
	}

	@Override
	public void creerZipPhoto(File fichierZip, Album album, User posteur,
			String pathServeur) {
		this.init();
		albumPhotoManager
				.creerZipPhoto(fichierZip, album, posteur, pathServeur);
	}

	@Override
	public int getNombreNouvellesPhotos() {
		this.init();
		return albumPhotoManager.getNombreNouvellesPhotos();
	}

	@Override
	public boolean hasNouvellesPhotos() {
		this.init();
		return albumPhotoManager.hasNouvellesPhotos();
	}

	@Override
	public void modifierAlbum(Album album) {
		this.init();
		albumPhotoManager.modifierAlbum(album);
	}

	@Override
	public void modifierCommentaire(Commentaire commentaire) {
		this.init();
		albumPhotoManager.modifierCommentaire(commentaire);
	}

	@Override
	public void modifierPhoto(Photo photo) {
		this.init();
		albumPhotoManager.modifierPhoto(photo);
	}

	@Override
	public Album recupererAlbum(long id) {
		this.init();
		return albumPhotoManager.recupererAlbum(id);
	}

	@Override
	public Commentaire recupererCommentaire(long idCommentaire) {
		this.init();
		return albumPhotoManager.recupererCommentaire(idCommentaire);
	}

	@Override
	public Photo recupererPhoto(long id) {
		this.init();
		return albumPhotoManager.recupererPhoto(id);
	}

	@Override
	public List<Photo> recupererPhotosNonVu() {
		this.init();
		return albumPhotoManager.recupererPhotosNonVu();
	}

	@Override
	public List<Album> recupererTousLesAlbums() {
		this.init();
		return albumPhotoManager.recupererTousLesAlbums();
	}

	@Override
	public void supprimerAlbum(Album album, String pathServeur) {
		this.init();
		albumPhotoManager.supprimerAlbum(album, pathServeur);
	}

	@Override
	public void supprimerCommentaire(Commentaire commentaire) {
		this.init();
		albumPhotoManager.supprimerCommentaire(commentaire);
	}

	@Override
	public void supprimerPhoto(Photo photo, String pathServeur) {
		this.init();
		albumPhotoManager.supprimerPhoto(photo, pathServeur);
	}

	@Override
	public void supprimerTag(Tag tag) {
		this.init();
		albumPhotoManager.supprimerTag(tag);
	}

	@Override
	public void visionnnageAlbum(Album album) {
		this.init();
		albumPhotoManager.visionnnageAlbum(album);
	}

	@Override
	public Photo getLastPhoto() {
		return this.albumPhotoManager.getLastPhoto();
	}

	

	
}
