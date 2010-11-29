package unitaire.edlcode;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import service.smiley.SmileyManager;
import donnees.smiley.Smiley;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;

public class EdlCodeHTMLTest {
	private EdlCode edlCode;
	private SmileyManager smileyManager;

	@Before
	public void setUp() throws Exception {
		this.edlCode = new EdlCode();
		this.smileyManager = EasyMock.createMock(SmileyManager.class);
		this.edlCode.setSmileyManager(smileyManager);

		EasyMock.expect(this.smileyManager.recupererTousLesSmiley()).andReturn(new ArrayList<Smiley>());
		EasyMock.replay(this.smileyManager);
	}

	private void testEgaliteDuParsage(String texte, String resultatAttendu){
		String resultatObtenu;
		try {
			resultatObtenu = this.edlCode.parse(texte, "");
			assertEquals(resultatAttendu, resultatObtenu);
		} catch (EdlCodeEncodageException e) {
			e.printStackTrace();
		}
	}

	private void testErreurDuParsage(String texte){
		try {
			String test = this.edlCode.parse(texte, "");
			System.err.println(test);
			fail("pas de jeter d'exception");
		} catch (EdlCodeEncodageException e) {
			
		}
	}

	@Test
	public void testLien() {
		String texte = "[lien=\"http://www.google.fr\"]goole[/lien]";
		String resultatAttendu = "<a href=\"http://www.google.fr\">goole</a>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	@Test
	public void testImage() {
		String texte = "[image=\"/image/test/image.png\"]";
		String resultatAttendu = "<img src=\"/image/test/image.png\" alt=\"/image/test/image.png\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testImageWithLargeur() {
		String texte = "[image=\"/image/test/image.png\" largeur=\"90%\"]";
		String resultatAttendu = "<img src=\"/image/test/image.png\" alt=\"/image/test/image.png\" width=\"90%\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testImageWithHauteur() {
		String texte = "[image=\"/image/test/image.png\" hauteur=\"80%\"]";
		String resultatAttendu = "<img src=\"/image/test/image.png\" alt=\"/image/test/image.png\" height=\"80%\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testImageWithHauteurAndLargeur() {
		String texte = "[image=\"/image/test/image.png\" hauteur=\"80%\" largeur=\"90%\"]";
		String resultatAttendu = "<img src=\"/image/test/image.png\" alt=\"/image/test/image.png\" height=\"80%\" width=\"90%\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	
	
	@Test
	public void testImageSite() {
		String texte = "[imageSite=\"1\"]";
		String resultatAttendu = "<img src=\"/images/albumPhoto/1\" alt=\"image 1 inexistante \" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testImageSiteWithLargeur() {
		String texte = "[imageSite=\"1\" largeur=\"90%\"]";
		String resultatAttendu = "<img src=\"/images/albumPhoto/1\" alt=\"image 1 inexistante \" width=\"90%\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testImageSiteWithHauteur() {
		String texte = "[imageSite=\"1\" hauteur=\"80%\"]";
		String resultatAttendu = "<img src=\"/images/albumPhoto/1\" alt=\"image 1 inexistante \" height=\"80%\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testImageSiteWithHauteurAndLargeur() {
		String texte = "[imageSite=\"1\" hauteur=\"80%\" largeur=\"90%\"]";
		String resultatAttendu = "<img src=\"/images/albumPhoto/1\" alt=\"image 1 inexistante \" height=\"80%\" width=\"90%\" />";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}


	@Test
	public void testTitre() {
		String texte = "[titre=1]Titre[/titre]";
		String resultatAttendu = "<h1>Titre</h1>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	/*@Test
	public void testTitreTropPetit() {
		String texte = "[titre=7]Titre[/titre]";
		this.testErreurDuParsage(texte);
	}*/

	@Test
	public void testAccent() {
		String texte = "é!èà";
		String resultatAttendu = "&eacute;!&egrave;&agrave;";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	/*
	@Test
	public void testListe() {
		String texte = "\t* objet 1\n\t* objet 2";
		String resultatAttendu = "<ul><li>objet 1</li><li>objet 2</li><ul>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	@Test
	public void testListeDouble() {
		String texte = "\n\t*objet 1\n\t* objet 2\nrien\t* objet 1\n\t* objet 2";
		String resultatAttendu = "<ul><li>objet 1</li><li>objet 2</li><ul>rien<ul><li>objet 1</li><li>objet 2</li><ul>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	 */

	@Test
	public void testSmiley() {
		this.smileyManager = EasyMock.createMock(SmileyManager.class);
		this.edlCode.setSmileyManager(smileyManager);
		List<Smiley> listeDeSmileys = new ArrayList<Smiley>();
		Smiley smiley1 = new Smiley();
		smiley1.setId(1);
		smiley1.setCode("testSmiley1");
		listeDeSmileys.add(smiley1);
		Smiley smiley2 = new Smiley();
		smiley2.setId(2);
		smiley2.setCode("testSmiley2");
		listeDeSmileys.add(smiley2);

		EasyMock.expect(this.smileyManager.recupererTousLesSmiley()).andReturn(listeDeSmileys);
		EasyMock.replay(this.smileyManager);
		String texte = "testSmiley1 bouh testSmiley2truc";
		String resultatAttendu = "<img src=\"/images/smiley/1\" alt=\"/images/smiley/1\" /> bouh <img src=\"/images/smiley/2\" alt=\"/images/smiley/2\" />truc";
	
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	@Test
	public void testTableau() {
		String texte = "[tableau][ligne][cellule]t1[/cellule][cellule]t2[/cellule][/ligne][ligne][cellule]t3[/cellule][cellule]t4[/cellule][/ligne][/tableau]";
		String resultatAttendu = "<table class=\"edlCode_tableau\"><tr><td>t1</td><td>t2</td></tr><tr><td>t3</td><td>t4</td></tr></table>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testTableauEspaceBR() {
		String texte = "[tableau] \n[ligne] \n[cellule]t1[/cellule] \n[cellule]t2[/cellule] \n[/ligne] \n[ligne][cellule]t3[/cellule] \n[cellule]t4[/cellule][/ligne][/tableau]";
		String resultatAttendu = "<table class=\"edlCode_tableau\"><tr><td>t1</td><td>t2</td></tr><tr><td>t3</td><td>t4</td></tr></table>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testTableauBR() {
		String texte = "[tableau]\n[ligne]\n[cellule]t1[/cellule]\n[cellule]t2[/cellule]\n[/ligne]\n[ligne]\n[cellule]t3[/cellule] \n[cellule]t4[/cellule]\n[/ligne][/tableau]";
		String resultatAttendu = "<table class=\"edlCode_tableau\"><tr><td>t1</td><td>t2</td></tr><tr><td>t3</td><td>t4</td></tr></table>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testTableauEspace2() {
		String texte = "[tableau] \n[ligne]\n[cellule]t1 dgfdf[/cellule]           \n\n[cellule]t2[/cellule]\n[/ligne]   \n[ligne]\n[cellule]t1[/cellule]\n[cellule]t2[/cellule]\n[/ligne][/tableau]";
		String resultatAttendu = "<table class=\"edlCode_tableau\"><tr><td>t1 dgfdf</td><td>t2</td></tr><tr><td>t1</td><td>t2</td></tr></table>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

}
