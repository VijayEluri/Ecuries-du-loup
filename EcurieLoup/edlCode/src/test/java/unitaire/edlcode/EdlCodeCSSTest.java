package unitaire.edlcode;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import service.smiley.SmileyManager;
import donnees.smiley.Smiley;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;
import fr.ecuriesduloup.siteoptions.data.Option;
import fr.ecuriesduloup.siteoptions.service.OptionsService;

public class EdlCodeCSSTest {
	private EdlCode edlCode;
	private SmileyManager smileyManager;
	private OptionsService optionsService;
	
	@Before
	public void setUp() throws Exception {
		this.edlCode = new EdlCode();
		this.smileyManager = EasyMock.createMock(SmileyManager.class);
		this.optionsService = EasyMock.createMock(OptionsService.class);
		this.edlCode.setSmileyManager(smileyManager);
		this.edlCode.setOptionsService(optionsService);
		
		EasyMock.expect(this.smileyManager.recupererTousLesSmiley()).andReturn(new ArrayList<Smiley>());
		Option option = new Option();
		option.setValue("1");
		EasyMock.expect(this.optionsService.get("bigadin")).andReturn(option);
		EasyMock.replay(this.smileyManager);
	}
	
	private void testEgaliteDuParsage(String texte, String resultatAttendu){
		String resultatObtenu;
		try {
			resultatObtenu = this.edlCode.parse(texte);
			assertEquals(resultatAttendu, resultatObtenu);
		} catch (EdlCodeEncodageException e) {
			
			e.printStackTrace();
			fail();
		}
	}
	
