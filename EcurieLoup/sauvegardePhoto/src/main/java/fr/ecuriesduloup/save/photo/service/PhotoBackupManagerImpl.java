package fr.ecuriesduloup.save.photo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import util.MiniatureUtil;
import donnees.MemoireVariable;
import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;

public class PhotoBackupManagerImpl extends DataBaseServiceWithDaoIdLongUtilAndLongId<PhotoBackup> implements PhotoBackupManager {

	private String emplacementPhoto;
	private MiniatureUtil miniatureUtil;
	
	

	public void setEmplacementPhoto(String emplacementPhoto) {
		this.emplacementPhoto = emplacementPhoto;
	}

	public void setMiniatureUtil(MiniatureUtil miniatureUtil) {
		this.miniatureUtil = miniatureUtil;
	}

	@Override
	public boolean isOnHardDisk(Media photo) {
		File photoFile = new File(this.getPathPhoto(photo));
		return photoFile.exists();		
	}
	private String getPathPhoto(Media photo){
		String pathPhoto = MemoireVariable.optenirVariable("pathServeur")+"/";
		pathPhoto += this.emplacementPhoto + "/";
		pathPhoto += photo.getId();

		return pathPhoto;
	}
	
	@Override
	public File getOnHardDisk(Media photo) {
		File photoFile = new File(this.getPathPhoto(photo));
		return photoFile;
	}
	
	
	
	private String getPathPhotoMiniature(Media photo){
		String pathPhoto = MemoireVariable.optenirVariable("pathServeur")+"/";
		pathPhoto += this.emplacementPhoto + "/";
		pathPhoto += "miniatures/";
		pathPhoto += photo.getId();

		return pathPhoto;
	}

	@Override
	public void restorePhotoBackup(Media photo) {
		PhotoBackup photoBackup = this.getById(photo.getId());
		byte[] photoBackupFile = photoBackup.getFile();

		String pathPhoto = this.getPathPhoto(photo);

		this.createFile(photoBackupFile, pathPhoto);

		String pathPhotoMiniature = this.getPathPhotoMiniature(photo);
		try {
			this.miniatureUtil.creerMiniaturesPhoto(pathPhoto,pathPhotoMiniature
					, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createFile(byte[] photoBackupFile, String pathPhoto) {
		File newFile = new File(pathPhoto);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(newFile);
			try {
				fos.write(photoBackupFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	

}
