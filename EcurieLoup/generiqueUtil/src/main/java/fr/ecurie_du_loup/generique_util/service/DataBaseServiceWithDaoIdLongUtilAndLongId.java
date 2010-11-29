package fr.ecurie_du_loup.generique_util.service;

import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;

public abstract class DataBaseServiceWithDaoIdLongUtilAndLongId<T extends DataWithLongId> extends DataBaseServiceWithDaoUtil<T> implements DataBaseServiceWithLongId<T>{

	@Override
	public T getById(long id) {
		return ((DaoIdLongUtil<T>)this.dao).findById(id);
	}

	@Override
	public void delete(long id) {
		T t = this.getById(id);
		if(t !=null){
			this.delete(t);
		}
		
	}
	
	
}
