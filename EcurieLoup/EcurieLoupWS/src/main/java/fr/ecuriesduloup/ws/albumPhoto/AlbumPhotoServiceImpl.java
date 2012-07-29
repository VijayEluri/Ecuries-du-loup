package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.photo.MediaManager;
import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.commentaire.Commentaire;

@Service
public class AlbumPhotoServiceImpl implements AlbumPhotoService {
    @Autowired
    private MediaManager mediaManager;

    public void setMediaManager(MediaManager mediaManager) {
	this.mediaManager = mediaManager;
    }

    @Override
    public long createAlbumPhoto(String name) {
	Album album = new Album();
	album.setTitre(name);
	this.mediaManager.creerAlbum(album);
	return album.getId();
    }

    @Override
    public void createMedia(Media media, File photoFile, String pathServeur) {
	this.mediaManager.creerMedia(media, photoFile, pathServeur);
    }

    @Override
    public Album getAlbum(long albumId) {
	return this.mediaManager.recupererAlbumLight(albumId);
    }

    @Override
    public List<Album> getAlbums() {
	return this.mediaManager.recupererTousLesAlbums();
    }

    @Override
    public List<Media> getMediaWithHorse(long horseIdentifier) {
	return this.mediaManager.getTagContent(horseIdentifier);
    }

    @Override
    public List<Media> getMediaWithUser(User user) {
	return this.mediaManager.getTagContent(user);
    }

    @Override
    public List<Commentaire> getComments(long mediaId) {
	return this.mediaManager.getMediasComments(mediaId);
    }

    @Override
    public Commentaire getComment(long commentId) {
	return this.mediaManager.recupererCommentaire(commentId);
    }

    @Override
    public Commentaire createComment(Commentaire comment) {
	this.mediaManager.creerCommentaire(comment);
	return this.mediaManager.recupererCommentaire(comment.getId());
    }

    @Override
    public void deleteComment(long commentId) {
	Commentaire comment = this.mediaManager.recupererCommentaire(commentId);
	this.mediaManager.supprimerCommentaire(comment);
    }

    @Override
    public Media getMedia(long mediaId) {
	return this.mediaManager.recupererMedia(mediaId);
    }

    @Override
    public void readMedia(long mediaId, User user) {
	Media media = this.mediaManager.getMedia(mediaId);
	this.mediaManager.readMedia(media, user);

    }

    @Override
    public List<Media> getMediaNotRead() {
	return this.mediaManager.recupererMediasNonVu();
    }

    @Override
    public void changeDescription(long mediaId, String description) {
	Media media = this.mediaManager.getMedia(mediaId);
	media.setDescription(description);
	this.mediaManager.modifierMedia(media);

    }

    @Override
    public void deleteMedia(long mediaId, String pathServeur) {
	Media media = this.mediaManager.recupererMedia(mediaId);
	this.mediaManager.supprimerMedia(media, pathServeur);

    }

    @Override
    public void deleteAlbum(long albumId, String pathServeur) {
	Album album = this.mediaManager.recupererAlbum(albumId);
	this.mediaManager.supprimerAlbum(album, pathServeur);
    }
}
