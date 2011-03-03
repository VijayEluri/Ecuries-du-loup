package smiley;


import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;

public class SmileyTestUtil {



	public static CategorieSmiley getNewCategorieSmiley() {
		CategorieSmiley categorieSmiley = new CategorieSmiley();
		int id = (int) (Math.random()*10000);
		categorieSmiley.setId(id);
		categorieSmiley.setNom("nom de la categorie de test");
		return categorieSmiley;
	}


	public static void modificationObject(CategorieSmiley t) {
		t.setNom("nom update");		
	}


	
	
	public static Smiley getNewSmiley() {
		Smiley smiley = new Smiley();
		int id = (int) (Math.random()*10000);
		smiley.setId(id);
		smiley.setCode("a"+Math.random());
		smiley.setCode(smiley.getCode().substring(0, 10));
		smiley.setCategorieSmiley(DataInBase.getCategorieSmiley());
		return smiley;
	}


	public static void modificationObject(Smiley t) {
		t.setCode("a"+Math.random());
		t.setCode(t.getCode().substring(0, 10));
		
	}
}
