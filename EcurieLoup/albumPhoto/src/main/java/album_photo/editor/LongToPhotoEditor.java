package album_photo.editor;

import java.beans.PropertyEditorSupport;

import service.photo.AlbumPhotoManager;
import donnees.photo.Photo;

public class LongToPhotoEditor extends PropertyEditorSupport {
	private AlbumPhotoManager albumPhotoManager;
	
	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long ihPhoto = Long.parseLong(text);
		Photo photo = this.albumPhotoManager.recupererPhoto(ihPhoto);
		this.setValue(photo);

	}
}
