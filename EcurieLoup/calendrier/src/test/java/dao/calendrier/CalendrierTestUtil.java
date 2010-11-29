package dao.calendrier;

import static org.junit.Assert.assertEquals;
import integration.EventInBase;

import java.util.Date;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;

public class CalendrierTestUtil {

	

	public static void compareJUnit(Evenement evenement1, Evenement evenement2) {
		assertEquals(evenement1.getId(), evenement2.getId());
		assertEquals(evenement1.getDate(), evenement2.getDate());
		assertEquals(evenement1.getDescription(), evenement2.getDescription());
		assertEquals(evenement1.getTypeEvenement().getId(), evenement2.getTypeEvenement().getId());
	}
	
	public static void modificationObject(Evenement evenement) {
		evenement.setDescription("nouvelle description");
		
	}
	
	public static Evenement getNewObject() {
		Evenement event = new Evenement();
		long id = (long) (Math.random()*10000);
		event.setId(id);
		event.setDescription("description of event");
		event.setDate(new Date().getTime());
		event.setTypeEvenement(EventInBase.getTypeEvent());
		
		return event;
	}
	
	public static void compareJUnit(TypeEvenement typeEvenement1, TypeEvenement typeEvenement2){
		assertEquals(typeEvenement1.getId(), typeEvenement2.getId());
		assertEquals(typeEvenement1.getCouleur(), typeEvenement2.getCouleur());
		assertEquals(typeEvenement1.getDescription(), typeEvenement2.getDescription());
		assertEquals(typeEvenement1.getNom(), typeEvenement2.getNom());
	}
	
	public static TypeEvenement getNewTypeEvent() {
		TypeEvenement typeEvenement = new TypeEvenement();
		typeEvenement.setCouleur("#123123");
		typeEvenement.setNom("type Evenement ");
		typeEvenement.setDescription("Ba voila la superbe description");

		return typeEvenement;
	}
	
	public static void modificationObject(TypeEvenement typeEvenement) {
		typeEvenement.setDescription("nouvelle description");
		
	}
}
