package fr.ecurie_du_loup.generique_util.service;

import fr.ecurie_du_loup.generique_util.dao.DaoIdStringUtil;
import fr.ecurie_du_loup.generique_util.type.DataWithStringId;

public abstract class DataBaseServiceWithDaoAndStringId<T extends DataWithStringId> extends DataBaseServiceWithDaoUtil<T> implements DataBaseServiceWithStringId<T>{

	@Override
	public T getById(String id) {
		return ((DaoIdStringUtil<T>)this.dao).findById(id);
	}
	@Override
	public boolean canBeAdded(T t) {
		String idAdded = t.getId();
		return this.getById(idAdded) == null;
		
	};
}
