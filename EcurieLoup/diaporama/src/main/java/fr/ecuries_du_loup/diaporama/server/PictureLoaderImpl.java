package fr.ecuries_du_loup.diaporama.server;

import java.util.ArrayList;
import java.util.List;

import donnees.photo.Album;
import donnees.photo.Photo;

import service.photo.AlbumPhotoManager;

import fr.ecuries_du_loup.diaporama.client.engine.PictureLoader;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class PictureLoaderImpl implements PictureLoader {
	private AlbumPhotoManager albumPhotoManager;
	
	
	
	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	@Override
	public List<Picture> loadAlbum(long idAlbum) {
		Album album = this.albumPhotoManager.recupererAlbum(idAlbum);
		return this.getPictureOfAlbum(album);
	}

	@Override
	public List<Picture> loadAllPicture() {
		List<Album> albums = this.albumPhotoManager.recupererTousLesAlbums();
		List<Picture> liste = new ArrayList<Picture>();
		for(Album  album :albums){
			liste.addAll(this.getPictureOfAlbum(album));
		}
		return liste;
	}
	
	private List<Picture> getPictureOfAlbum(Album album){
		
		List<Picture> liste = new ArrayList<Picture>();
		for(Photo photo : album.getPhotos()){
			Picture picture = new Picture();
			picture.setId(photo.getId());
			liste.add(picture);
		}
		return liste;
	}
	
	

}
