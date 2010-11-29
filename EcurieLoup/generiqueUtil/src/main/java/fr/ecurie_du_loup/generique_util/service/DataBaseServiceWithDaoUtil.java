package fr.ecurie_du_loup.generique_util.service;

import java.util.List;

import fr.ecurie_du_loup.generique_util.dao.DaoUtil;

public abstract class DataBaseServiceWithDaoUtil<T> implements DataBaseService<T> {
	protected DaoUtil<T> dao;
	
	public void setDao(DaoUtil<T> dao) {
		this.dao = dao;
	}

	@Override
	public void add(T t) {
		this.dao.add(t);
		
	}

	@Override
	public void delete(T t) {
		this.dao.remove(t);
		
	}

	@Override
	public List<T> getAll() {
		return this.dao.findAll();
	}

	@Override
	public void update(T t) {
		this.dao.update(t);		
	}

}
