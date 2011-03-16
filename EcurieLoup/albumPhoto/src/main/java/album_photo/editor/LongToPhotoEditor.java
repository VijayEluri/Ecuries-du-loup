package album_photo.editor;

import java.beans.PropertyEditorSupport;

import service.photo.MediaManager;
import donnees.photo.Media;

public class LongToPhotoEditor extends PropertyEditorSupport {
	private MediaManager mediaManager;
	
	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idMedia = Long.parseLong(text);
		Media media = this.mediaManager.recupererMedia(idMedia);
		this.setValue(media);

	}
}
