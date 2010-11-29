package dao.calendrier;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface EventDao extends DaoIdLongUtil<Evenement>{
	public boolean hasEvenementOfType(TypeEvenement typeEvenement);

}
