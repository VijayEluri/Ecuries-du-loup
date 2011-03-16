package fr.ecuriesduloup.save.photo.service;

import java.io.File;

import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;

public interface PhotoBackupManager extends DataBaseServiceWithLongId<PhotoBackup>{

	public void restorePhotoBackup(Media photo);

	public boolean isOnHardDisk(Media photo);
	
	public File getOnHardDisk(Media photo);
}
