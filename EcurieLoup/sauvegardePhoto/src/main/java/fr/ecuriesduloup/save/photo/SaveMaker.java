package fr.ecuriesduloup.save.photo;

import java.util.Collection;

import donnees.photo.Photo;

public interface SaveMaker {

	public void addRecoveryPhoto(Photo photoRecovery);
	public void addRecoveryPhoto(Collection<Photo> photosRecovery);
	
	public void addSavePhoto(Photo photoSave);
	public void addSavePhoto(long idPhotoSave);
	
	public void addDeletePhoto(Photo photoDelete);
	public void addDeletePhoto(long idPhotoDelete);
	
}
