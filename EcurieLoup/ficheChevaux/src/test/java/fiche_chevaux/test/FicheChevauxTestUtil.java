package fiche_chevaux.test;

import static org.junit.Assert.assertEquals;
import fiche_chevaux.donnees.Fiche;

public final class FicheChevauxTestUtil {

    private FicheChevauxTestUtil() {
    }

    public static void compareJUnit(Fiche t1, Fiche t2) {
	assertEquals(t1.getId(), t2.getId());
	assertEquals(t1.getDateNaissance(), t2.getDateNaissance());
	assertEquals(t1.getAnneeNaissance(), t2.getAnneeNaissance());
	assertEquals(t1.getDescription(), t2.getDescription());
	assertEquals(t1.getNom(), t2.getNom());
	assertEquals(t1.getPhoto(), t2.getPhoto());
	assertEquals(t1.getRace(), t2.getRace());
	assertEquals(t1.getRobe(), t2.getRobe());
	assertEquals(t1.getSexe(), t2.getSexe());
	assertEquals(t1.getSurnoms(), t2.getSurnoms());

    }

    public static Fiche getNewObject() {
	Fiche fiche = new Fiche();
	fiche.setNom("nom Fiche");
	fiche.setDescription("description du cheval");
	fiche.setAnneeNaissance(2001);
	fiche.setRobe(DataInBase.getRobe());
	fiche.setRace(DataInBase.getRace());
	fiche.setSexe(DataInBase.getSexe());
	return fiche;
    }

    public static void modificationObject(Fiche t) {
	t.setDescription("nouvelle description de la fiche");
	t.setAnneeNaissance(1598);

    }
}
