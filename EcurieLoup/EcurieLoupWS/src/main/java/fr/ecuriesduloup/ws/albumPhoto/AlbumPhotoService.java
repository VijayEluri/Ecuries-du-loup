package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;
import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.commentaire.Commentaire;

public interface AlbumPhotoService {

    // album bloc
    public long createAlbumPhoto(String name);

    public Album getAlbum(long albumId);

    public List<Album> getAlbums();

    // media bloc
    public Media getMedia(long mediaId);

    public List<Media> getMediaWithHorse(long horseIdentifier);

    public List<Media> getMediaWithUser(User user);

    public List<Media> getMediaNotRead();

    public void createMedia(Media media, File photoFile, String pathServeur);

    public void readMedia(long mediaId, User user);

    // comment bloc
    public List<Commentaire> getComments(long mediaId);

    public Commentaire getComment(long commentId);

    public Commentaire createComment(Commentaire comment);

    public void deleteComment(long commentId);
}
