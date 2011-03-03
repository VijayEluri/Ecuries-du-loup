package fr.ecuriesduloup.save.photo.test;

import java.io.File;
import java.util.Date;

import fr.ecuriesduloup.save.photo.data.PhotoBackup;


//TODO : transphormer sa en classe générique et supprimer les static ...
public class PhotoBackupTestUtil {
	
	public static PhotoBackup getNewObject() {
		PhotoBackup photoBackup = new PhotoBackup();
		
		//because id is assigned
		long id = new Date().getTime();
		photoBackup.setId(id);
		photoBackup.setFile(new File("./src/test/resources/2740502850_1.jpg"));
		
		return photoBackup;
	}

	public static  PhotoBackup getObjectInBase() {
		PhotoBackup photoBackup = new PhotoBackup();
		photoBackup.setId(1);
		photoBackup.setFile(new File("./src/test/resources/2577398569_1.jpg"));
		
		return photoBackup;
	}

	public static  void modificationObject(PhotoBackup photoBackup) {
		photoBackup.setFile(new File("./src/test/resources/17243_109014575779978_100000143089812_229364_6311184_n.jpg"));	
	}
}
