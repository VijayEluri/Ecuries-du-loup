package fr.ecuriesduloup.save.photo.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextManagerPhotoBackup {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if(ContextManagerPhotoBackup.context==null){
			String[] fichiers = {"/src/test/resources/applicationContext-hibernate.xml",
					"/src/main/resources/applicationContext-photoBackup.xml",
					"/src/test/resources/applicationContext-baseDonnees-test.xml"};
			ContextManagerPhotoBackup.context = new FileSystemXmlApplicationContext(fichiers);
		}
		return ContextManagerPhotoBackup.context;
	}
	
	
}
