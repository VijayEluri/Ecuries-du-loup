package fr.ecuriesduloup.save.photo.service;

import java.io.File;

import donnees.photo.Photo;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;

public interface PhotoBackupManager extends DataBaseServiceWithLongId<PhotoBackup>{

	public void restorePhotoBackup(Photo photo);

	public boolean isOnHardDisk(Photo photo);
	
	public File getOnHardDisk(Photo photo);
}
