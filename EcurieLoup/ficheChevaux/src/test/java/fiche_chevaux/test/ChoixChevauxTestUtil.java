package fiche_chevaux.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import fiche_chevaux.donnees.Choix;
import fiche_chevaux.donnees.Owner;
import fiche_chevaux.donnees.Surnom;


public final class ChoixChevauxTestUtil {

	private ChoixChevauxTestUtil(){		
	}
	
	public static void compareJUnit(Choix t1, Choix t2) {
		assertEquals(t1.getId(), t2.getId());
		assertEquals(t1.getNom(), t2.getNom());
		
	}
	
	public static void modificationObject(Choix t) {
		t.setNom("nouveau nom "+new Date().getTime());
		
	}
	
	public static void compareJUnit(Surnom t1, Surnom t2) {
		assertEquals(t1.getId(), t2.getId());
		assertEquals(t1.getSurnom(), t2.getSurnom());
		assertEquals(t1.getFiche(), t2.getFiche());
		
	}
	public static void modificationObject(Surnom t) {
		t.setSurnom("nouveau surnom");
		
	}
	
	public static void compareJUnit(Owner t1, Owner t2) {
		assertEquals(t1.getId(), t2.getId());
		assertEquals(t1.getName(), t2.getName());
		assertEquals(t1.getUser(), t2.getUser());
		
	}
	
	public static void modificationObject(Owner t) {
		t.setName("nouveau name");
		
	}
}
