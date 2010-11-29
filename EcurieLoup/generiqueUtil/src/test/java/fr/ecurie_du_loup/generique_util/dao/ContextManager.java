package fr.ecurie_du_loup.generique_util.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextManager {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if(ContextManager.context==null){
			String[] fichiers = {"src/test/resources/applicationContext-generique.xml"};
			ContextManager.context = new FileSystemXmlApplicationContext(fichiers);
		}
		return ContextManager.context;
	}
	
	
}
