/*package smiley;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import service.smiley.SmileyManager;
import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;

public class SmileyManagerTest {
	private SmileyManager smileyManager;
	private ApplicationContext context;

	public SmileyManagerTest(){
		this.context =ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.smileyManager = (SmileyManager) this.context.getBean("smileyManager");
	}

	private void compare(CategorieSmiley categorieSmiley1, CategorieSmiley categorieSmiley2){
		assertEquals(categorieSmiley1.getId(), categorieSmiley2.getId());
		assertEquals(categorieSmiley1.getNom(), categorieSmiley2.getNom());
		assertEquals(categorieSmiley1.getOrdre(), categorieSmiley2.getOrdre());
	}

	private void compare(Smiley smiley1, Smiley smiley2){
		assertEquals(smiley1.getId(), smiley2.getId());
		assertEquals(smiley1.getCode(), smiley2.getCode());
		assertEquals(smiley1.getOrdre(), smiley2.getOrdre());
		assertEquals(smiley1.getCategorieSmiley().getId(), smiley2.getCategorieSmiley().getId());
	}

	@Test
	public void testRecupererTousLesSmileyAvec1SeulElement() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);

		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(1);
		smileysouhaiter.setCode("code pour ");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(1);

		List<Smiley> smileysRecuperer = this.smileyManager.recupererTousLesSmiley();

		this.compare(smileysouhaiter, smileysRecuperer.get(0));
	}

	@Test
	public void testRecupererSmiley() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);

		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(1);
		smileysouhaiter.setCode("code pour ");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(1);

		Smiley smileyRecuperer = this.smileyManager.recupererSmiley(smileysouhaiter.getId());

		this.compare(smileysouhaiter, smileyRecuperer);
	}

	@Test
	public void testCreerSmiley() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);

		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(2);
		smileysouhaiter.setCode("cdCreation");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(2);

		this.smileyManager.creerSmiley(smileysouhaiter, new File(""));

		Smiley smileyRecuperer = this.smileyManager.recupererSmiley(smileysouhaiter.getId());

		this.compare(smileysouhaiter, smileyRecuperer);

		this.smileyManager.supprimerSmiley(smileysouhaiter);
	}

	@Test
	@Ignore
	public void testCreerSmileyCodeTropLong() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);

		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(2);
		smileysouhaiter.setCode("code vraiment vraiment vraiment trop long");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(2);

		this.smileyManager.creerSmiley(smileysouhaiter, new File(""));

		Smiley smileyRecuperer = this.smileyManager.recupererSmiley(smileysouhaiter.getId());

		this.compare(smileysouhaiter, smileyRecuperer);

		this.smileyManager.supprimerSmiley(smileysouhaiter);
	}

	@Test
	public void testModifierSmiley() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);

		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(2);
		smileysouhaiter.setCode("cdModif");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(2);

		this.smileyManager.creerSmiley(smileysouhaiter, new File(""));

		smileysouhaiter.setCode("132");

		this.smileyManager.modifierSmiley(smileysouhaiter);

		Smiley smileyRecuperer = this.smileyManager.recupererSmiley(smileysouhaiter.getId());

		this.compare(smileysouhaiter, smileyRecuperer);

		this.smileyManager.supprimerSmiley(smileysouhaiter);
	}

	@Test
	public void testSupprimerSmiley() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);

		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(2);
		smileysouhaiter.setCode("cdModif");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(2);

		this.smileyManager.creerSmiley(smileysouhaiter, new File(""));


		Smiley smileyRecuperer = this.smileyManager.recupererSmiley(smileysouhaiter.getId());

		assertNotNull(smileyRecuperer);

		this.smileyManager.supprimerSmiley(smileysouhaiter);
		smileyRecuperer = this.smileyManager.recupererSmiley(smileysouhaiter.getId());

		assertNull(smileyRecuperer);
	}

	@Test
	public void testRecupererToutesLesCategoriesSmileyAvec1seulCategorie() {
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(1);
		categorieSmileySouhaiter.setNom("nom de la categorie de test");
		categorieSmileySouhaiter.setOrdre(1);

		List<CategorieSmiley> categoriesSmileyRecuperer = this.smileyManager.recupererToutesLesCategoriesSmiley();	

		this.compare(categorieSmileySouhaiter, categoriesSmileyRecuperer.get(0));
	}

	@Test
	public void testRecupererCategorieSmiley() {
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(1);
		categorieSmileySouhaiter.setNom("nom de la categorie de test");
		categorieSmileySouhaiter.setOrdre(1);

		CategorieSmiley categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());

		this.compare(categorieSmileySouhaiter, categorieSmileyRecuperer);
	}

	@Test
	public void testCreerCategorieSmiley() {
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(2);
		categorieSmileySouhaiter.setNom("nom de la categorie de test creation");
		categorieSmileySouhaiter.setOrdre(2);

		this.smileyManager.creerCategorieSmiley(categorieSmileySouhaiter);

		CategorieSmiley categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());

		this.compare(categorieSmileySouhaiter, categorieSmileyRecuperer);

		this.smileyManager.supprimerCategorieSmiley(categorieSmileyRecuperer);

	}

	@Test
	public void testModifierCategorieSmiley() {
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(2);
		categorieSmileySouhaiter.setNom("nom de la categorie de test modification");
		categorieSmileySouhaiter.setOrdre(2);

		this.smileyManager.creerCategorieSmiley(categorieSmileySouhaiter);

		categorieSmileySouhaiter.setNom("nom modifier");

		this.smileyManager.modifierCategorieSmiley(categorieSmileySouhaiter);

		CategorieSmiley categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());

		this.compare(categorieSmileySouhaiter, categorieSmileyRecuperer);

		this.smileyManager.supprimerCategorieSmiley(categorieSmileyRecuperer);
	}

	@Test
	public void testSupprimerCategorieSmiley() {
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(2);
		categorieSmileySouhaiter.setNom("nom de la categorie de test suppression");
		categorieSmileySouhaiter.setOrdre(2);

		this.smileyManager.creerCategorieSmiley(categorieSmileySouhaiter);

		CategorieSmiley categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());

		assertNotNull(categorieSmileyRecuperer);

		this.smileyManager.supprimerCategorieSmiley(categorieSmileyRecuperer);

		categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());

		assertNull(categorieSmileyRecuperer);
	}
	
	@Test
	public void testSupprimerCategorieSmileyAvecSmiley() {
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(2);
		categorieSmileySouhaiter.setNom("nom de la categorie de test suppression");
		categorieSmileySouhaiter.setOrdre(2);
		categorieSmileySouhaiter.setSmileys(new ArrayList<Smiley>());
		
		
		Smiley smiley = new Smiley();
		smiley.setId(2);
		smiley.setCode("codeDelCat"+new Date());
		smiley.setCategorieSmiley(categorieSmileySouhaiter);

		this.smileyManager.creerCategorieSmiley(categorieSmileySouhaiter);
		this.smileyManager.creerSmiley(smiley,  new File(""));

		CategorieSmiley categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());
		
		Smiley smileyRecuperer = this.smileyManager.recupererSmiley(smiley.getId());

		assertNotNull(categorieSmileyRecuperer);
		assertNotNull(smileyRecuperer);


		this.smileyManager.supprimerCategorieSmiley(categorieSmileyRecuperer);

		categorieSmileyRecuperer = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());
		smileyRecuperer = this.smileyManager.recupererSmiley(smiley.getId());

		assertNull(categorieSmileyRecuperer);
		assertNull(smileyRecuperer);
	}

	@Test
	public void testModifierOrdreCategorieSmileyInt() {
		CategorieSmiley categorieSmileyDeBase = new CategorieSmiley();
		categorieSmileyDeBase.setId(1);
		categorieSmileyDeBase.setNom("nom de la categorie de test");
		categorieSmileyDeBase.setOrdre(1);
		
		CategorieSmiley categorieSmileySouhaiter = new CategorieSmiley();
		categorieSmileySouhaiter.setId(2);
		categorieSmileySouhaiter.setNom("nom de la categorie de test suppression");
		categorieSmileySouhaiter.setOrdre(2);

		this.smileyManager.creerCategorieSmiley(categorieSmileySouhaiter);

		this.smileyManager.modifierOrdre(categorieSmileySouhaiter, 1);
		
		CategorieSmiley categorieSmileyPremier = this.smileyManager.recupererCategorieSmiley(categorieSmileySouhaiter.getId());
		CategorieSmiley categorieSmileySecond = this.smileyManager.recupererCategorieSmiley(categorieSmileyDeBase.getId());
	
		assertEquals(1, categorieSmileyPremier.getOrdre());
		
		assertEquals(2, categorieSmileySecond.getOrdre());
		
		this.smileyManager.supprimerCategorieSmiley(categorieSmileyPremier);
	
		categorieSmileySecond = this.smileyManager.recupererCategorieSmiley(categorieSmileyDeBase.getId());
		
		assertEquals(1, categorieSmileySecond.getOrdre());
	}

	@Test
	public void testModifierOrdreSmileyInt() {
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(1);
		
		Smiley smileysouhaiter = new Smiley();
		smileysouhaiter.setId(2);
		smileysouhaiter.setCode("code");
		smileysouhaiter.setCategorieSmiley(categorieSmiley);
		smileysouhaiter.setOrdre(2);
		categorieSmiley.getSmileys().add(smileysouhaiter);
		
		this.smileyManager.creerSmiley(smileysouhaiter,  new File(""));
		
		this.smileyManager.modifierOrdre(smileysouhaiter, 3);
		
		smileysouhaiter = this.smileyManager.recupererSmiley(smileysouhaiter.getId());
		Smiley smileyBase = this.smileyManager.recupererSmiley(1);
	
		assertEquals(3, smileysouhaiter.getOrdre());
		assertEquals(1, smileyBase.getOrdre());
		
		this.smileyManager.supprimerSmiley(smileysouhaiter);
		smileyBase = this.smileyManager.recupererSmiley(smileyBase.getId());
		assertEquals(1, smileyBase.getOrdre());
	}

}*/
