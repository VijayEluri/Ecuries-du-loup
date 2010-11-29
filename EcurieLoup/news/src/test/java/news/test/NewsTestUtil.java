package news.test;

import static org.junit.Assert.assertEquals;
import integration.UserInBase;

import java.util.Date;

import donnees.news.Nouvelle;


public final class NewsTestUtil {

	private NewsTestUtil(){		
	}
	
	public static void compareJUnit(Nouvelle t1, Nouvelle t2) {
		assertEquals(t1.getId(), t2.getId());
		assertEquals(t1.getTitre(), t2.getTitre());
		assertEquals(t1.getContenu(), t2.getContenu());
		assertEquals(t1.getAuteur(), t2.getAuteur());
		assertEquals(t1.getDateCreation(), t2.getDateCreation());
		assertEquals(t1.getDateDerniereModification(), t2.getDateDerniereModification());
		
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
