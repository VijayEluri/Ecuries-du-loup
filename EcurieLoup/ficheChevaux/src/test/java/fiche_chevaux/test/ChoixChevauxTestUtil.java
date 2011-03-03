package fiche_chevaux.test;

import java.util.Date;

import fiche_chevaux.donnees.Choix;
import fiche_chevaux.donnees.Owner;
import fiche_chevaux.donnees.Surnom;


public final class ChoixChevauxTestUtil {

	private ChoixChevauxTestUtil(){		
	}
	
	
	public static void modificationObject(Choix t) {
		t.setNom("nouveau nom "+new Date().getTime());
		
	}
	
	
	public static void modificationObject(Surnom t) {
		t.setSurnom("nouveau surnom");
		
	}
	public static void modificationObject(Owner t) {
		t.setName("nouveau name");
		
	}
}
