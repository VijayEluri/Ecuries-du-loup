package dao.calendrier;

import integration.EventInBase;

import java.util.Date;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;

public class CalendrierTestUtil {

	
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
