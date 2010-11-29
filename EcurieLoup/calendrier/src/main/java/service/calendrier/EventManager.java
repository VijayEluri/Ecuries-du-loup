package service.calendrier;

import java.util.List;
import java.util.Map;

import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;

public interface EventManager extends DataBaseServiceWithLongId<Evenement>{

	public boolean hasEvenementOfType(TypeEvenement typeEvenement);
	
	public Map<Integer, List<Evenement>> recuperationTousEvenementsDuMoisParJour(int annee, int mois);

	public List<Evenement> recuperationTousEvenementsDuJour(int annee, int mois, int jour);
}
