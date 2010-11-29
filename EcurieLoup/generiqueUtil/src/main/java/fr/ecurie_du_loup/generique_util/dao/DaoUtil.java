package fr.ecurie_du_loup.generique_util.dao;

import java.util.List;

/**
 * Permet les action de base de persistance des données dans une base.
 * @author krack
 *
 * @param <T> le type de l'objet qui sera enregistrer dans la base.
 */
public interface DaoUtil<T> {

	/**
	 * Permet de rendre persistant un objet dans la base de donnée.
	 * @param t l'objet a rendre persistant
	 */
	public void add(T t);
	
	/**
	 * Permet de retiré un objet persistant de la base de donnée.
	 * @param t l'object qui doit être retiré de la persistance
	 */
	public void remove(T t);
	
	/**
	 * Permet de mettre a jour un objet déjà persister.
	 * @param t l'objet déjà persisté dans la base qui doit être modifier
	 */
	public void update(T t);
	
	/**
	 * Retourne les objets de type T trier par ordre d'id.
	 * @return la liste de ces objets
	 */
	public List<T> findAll(); 
}
