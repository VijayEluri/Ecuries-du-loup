package service.photo.securite;

import service.photo.AlbumPhotoManager;

public abstract class AlbumPhotoSecuriteDecorateur implements AlbumPhotoManager {
	protected AlbumPhotoManager albumPhotoManager;

	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
	}

}
