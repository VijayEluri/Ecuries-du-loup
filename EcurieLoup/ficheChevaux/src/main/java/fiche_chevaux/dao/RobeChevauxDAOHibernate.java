package fiche_chevaux.dao;

import fiche_chevaux.donnees.Robe;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;


public class RobeChevauxDAOHibernate extends HibernateIdLongBySpringDao<Robe> implements
		RobeChevauxDAO {
	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY nom ASC";
	} 
}
