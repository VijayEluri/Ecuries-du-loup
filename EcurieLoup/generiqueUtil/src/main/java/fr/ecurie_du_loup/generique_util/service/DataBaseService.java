package fr.ecurie_du_loup.generique_util.service;

import java.util.List;


public interface DataBaseService<T> {

	public List<T> getAll();
	
	public void add(T t);

	public void update(T t);

	public void delete(T t);
}
