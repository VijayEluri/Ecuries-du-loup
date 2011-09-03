package service.photo;

import java.io.File;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;

/**
 * This class is use to transaction on AlbumPhotoManager is make with recurcivity method.
 *
 */

//TODO : faire autrement! ce code est lamentable !!
public class MediaManagerReflector implements MediaManager, BeanFactoryAware{
	private MediaManager albumPhotoManager;
	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory =  beanFactory;
		
		
	}
	
	public void init(){
		if(this.albumPhotoManager ==null){
			this.albumPhotoManager = (MediaManager) beanFactory.getBean("mediaManager");
	
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
	public void creerMedia(Media media, File fichierMedia, String pathServeur) {
		this.init();
		albumPhotoManager.creerMedia(media, fichierMedia, pathServeur);
	}

	@Override
	public void creerTag(Tag tag) {
		this.init();
		albumPhotoManager.creerTag(tag);
	}

	@Override
	public void creerZipMedia(File fichierZip, Album album, User posteur,
			String pathServeur) {
		this.init();
		albumPhotoManager
				.creerZipMedia(fichierZip, album, posteur, pathServeur);
	}

	@Override
	public int getNombreNouvellesMedias() {
		this.init();
		return albumPhotoManager.getNombreNouvellesMedias();
	}

	@Override
	public boolean hasNouvellesMedias() {
		this.init();
		return albumPhotoManager.hasNouvellesMedias();
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
	public void modifierMedia(Media media) {
		this.init();
		albumPhotoManager.modifierMedia(media);
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
	public Media recupererMedia(long id) {
		this.init();
		return albumPhotoManager.recupererMedia(id);
	}

	@Override
	public List<Media> recupererMediasNonVu() {
		this.init();
		return albumPhotoManager.recupererMediasNonVu();
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
	public void supprimerMedia(Media media, String pathServeur) {
		this.init();
		albumPhotoManager.supprimerMedia(media, pathServeur);
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
	public Media getLastMedia() {
		return this.albumPhotoManager.getLastMedia();
	}

	

	
}
