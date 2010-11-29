package fr.ecurie_du_loup.generique_util.service;

import fr.ecurie_du_loup.generique_util.type.DataWithStringId;


public interface DataBaseServiceWithStringId<T extends DataWithStringId> extends DataBaseService<T> {
	public T getById(String id);
	

	public boolean canBeAdded(T t);
}
