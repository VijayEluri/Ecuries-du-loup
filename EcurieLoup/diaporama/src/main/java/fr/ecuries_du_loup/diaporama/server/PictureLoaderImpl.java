package fr.ecuries_du_loup.diaporama.server;

import java.util.ArrayList;
import java.util.List;

import service.photo.MediaManager;
import donnees.photo.Album;
import donnees.photo.Media;
import fr.ecuries_du_loup.diaporama.client.engine.PictureLoader;
import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public class PictureLoaderImpl implements PictureLoader {
	private MediaManager mediaManager;
	
	
	
	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	@Override
	public List<Picture> loadAlbum(long idAlbum) {
		Album album = this.mediaManager.recupererAlbum(idAlbum);
		return this.getPictureOfAlbum(album);
	}

	@Override
	public List<Picture> loadAllPicture() {
		List<Album> albums = this.mediaManager.recupererTousLesAlbums();
		List<Picture> liste = new ArrayList<Picture>();
		for(Album  album :albums){
			liste.addAll(this.getPictureOfAlbum(album));
		}
		return liste;
	}
	
	private List<Picture> getPictureOfAlbum(Album album){
		
		List<Picture> liste = new ArrayList<Picture>();
		for(Media media : album.getMedias()){
			Picture picture = new Picture();
			picture.setId(media.getId());
			liste.add(picture);
		}
		return liste;
	}
	
	

}
