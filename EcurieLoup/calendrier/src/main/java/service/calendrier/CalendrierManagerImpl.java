package service.calendrier;

import java.util.List;
import java.util.Map;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;


public class CalendrierManagerImpl implements CalendrierManager{
	private EventManager eventManager;
	private TypeEventManager typeEventManager;
	
	
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	public void setTypeEventManager(TypeEventManager typeEventManager) {
		this.typeEventManager = typeEventManager;
	}
	
	@Override
	public void add(TypeEvenement typeEvenement) {
		this.typeEventManager.add(typeEvenement);
		
	}
	@Override
	public void add(Evenement evenement) {
		this.eventManager.add(evenement);
		
	}
	@Override
	public void delete(TypeEvenement typeEvenement)
			throws DeleteTypeEvenementException {
		if(this.eventManager.hasEvenementOfType(typeEvenement)){
			throw new DeleteTypeEvenementException();
		}
		this.typeEventManager.delete(typeEvenement);
		
	}
	@Override
	public void delete(Evenement evenement) {
		this.eventManager.delete(evenement);
		
	}
	@Override
	public List<Evenement> getAllEventOfDay(int year, int month, int day) {
		
		return this.eventManager.recuperationTousEvenementsDuJour(year, month, day);
	}
	@Override
	public List<Evenement> getAllEvents() {
		return this.eventManager.getAll();
	}
	@Override
	public Map<Integer, List<Evenement>> getAllEventsByMonthByDay(int yearOfMonth, int months) {
		return this.eventManager.recuperationTousEvenementsDuMoisParJour(yearOfMonth, months);
	}
	@Override
	public List<TypeEvenement> getAllTypeEvents() {
		return this.typeEventManager.getAll();
	}
	@Override
	public Evenement getEvent(long id) {
		return this.eventManager.getById(id);
	}
	@Override
	public TypeEvenement getTypeEvent(long id) {
		return this.typeEventManager.getById(id);
	}
	@Override
	public void update(TypeEvenement typeEvenement) {
		this.typeEventManager.update(typeEvenement);
	}
	@Override
	public void update(Evenement evenement) {
		this.eventManager.update(evenement);
	}

	

}
