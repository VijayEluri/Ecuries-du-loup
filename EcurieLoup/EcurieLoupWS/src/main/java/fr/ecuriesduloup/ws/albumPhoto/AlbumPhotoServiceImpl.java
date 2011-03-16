package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.photo.MediaManager;
import donnees.photo.Album;
import donnees.photo.Media;
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
		return this.mediaManager.recupererAlbum(albumId);
	}

	@Override
	public List<Album> getAlbums() {
		return this.mediaManager.recupererTousLesAlbums();
	}

}
