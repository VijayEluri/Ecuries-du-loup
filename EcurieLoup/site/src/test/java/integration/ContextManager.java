package integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextManager {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if (ContextManager.context == null) {
			String[] fichiers = {
					"/src/main/webapp/WEB-INF/applicationContext-hibernate.xml",
					"/src/main/webapp/WEB-INF/applicationContext.xml",
					"../albumPhoto/src/main/resources/applicationContext-albumPhoto.xml",
					"../authentification/src/main/resources/applicationContext-authentification.xml",
					"/src/test/resources/applicationContext-baseDonnees-test.xml" };
			ContextManager.context = new FileSystemXmlApplicationContext(
					fichiers);
		}
		return ContextManager.context;
	}

}
