package smiley;


import static org.junit.Assert.assertEquals;
import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;

public class SmileyTestUtil {


	public static void compareJUnit(CategorieSmiley categorieSmiley1, CategorieSmiley categorieSmiley2) {
		assertEquals(categorieSmiley1.getId(), categorieSmiley2.getId());
		assertEquals(categorieSmiley1.getNom(), categorieSmiley2.getNom());
		assertEquals(categorieSmiley1.getOrdre(), categorieSmiley2.getOrdre());

	}


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


	public static void compareJUnit(Smiley smiley1, Smiley smiley2) {
		assertEquals(smiley1.getId(), smiley2.getId());
		assertEquals(smiley1.getCode(), smiley2.getCode());
		assertEquals(smiley1.getOrdre(), smiley2.getOrdre());
		assertEquals(smiley1.getCategorieSmiley().getId(), smiley2.getCategorieSmiley().getId());
		
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
