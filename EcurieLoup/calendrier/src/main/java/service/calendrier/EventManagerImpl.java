package service.calendrier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.UserDAO;
import dao.calendrier.EventDao;
import dao.calendrier.TypeEventDao;
import donnees.User;
import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;
import fiche_chevaux.dao.FicheChevauxDAO;
import fiche_chevaux.donnees.Fiche;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;

public class EventManagerImpl extends
		DataBaseServiceWithDaoIdLongUtilAndLongId<Evenement> implements EventManager {
	private UserDAO userDAO;
	private TypeEventDao typeEventDao;
	private FicheChevauxDAO ficheChevauxDAO;
	
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public void setTypeEventDao(TypeEventDao typeEventDao) {
		this.typeEventDao = typeEventDao;
	}
	

	public void setFicheChevauxDAO(FicheChevauxDAO ficheChevauxDAO) {
		this.ficheChevauxDAO = ficheChevauxDAO;
	}


	@Override
	public Map<Integer, List<Evenement>> recuperationTousEvenementsDuMoisParJour(int annee, int mois) {
		//TODO: géré par hibernate?

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, annee);
		calendar.set(Calendar.MONTH, mois-1);
		calendar.set(Calendar.MILLISECOND, 0);
		int nombreJourMois = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		Map<Integer, List<Evenement>> evenementParJour = new HashMap<Integer, List<Evenement>>();

		List<Evenement> tousEvements = this.getAll();
		for(int i = 1 ; i <= nombreJourMois; i++){
			List<Evenement> evenementDuJour = new ArrayList<Evenement>();
			calendar.set(Calendar.DAY_OF_MONTH, i);

			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);

			long debutJournee  = calendar.getTimeInMillis();


			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			long finJournee   = calendar.getTimeInMillis();

			for(Evenement evenement : tousEvements){
				long date =evenement.getDate();
				if((date >= debutJournee) && ( date <= finJournee)){
					evenementDuJour.add(evenement);
				}

			}
			tousEvements.removeAll(evenementDuJour);

			evenementDuJour.addAll(this.convertUserInEvent(this.userDAO.getUserBorn(mois, i)));
			evenementDuJour.addAll(this.convertHorseInEvent(this.ficheChevauxDAO.getHorseBorn(mois, i)));
			evenementParJour.put(i, evenementDuJour);

		}
		return evenementParJour;
	}

	@Override
	public List<Evenement> recuperationTousEvenementsDuJour(int annee, int mois, int jour) {
		List<Evenement> tousEvements = this.getAll();

		List<Evenement> evenementMois = new ArrayList<Evenement>();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, annee);
		calendar.set(Calendar.MONTH, mois-1);
		calendar.set(Calendar.DAY_OF_MONTH, jour);
		calendar.set(Calendar.MILLISECOND, 0);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		long debutJour  = calendar.getTimeInMillis();


		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		long finJour   = calendar.getTimeInMillis();

		for(Evenement event : tousEvements){
			long date = event.getDate();
			if((date >= debutJour) && (date <= finJour)){
				evenementMois.add(event);
			}

		}
		
	
		evenementMois.addAll(this.convertUserInEvent(this.userDAO.getUserBorn(mois, jour)));
		evenementMois.addAll(this.convertHorseInEvent(this.ficheChevauxDAO.getHorseBorn(mois, jour)));

		return evenementMois;
	}

	private List<Evenement> convertUserInEvent(List<User> users){
		TypeEvenement typeEvenement = this.getTypeEventBirthDay();
		List<Evenement> birthdays = new ArrayList<Evenement>();
		
		for(User user : users){
			Evenement birthDay = new Evenement();
			birthDay.setDescription("Anniversaire de "+user.getPrenom()+" "+user.getNom());
			birthDay.setDate(user.getBirthDate());
			birthDay.setTypeEvenement(typeEvenement);
			birthdays.add(birthDay);
			
		}
		
		return birthdays;
	}
	
	private List<Evenement> convertHorseInEvent(List<Fiche> horses){
		TypeEvenement typeEvenement = this.getTypeEventBirthDay();
		List<Evenement> birthdays = new ArrayList<Evenement>();
		
		Calendar firstDayOfYear = Calendar.getInstance();
		firstDayOfYear.set(0, 0, 1, 0, 0, 0);
		
		for(Fiche horse : horses){
			Evenement birthDay = new Evenement();
			birthDay.setDescription("Anniversaire de "+horse.getNom());
			if(horse.getDateNaissance() != 0){
				birthDay.setDate(horse.getDateNaissance());
			}else{
				firstDayOfYear.set(Calendar.YEAR, horse.getAnneeNaissance());
				birthDay.setDate(firstDayOfYear.getTimeInMillis());
			}
			birthDay.setTypeEvenement(typeEvenement);
			birthdays.add(birthDay);
			
		}
		
		return birthdays;
	}
	public boolean hasEvenementOfType(TypeEvenement typeEvenement){
		return ((EventDao) this.dao).hasEvenementOfType(typeEvenement);
	}
	
	private TypeEvenement getTypeEventBirthDay(){
		return this.typeEventDao.findById(1);
	
	}
	

}
