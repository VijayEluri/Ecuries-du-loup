package fiche_chevaux.dao;

import fiche_chevaux.donnees.Sexe;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class SexeChevauxDAOHibernate extends HibernateIdLongBySpringDao<Sexe> implements	SexeChevauxDAO {

	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY nom ASC";
	} 

}
