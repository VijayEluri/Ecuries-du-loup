package fr.ecurie_du_loup.generique_util.service;

import fr.ecurie_du_loup.generique_util.type.DataOrdonner;

public interface DataBaseServiceWithLongIdAndOrdonner<T extends DataOrdonner> extends DataBaseServiceWithLongId<T>{

	public void changeOrdre(T t, int newPosition);
	
}
