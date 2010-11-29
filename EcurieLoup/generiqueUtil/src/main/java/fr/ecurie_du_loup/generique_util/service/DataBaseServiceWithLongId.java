package fr.ecurie_du_loup.generique_util.service;


public interface DataBaseServiceWithLongId<T> extends DataBaseService<T> {
	public T getById(long id);
	
	public void delete(long id);
	
}
