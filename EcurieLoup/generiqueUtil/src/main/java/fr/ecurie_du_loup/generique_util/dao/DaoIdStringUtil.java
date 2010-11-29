package fr.ecurie_du_loup.generique_util.dao;

/**
 * Permet la recherche par id qui est un long.
 * 
 * @author krack
 *
 * @param <T>
 */
public interface DaoIdStringUtil<T> extends DaoUtil<T> {

	/**
	 * Permet de récupéré l'objet par son id.
	 * @param id id de l'objet
	 * @return l'objet ayant pour id celui passé en paramètre. Renvoi null si aucun objet avec cette id n'a été trouvé.
	 */
	public T findById(String id);
}
