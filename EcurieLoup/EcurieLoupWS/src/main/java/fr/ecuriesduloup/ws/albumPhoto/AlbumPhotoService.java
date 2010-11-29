package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;

import donnees.photo.Album;
import donnees.photo.Photo;

public interface AlbumPhotoService {

	public long createAlbumPhoto(String name);
	public void createPhoto(Photo photo, File photoFile, String pathServeur);
	public Album getAlbum(long albumId);
}
