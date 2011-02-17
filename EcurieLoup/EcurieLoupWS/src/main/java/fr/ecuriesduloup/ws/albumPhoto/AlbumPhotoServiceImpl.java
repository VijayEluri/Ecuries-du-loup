package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.photo.AlbumPhotoManager;
import donnees.photo.Album;
import donnees.photo.Photo;
@Service
public class AlbumPhotoServiceImpl implements AlbumPhotoService {
	@Autowired
	private AlbumPhotoManager albumPhotoManager;

	
	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	@Override
	public long createAlbumPhoto(String name) {
		Album album = new Album();
		album.setTitre(name);
		this.albumPhotoManager.creerAlbum(album);
		return album.getId();
	}


	@Override
	public void createPhoto(Photo photo, File photoFile, String pathServeur) {
		this.albumPhotoManager.creerPhoto(photo, photoFile, pathServeur);
	}

	@Override
	public Album getAlbum(long albumId) {
		return this.albumPhotoManager.recupererAlbum(albumId);
	}

	@Override
	public List<Album> getAlbums() {
		return this.albumPhotoManager.recupererTousLesAlbums();
	}

}
