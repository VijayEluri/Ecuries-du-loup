package service.calendrier;

import java.util.List;
import java.util.Map;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;

public interface CalendrierManager{


	public void add(TypeEvenement typeEvenement);

	public void update(TypeEvenement typeEvenement);

	public void delete(TypeEvenement typeEvenement) throws DeleteTypeEvenementException;

	public TypeEvenement getTypeEvent(long id);

	public List<TypeEvenement> getAllTypeEvents();


	public void add(Evenement evenement);

	public void update(Evenement evenement);

	public void delete(Evenement evenement);

	public Evenement getEvent(long id);

	public List<Evenement> getAllEvents();

	public Map<Integer, List<Evenement>> getAllEventsByMonthByDay(int yearOfMonth, int months);

	public List<Evenement> getAllEventOfDay(int year, int month, int day);
	
	
	

}
