package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;
import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;

public interface AlbumPhotoService {

	public long createAlbumPhoto(String name);
	public void createMedia(Media media, File photoFile, String pathServeur);
	public Album getAlbum(long albumId);
	public List<Album> getAlbums();
	public List<Media> getMediaWithHorse(long horseIdentifier);
	public List<Media> getMediaWithUser(User user);
}