	private void testErreurDuParsage(String texte){
		try {
			String test = this.edlCode.parse(texte);
			System.err.println(test);
			fail("pas de jeter d'exception");
		} catch (EdlCodeEncodageException e) {
		}
	}
	@Test
	public void testChaineVide() {
		String texte = "";
		String resultatAttendu = "";

		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineBlanc() {
		String texte = "   ";
		String resultatAttendu = "   ";

		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineRetourALaLigne() {
		String texte = "avantRetour\napresRetour";
		String resultatAttendu = "avantRetour<br />\napresRetour";

		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	@Test
	public void testChaineSansBalise() {
		String texte = "test sans balise";
		String resultatAttendu = "test sans balise";

		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	@Test
	public void testChaineGras() {
		String texte = "[gras]test gras[/gras]";
		String resultatAttendu = "<span class=\"edlCode_gras\">test gras</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteGras() {
		String texte = "[gras]test gras[/gras] test pas gras [gras]test gras[/gras]";
		String resultatAttendu = "<span class=\"edlCode_gras\">test gras</span> test pas gras <span class=\"edlCode_gras\">test gras</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineGrasRecursif() {
		String texte = "[gras][gras]test gras plus[/gras][/gras] test pas gras";
		String resultatAttendu = "<span class=\"edlCode_gras\"><span class=\"edlCode_gras\">test gras plus</span></span> test pas gras";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineGrasRecursifAvecPharse() {
		String texte = "[gras]gras moins[gras]test gras plus[/gras]gras moins apres[/gras] test pas gras";
		String resultatAttendu = "<span class=\"edlCode_gras\">gras moins<span class=\"edlCode_gras\">test gras plus</span>gras moins apres</span> test pas gras";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineGrasRecursifFermetureAvantOuverture() {
		String texte = "[/gras]gras moins[gras]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineItalique() {
		String texte = "[italique]test italique[/italique]";
		String resultatAttendu = "<span class=\"edlCode_italique\">test italique</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteItalique() {
		String texte = "[italique]test italique[/italique] test pas italique [italique]test italique[/italique]";
		String resultatAttendu = "<span class=\"edlCode_italique\">test italique</span> test pas italique <span class=\"edlCode_italique\">test italique</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineItaliqueRecursif() {
		String texte = "[italique][italique]test italique plus[/italique][/italique] test pas italique";
		String resultatAttendu = "<span class=\"edlCode_italique\"><span class=\"edlCode_italique\">test italique plus</span></span> test pas italique";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineItaliqueRecursifAvecPharse() {
		String texte = "[italique]italique moins[italique]test italique plus[/italique]italique moins apres[/italique] test pas italique";
		String resultatAttendu = "<span class=\"edlCode_italique\">italique moins<span class=\"edlCode_italique\">test italique plus</span>italique moins apres</span> test pas italique";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineItaliqueRecursifFermetureAvantOuverture() {
		String texte = "[/italique]gras moins[italique]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineSouligne() {
		String texte = "[souligne]test souligne[/souligne]";
		String resultatAttendu = "<span class=\"edlCode_souligne\">test souligne</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteSouligne() {
		String texte = "[souligne]test souligne[/souligne] test pas souligne [souligne]test souligne[/souligne]";
		String resultatAttendu = "<span class=\"edlCode_souligne\">test souligne</span> test pas souligne <span class=\"edlCode_souligne\">test souligne</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineSouligneRecursif() {
		String texte = "[souligne][souligne]test souligne plus[/souligne][/souligne] test pas souligne";
		String resultatAttendu = "<span class=\"edlCode_souligne\"><span class=\"edlCode_souligne\">test souligne plus</span></span> test pas souligne";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSouligneRecursifAvecPharse() {
		String texte = "[souligne]souligne moins[souligne]test souligne plus[/souligne]souligne moins apres[/souligne] test pas souligne";
		String resultatAttendu = "<span class=\"edlCode_souligne\">souligne moins<span class=\"edlCode_souligne\">test souligne plus</span>souligne moins apres</span> test pas souligne";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSouligneRecursifFermetureAvantOuverture() {
		String texte = "[/souligne]gras moins[souligne]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineBarre() {
		String texte = "[barre]test barre[/barre]";
		String resultatAttendu = "<span class=\"edlCode_barre\">test barre</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteBarre() {
		String texte = "[barre]test barre[/barre] test pas barre [barre]test barre[/barre]";
		String resultatAttendu = "<span class=\"edlCode_barre\">test barre</span> test pas barre <span class=\"edlCode_barre\">test barre</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineBarreRecursif() {
		String texte = "[barre][barre]test barre plus[/barre][/barre] test pas barre";
		String resultatAttendu = "<span class=\"edlCode_barre\"><span class=\"edlCode_barre\">test barre plus</span></span> test pas barre";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineBarreRecursifAvecPharse() {
		String texte = "[barre]barre moins[barre]test barre plus[/barre]barre moins apres[/barre] test pas barre";
		String resultatAttendu = "<span class=\"edlCode_barre\">barre moins<span class=\"edlCode_barre\">test barre plus</span>barre moins apres</span> test pas barre";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineBarreRecursifFermetureAvantOuverture() {
		String texte = "[/barre]gras moins[barre]";
		this.testErreurDuParsage(texte);
	}
	@Test
	public void testChainePolice() {
		String texte = "[police=\"Arial Black\"]test police[/police]";
		String resultatAttendu = "<span style='font-family:\"Arial Black\" ; ' >test police</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuitePolice() {
		String texte = "[police=\"Arial Black\"]test police[/police] test pas police [police=\"Verdana\"]test police[/police]";
		String resultatAttendu = "<span style='font-family:\"Arial Black\" ; ' >test police</span> test pas police <span style='font-family:\"Verdana\" ; ' >test police</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChainePoliceRecursif() {
		String texte = "[police=\"Arial Black\"][police=\"Verdana\"]test police plus[/police][/police] test pas police";
		String resultatAttendu = "<span style='font-family:\"Arial Black\" ; ' ><span style='font-family:\"Verdana\" ; ' >test police plus</span></span> test pas police";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChainePoliceRecursifAvecPharse() {
		String texte = "[police=\"Arial Black\"]police moins[police=\"Verdana\"]test police plus[/police]police moins apres[/police] test pas police";
		String resultatAttendu = "<span style='font-family:\"Arial Black\" ; ' >police moins<span style='font-family:\"Verdana\" ; ' >test police plus</span>police moins apres</span> test pas police";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	
	
	
	
	@Test
	public void testChainePoliceRecursifFermetureAvantOuverture() {
		String texte = "[/police]gras moins[police=\"Arial Black\"]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineTaille11OPourCent() {
		String texte = "[taille=\"110%\"]test taille pour cent[/taille]";
		String resultatAttendu = "<span style='font-size:110% ; ' >test taille pour cent</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineTaille1PourCent() {
		String texte = "[taille=\"1%\"]test taille pour cent[/taille]";
		String resultatAttendu = "<span style='font-size:1% ; ' >test taille pour cent</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}

	
	@Test
	public void testChaineSuiteTaille() {
		String texte = "[taille=\"90%\"]test taille[/taille] test pas taille [taille=\"110%\"]test taille[/taille]";
		String resultatAttendu = "<span style='font-size:90% ; ' >test taille</span> test pas taille <span style='font-size:110% ; ' >test taille</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineTailleRecursif() {
		String texte = "[taille=\"90%\"][taille=\"110%\"]test taille plus[/taille][/taille] test pas taille";
		String resultatAttendu = "<span style='font-size:90% ; ' ><span style='font-size:110% ; ' >test taille plus</span></span> test pas taille";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineTailleRecursifAvecPharse() {
		String texte = "[taille=\"90%\"]taille moins[taille=\"110%\"]test taille plus[/taille]taille moins apres[/taille] test pas taille";
		String resultatAttendu = "<span style='font-size:90% ; ' >taille moins<span style='font-size:110% ; ' >test taille plus</span>taille moins apres</span> test pas taille";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineTailleFermetureAvantOuverture() {
		String texte = "[/taille]taille[taille=\"110%\"]";
		this.testErreurDuParsage(texte);
	}
	
	
	
	
	
	
	@Test
	public void testChaineClignote() {
		String texte = "[clignote]test clignote[/clignote]";
		String resultatAttendu = "<span class=\"edlCode_clignote\">test clignote</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteClignote() {
		String texte = "[clignote]test clignote[/clignote] test pas clignote [clignote]test clignote[/clignote]";
		String resultatAttendu = "<span class=\"edlCode_clignote\">test clignote</span> test pas clignote <span class=\"edlCode_clignote\">test clignote</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineClignoteRecursif() {
		String texte = "[clignote][clignote]test clignote plus[/clignote][/clignote] test pas clignote";
		String resultatAttendu = "<span class=\"edlCode_clignote\"><span class=\"edlCode_clignote\">test clignote plus</span></span> test pas clignote";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineClignoteRecursifAvecPharse() {
		String texte = "[clignote]clignote moins[clignote]test clignote plus[/clignote]clignote moins apres[/clignote] test pas clignote";
		String resultatAttendu = "<span class=\"edlCode_clignote\">clignote moins<span class=\"edlCode_clignote\">test clignote plus</span>clignote moins apres</span> test pas clignote";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineClignoteRecursifFermetureAvantOuverture() {
		String texte = "[/clignote]gras moins[clignote]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineGauche() {
		String texte = "[gauche]test gauche[/gauche]";
		String resultatAttendu = "<div class=\"edlCode_gauche\">test gauche</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteGauche() {
		String texte = "[gauche]test gauche[/gauche] test pas gauche [gauche]test gauche[/gauche]";
		String resultatAttendu = "<div class=\"edlCode_gauche\">test gauche</div> test pas gauche <div class=\"edlCode_gauche\">test gauche</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineGaucheRecursif() {
		String texte = "[gauche][gauche]test gauche plus[/gauche][/gauche] test pas gauche";
		String resultatAttendu = "<div class=\"edlCode_gauche\"><div class=\"edlCode_gauche\">test gauche plus</div></div> test pas gauche";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineGaucheRecursifAvecPharse() {
		String texte = "[gauche]gauche moins[gauche]test gauche plus[/gauche]gauche moins apres[/gauche] test pas gauche";
		String resultatAttendu = "<div class=\"edlCode_gauche\">gauche moins<div class=\"edlCode_gauche\">test gauche plus</div>gauche moins apres</div> test pas gauche";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineGaucheRecursifFermetureAvantOuverture() {
		String texte = "[/gauche]gras moins[gauche]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineDroite() {
		String texte = "[droite]test droite[/droite]";
		String resultatAttendu = "<div class=\"edlCode_droite\">test droite</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteDroite() {
		String texte = "[droite]test droite[/droite] test pas droite [droite]test droite[/droite]";
		String resultatAttendu = "<div class=\"edlCode_droite\">test droite</div> test pas droite <div class=\"edlCode_droite\">test droite</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineDroiteRecursif() {
		String texte = "[droite][droite]test droite plus[/droite][/droite] test pas droite";
		String resultatAttendu = "<div class=\"edlCode_droite\"><div class=\"edlCode_droite\">test droite plus</div></div> test pas droite";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineDroiteRecursifAvecPharse() {
		String texte = "[droite]droite moins[droite]test droite plus[/droite]droite moins apres[/droite] test pas droite";
		String resultatAttendu = "<div class=\"edlCode_droite\">droite moins<div class=\"edlCode_droite\">test droite plus</div>droite moins apres</div> test pas droite";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineDroiteRecursifFermetureAvantOuverture() {
		String texte = "[/droite]gras moins[droite]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineCentre() {
		String texte = "[centre]test centre[/centre]";
		String resultatAttendu = "<div class=\"edlCode_centre\">test centre</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteCentre() {
		String texte = "[centre]test centre[/centre] test pas centre [centre]test centre[/centre]";
		String resultatAttendu = "<div class=\"edlCode_centre\">test centre</div> test pas centre <div class=\"edlCode_centre\">test centre</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineCentreRecursif() {
		String texte = "[centre][centre]test centre plus[/centre][/centre] test pas centre";
		String resultatAttendu = "<div class=\"edlCode_centre\"><div class=\"edlCode_centre\">test centre plus</div></div> test pas centre";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineCentreRecursifAvecPharse() {
		String texte = "[centre]centre moins[centre]test centre plus[/centre]centre moins apres[/centre] test pas centre";
		String resultatAttendu = "<div class=\"edlCode_centre\">centre moins<div class=\"edlCode_centre\">test centre plus</div>centre moins apres</div> test pas centre";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineCentreRecursifFermetureAvantOuverture() {
		String texte = "[/centre]gras moins[centre]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineJustifie() {
		String texte = "[justifie]test justifie[/justifie]";
		String resultatAttendu = "<div class=\"edlCode_justifie\">test justifie</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteJustifie() {
		String texte = "[justifie]test justifie[/justifie] test pas justifie [justifie]test justifie[/justifie]";
		String resultatAttendu = "<div class=\"edlCode_justifie\">test justifie</div> test pas justifie <div class=\"edlCode_justifie\">test justifie</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineJustifieRecursif() {
		String texte = "[justifie][justifie]test justifie plus[/justifie][/justifie] test pas justifie";
		String resultatAttendu = "<div class=\"edlCode_justifie\"><div class=\"edlCode_justifie\">test justifie plus</div></div> test pas justifie";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineJustifieRecursifAvecPharse() {
		String texte = "[justifie]justifie moins[justifie]test justifie plus[/justifie]justifie moins apres[/justifie] test pas justifie";
		String resultatAttendu = "<div class=\"edlCode_justifie\">justifie moins<div class=\"edlCode_justifie\">test justifie plus</div>justifie moins apres</div> test pas justifie";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineJustifieRecursifFermetureAvantOuverture() {
		String texte = "[/justifie]gras moins[justifie]";
		this.testErreurDuParsage(texte);
	}
	
	
	@Test
	public void testChaineCouleur() {
		String texte = "[couleur=\"#ABCDEF\"]test couleur[/couleur]";
		String resultatAttendu = "<span style='color: #ABCDEF ; ' >test couleur</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteCouleur() {
		String texte = "[couleur=\"#ABCDEF\"]test couleur[/couleur] test pas couleur [couleur=\"#123456\"]test couleur[/couleur]";
		String resultatAttendu = "<span style='color: #ABCDEF ; ' >test couleur</span> test pas couleur <span style='color: #123456 ; ' >test couleur</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineCouleurRecursif() {
		String texte = "[couleur=\"#ABCDEF\"][couleur=\"#123456\"]test couleur plus[/couleur][/couleur] test pas couleur";
		String resultatAttendu = "<span style='color: #ABCDEF ; ' ><span style='color: #123456 ; ' >test couleur plus</span></span> test pas couleur";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineCouleurRecursifAvecPharse() {
		String texte = "[couleur=\"#ABCDEF\"]couleur moins[couleur=\"#123456\"]test couleur plus[/couleur]couleur moins apres[/couleur] test pas couleur";
		String resultatAttendu = "<span style='color: #ABCDEF ; ' >couleur moins<span style='color: #123456 ; ' >test couleur plus</span>couleur moins apres</span> test pas couleur";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineCouleurRecursifFermetureAvantOuverture() {
		String texte = "[/couleur]gras moins[couleur=\"#ABCDEF\"]";
		this.testErreurDuParsage(texte);
	}
	@Test
	public void testChaineCouleurPasHexa() {
		String texte = "[/couleur]gras moins[couleur=\"#GGGGGG\"]";
		this.testErreurDuParsage(texte);
	}
	@Test
	public void testChaineCouleurRien() {
		String texte = "[/couleur]gras moins[couleur=\"rien\"]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineFond() {
		String texte = "[fond=\"#ABCDEF\"]test fond[/fond]";
		String resultatAttendu = "<span style='background-color: #ABCDEF ; ' >test fond</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineSuiteFond() {
		String texte = "[fond=\"#ABCDEF\"]test fond[/fond] test pas fond [fond=\"#123456\"]test fond[/fond]";
		String resultatAttendu = "<span style='background-color: #ABCDEF ; ' >test fond</span> test pas fond <span style='background-color: #123456 ; ' >test fond</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineFondRecursif() {
		String texte = "[fond=\"#ABCDEF\"][fond=\"#123456\"]test fond plus[/fond][/fond] test pas fond";
		String resultatAttendu = "<span style='background-color: #ABCDEF ; ' ><span style='background-color: #123456 ; ' >test fond plus</span></span> test pas fond";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineFondRecursifAvecPharse() {
		String texte = "[fond=\"#ABCDEF\"]fond moins[fond=\"#123456\"]test fond plus[/fond]fond moins apres[/fond] test pas fond";
		String resultatAttendu = "<span style='background-color: #ABCDEF ; ' >fond moins<span style='background-color: #123456 ; ' >test fond plus</span>fond moins apres</span> test pas fond";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineFondRecursifFermetureAvantOuverture() {
		String texte = "[/fond]gras moins[fond=\"#ABCDEF\"]";
		this.testErreurDuParsage(texte);
	}
	@Test
	public void testChaineFondPasHexa() {
		String texte = "[/fond]gras moins[fond=\"#GGGGGG\"]";
		this.testErreurDuParsage(texte);
	}
	@Test
	public void testChaineFondRien() {
		String texte = "[/fond]gras moins[fond=\"rien\"]";
		this.testErreurDuParsage(texte);
	}
	
	@Test
	public void testChaineDifferent() {
		String texte = "[fond=\"#ABCDEF\"]fond moins[couleur=\"#ABCDEF\"]test fond plus[/fond]fond moins apres[/couleur]";
		
		String resultatAttendu = "<span style='background-color: #ABCDEF ; ' >fond moins<span style='color: #ABCDEF ; ' >test fond plus</span></span>fond moins apres";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	@Test
	public void testChaineProblemeBR() {
		String texte = "[titre=1]Présentation[/titre]\n[police=\"Courier New\"]Bienvenue sur le site du centre équestre des écuries du loup .:p[/police]";
		String resultatAttendu = "<h1>Pr&eacute;sentation</h1><br />\n<span style='font-family:\"Courier New\" ; ' >Bienvenue sur le site du centre &eacute;questre des &eacute;curies du loup .:p</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineProblemeBREspace() {
		String texte = "[titre=1]Présentation[/titre] \n[police=\"Courier New\"]Bienvenue sur le site du centre équestre des écuries du loup .:p[/police]";
		String resultatAttendu = "<h1>Pr&eacute;sentation</h1> <br />\n<span style='font-family:\"Courier New\" ; ' >Bienvenue sur le site du centre &eacute;questre des &eacute;curies du loup .:p</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineProblemeBREspace2() {
		String texte = "[centre]Présentation[/centre] \n[police=\"Courier New\"]Bienvenue sur le site du centre équestre des écuries du loup .:p[/police]";
		String resultatAttendu = "<div class=\"edlCode_centre\">Pr&eacute;sentation</div> <br />\n<span style='font-family:\"Courier New\" ; ' >Bienvenue sur le site du centre &eacute;questre des &eacute;curies du loup .:p</span>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineProblemeBREspace3() {
		String texte = "[centre]Présentation[/centre] \n[centre]Présentation[/centre]";
		String resultatAttendu = "<div class=\"edlCode_centre\">Pr&eacute;sentation</div> <br />\n<div class=\"edlCode_centre\">Pr&eacute;sentation</div>";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineBR() {
		String texte = "\n";
		String resultatAttendu = "<br />\n";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineEspaceBR() {
		String texte = " \n";
		String resultatAttendu = " <br />\n";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	@Test
	public void testChaineEspace() {
		String texte = " ";
		String resultatAttendu = " ";
		this.testEgaliteDuParsage(texte, resultatAttendu);
	}
	
	
}
