package dao.calendrier;

import java.util.List;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class EventDaoImpl extends HibernateIdLongBySpringDao<Evenement> implements EventDao {

	@Override
	public boolean hasEvenementOfType(TypeEvenement typeEvenement) {
		List<Evenement> evenements = this.getHibernateTemplate().loadAll(Evenement.class);

		for(Evenement evenement: evenements){
			if(evenement.getTypeEvenement().equals(typeEvenement)){
				return true;
			}
		}
		return false;
	}


}
