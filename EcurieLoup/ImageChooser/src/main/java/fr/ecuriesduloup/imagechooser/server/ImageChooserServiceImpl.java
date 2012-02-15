package fr.ecuriesduloup.imagechooser.server;

import java.util.ArrayList;
import java.util.List;

import service.photo.MediaManager;
import donnees.photo.Media;
import fr.ecuriesduloup.imagechooser.client.ImageChooserService;
import fr.ecuriesduloup.imagechooser.shared.Album;
import fr.ecuriesduloup.imagechooser.shared.Photo;

public class ImageChooserServiceImpl implements ImageChooserService{
	private MediaManager mediaManager;
	
	public void setMediaManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}



	@Override
	public List<Album> getListAlbum() {
		List<donnees.photo.Album> albums = this.mediaManager.recupererTousLesAlbums();
		

		List<Album> list = new ArrayList<Album>();
		for(donnees.photo.Album album : albums){
			Album albumDto = new Album();
			list.add(albumDto);
			albumDto.setId(album.getId());
			albumDto.setName(album.getTitre());
			
			for(Media media : album.getMedias()){
				Photo photoDto = new Photo();
				photoDto.setId(media.getId());
				
				albumDto.addPhoto(photoDto);
			}
		}
		return list;
	}

}
