package service.smiley;

import java.util.ArrayList;
import java.util.List;

import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWhithLongAndOrdonneeImpl;

public class CategorieSmileyManagerImpl extends DataBaseServiceWhithLongAndOrdonneeImpl<CategorieSmiley> implements CategorieSmileyManager{
	
	@Override
	public CategorieSmiley getById(long id) {
		CategorieSmiley categorie = super.getById(id);
		
		if(categorie != null){
			categorie.setSmileys(this.trierParOrdreSmiley(categorie.getSmileys()));
		}
		return categorie;
	}
	
	private List<Smiley> trierParOrdreSmiley(List<Smiley> smileys){
		List<Smiley> smileyTrierParOrdre = new ArrayList<Smiley>();

		for(Smiley smiley : smileys){
			boolean smileyPlacer = false;

			for(int i = 0; i < smileyTrierParOrdre.size(); i++){
				if(smileyTrierParOrdre.get(i).getOrdre()> smiley.getOrdre()){
					smileyTrierParOrdre.add(i, smiley);
					smileyPlacer = true;
					break;
				}
			}

			if(!smileyPlacer){
				smileyTrierParOrdre.add(smiley);
			}
		}
		return smileyTrierParOrdre;
	}
	
	@Override
	public List<CategorieSmiley> getAll() {
		List<CategorieSmiley> categories = super.getAll();
		for(CategorieSmiley categorie : categories){
			categorie.setSmileys(this.trierParOrdreSmiley(categorie.getSmileys()));
		}
		return categories;
	}

	
}
