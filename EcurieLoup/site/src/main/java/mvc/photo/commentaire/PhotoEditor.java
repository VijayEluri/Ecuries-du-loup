package mvc.photo.commentaire;

import java.beans.PropertyEditorSupport;

import service.photo.MediaManager;
import donnees.photo.Media;

public class PhotoEditor extends PropertyEditorSupport {
	private MediaManager mediaManager;

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long id = 0;
		try {
			id = Long.parseLong(text);
			Media photo = this.mediaManager.recupererMedia(id);
			this.setValue(photo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}
