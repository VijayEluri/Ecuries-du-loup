package fiche_chevaux.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import donnees.User;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Race;
import fiche_chevaux.donnees.Robe;
import fiche_chevaux.donnees.Sexe;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class FicheChevauxDAOHibernate extends HibernateIdLongBySpringDao<Fiche> implements FicheChevauxDAO {

	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY nom ASC";
	}
	
	@Override
	public List<Fiche> getFichesChevaux(Sexe sexe) {
		List<Fiche> fiches = this.getHibernateTemplate().find("FROM Fiche WHERE sexe=? ORDER BY nom ASC", sexe);
		return fiches;
	}
	
	@Override
	public List<Fiche> getFichesChevaux(Race race) {
		List<Fiche> fiches = this.getHibernateTemplate().find("FROM Fiche WHERE race=? ORDER BY nom ASC", race);
		return fiches;
	}
	@Override
	public List<Fiche> getFichesChevaux(Robe robe) {
		List<Fiche> fiches = this.getHibernateTemplate().find("FROM Fiche WHERE robe=? ORDER BY nom ASC", robe);
		return fiches;
	}

	@Override
	public List<Fiche> getHorseBorn(int month, int day) {
		List<Fiche> horses = this.findAll();
		
		List<Fiche> horsesBorn = new ArrayList<Fiche>();
		
		for(Fiche horse : horses){
			if(horse.getDateNaissance() != 0){
				Calendar birthDate = Calendar.getInstance();
				birthDate.setTimeInMillis(horse.getDateNaissance());
				if(
						month == (birthDate.get(Calendar.MONTH) +1 )
					&& day == (birthDate.get(Calendar.DAY_OF_MONTH))	
				){
					horsesBorn.add(horse);				
				}
			}else if(horse.getAnneeNaissance() != 0){
				if(month == 1 && day ==1){
					horsesBorn.add(horse);
				}
			}
		}
		return horsesBorn;
	}

}
