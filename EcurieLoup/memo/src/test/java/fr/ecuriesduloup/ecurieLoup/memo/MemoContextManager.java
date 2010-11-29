package fr.ecuriesduloup.ecurieLoup.memo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MemoContextManager {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if(MemoContextManager.context==null){
			String[] fichiers = {
					"/src/main/resources/applicationContext-memo.xml",
					"/src/test/resources/applicationContext-hibernate.xml",
					"/src/test/resources/applicationContext-baseDonnees-test.xml"};
			MemoContextManager.context = new FileSystemXmlApplicationContext(fichiers);
		}
		return MemoContextManager.context;
	}
}
