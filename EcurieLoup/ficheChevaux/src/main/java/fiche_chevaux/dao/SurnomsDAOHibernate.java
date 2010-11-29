package fiche_chevaux.dao;

import java.util.List;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Surnom;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class SurnomsDAOHibernate extends  HibernateIdLongBySpringDao<Surnom> implements	SurnomsChevauxDAO {

	
	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY surnom ASC";
	} 

	

	@Override
	public Surnom getSurnom(String surnom, Fiche fiche) {
		List<Surnom> surnoms = this.getHibernateTemplate().find("from Surnom WHERE fiche.id=? AND surnom=?", 
				new Object[]{fiche.getId(), surnom});

		Surnom surnomTrouver = null;
		if(!surnoms.isEmpty()){
			surnomTrouver = surnoms.get(0);
		}
		return surnomTrouver;
	}

	@Override
	public List<Surnom> getSurnoms(Fiche fiche) {
		List<Surnom> surnoms = this.getHibernateTemplate().find("from Surnom WHERE fiche.id=?", fiche.getId());
		return surnoms;
	}

}
