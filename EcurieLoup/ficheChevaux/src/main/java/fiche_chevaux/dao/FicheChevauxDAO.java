package fiche_chevaux.dao;

import java.util.List;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Race;
import fiche_chevaux.donnees.Robe;
import fiche_chevaux.donnees.Sexe;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface FicheChevauxDAO extends DaoIdLongUtil<Fiche>{

	
	public List<Fiche> getFichesChevaux(Sexe sexe);
	public List<Fiche> getFichesChevaux(Race race);
	public List<Fiche> getFichesChevaux(Robe robe);
	public List<Fiche> getFichesChevauxCategory(long category);
	
	public List<Fiche> getHorseBorn(int month, int day);
	
}
