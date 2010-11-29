package integration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextManager {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if(ContextManager.context==null){
			String[] fichiers = {"/src/test/resources/applicationContext-hibernate.xml",
					"/src/main/resources/applicationContext-albumPhoto.xml",
					"/src/test/resources/applicationContext-baseDonnees-test.xml"};
			ContextManager.context = new FileSystemXmlApplicationContext(fichiers);
		}
		return ContextManager.context;
	}
	
	
}
