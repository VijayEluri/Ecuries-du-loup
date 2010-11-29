package fr.ecurie_du_loup.generique_util.service;

import java.util.List;

import fr.ecurie_du_loup.generique_util.type.DataOrdonner;

public abstract class DataBaseServiceWhithLongAndOrdonneeImpl<T extends DataOrdonner> extends DataBaseServiceWithDaoIdLongUtilAndLongId<T> implements  DataBaseServiceWithLongIdAndOrdonner<T>{

	@Override
	public void add(T t) {
		List<T> listT = this.dao.findAll();
		int maxPosition = 0;
		for(T tBoucle : listT){
			maxPosition = Math.max(tBoucle.getOrdre(), maxPosition);
		}
		t.setOrdre(maxPosition+1);
		super.add(t);
	}
	@Override
	public void delete(T t) {
		int ordrePage = t.getOrdre();
		super.delete(t);
		List<T> listT = this.getAll();

		for(T tBoucle : listT){
			if(tBoucle.getOrdre() > ordrePage){
				int ordre = tBoucle.getOrdre() -1;
				tBoucle.setOrdre(ordre);
				this.dao.update(tBoucle);
			}
		}
	}


	@Override
	public void changeOrdre(T t, int newPosition) {

		List<T> listT = this.getAll();

		int difference = (t.getOrdre() < newPosition)? -1: 1;
		int min = Math.min(newPosition, t.getOrdre());
		int max = Math.max(newPosition, t.getOrdre());

		for(T tBoucle : listT){
			if(tBoucle.equals(t)){
				tBoucle.setOrdre(newPosition);
				this.dao.update(tBoucle);
			}else if(this.comprisDans(tBoucle.getOrdre(), min, max)){
				int nouvelOrdre = tBoucle.getOrdre() + difference;

				tBoucle.setOrdre(nouvelOrdre);
				this.dao.update(tBoucle);
			}
		}
	}

	private boolean comprisDans(int valeur, int min, int max){
		return valeur >= min && valeur <= max;
	}
}
