package fiche_chevaux.dao;

import java.util.List;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Surnom;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface SurnomsChevauxDAO extends DaoIdLongUtil<Surnom>{

	public Surnom getSurnom(String surnom, Fiche fiche);
	public List<Surnom> getSurnoms(Fiche fiche);
	
	
	
}
