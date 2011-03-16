package fr.ecuriesduloup.save.photo;

import java.util.Collection;

import donnees.photo.Media;

public interface SaveMaker {

	public void addRecoveryPhoto(Media photoRecovery);
	public void addRecoveryPhoto(Collection<Media> photosRecovery);
	
	public void addSavePhoto(Media photoSave);
	public void addSavePhoto(long idPhotoSave);
	
	public void addDeletePhoto(Media photoDelete);
	public void addDeletePhoto(long idPhotoDelete);
	
}
