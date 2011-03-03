package news.test;

import integration.UserInBase;

import java.util.Date;

import donnees.news.Nouvelle;


public final class NewsTestUtil {

	private NewsTestUtil(){		
	}
	
	public static Nouvelle getNewObject() {
		Nouvelle nouvelle = new Nouvelle();
		nouvelle.setTitre("titre de la nouvelle nouvelle");
		nouvelle.setAuteur(UserInBase.getUtilisateurSansDroit());
		nouvelle.setContenu("contenu de la nouvelle nouvelle");
		nouvelle.setDateCreation(new Date().getTime());
		nouvelle.setDateDerniereModification(0);
		return nouvelle;
	}
	
	public static void modificationObject(Nouvelle t) {
		t.setTitre("titre de la nouvelle nouvelle modifier");
		t.setDateDerniereModification(new Date().getTime());
		
	}
}
