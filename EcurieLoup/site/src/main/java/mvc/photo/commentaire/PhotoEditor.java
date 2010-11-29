package mvc.photo.commentaire;

import java.beans.PropertyEditorSupport;

import service.photo.AlbumPhotoManager;
import donnees.photo.Photo;

public class PhotoEditor extends PropertyEditorSupport {
	private AlbumPhotoManager albumPhotoManager;

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long id = 0;
		try {
			id = Long.parseLong(text);
			Photo photo = this.albumPhotoManager.recupererPhoto(id);
			this.setValue(photo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}
