package fiche_chevaux.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Race;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class RaceChevauxDAOHibernate extends HibernateIdLongBySpringDao<Race> implements	RaceChevauxDAO {

	
	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY nom ASC";
	} 

}
