package service.photo.securite;

import service.photo.MediaManager;

public abstract class AlbumPhotoSecuriteDecorateur implements MediaManager {
	protected MediaManager mediaManager;

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}

}
