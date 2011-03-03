package fr.ecurie_du_loup.generique_util.test;

import java.util.ArrayList;
import java.util.Collection;

public abstract class GeneriqueTest<T> {
	protected Collection<String> notCheckedValue;
	
	public GeneriqueTest() {
		this.notCheckedValue = new ArrayList<String>();
	}
	
	/**
	 * Permet de comparer 2 objets de type T a l'aide d'assert(JUnit)
	 * @param t le 1ier objet à comparer
	 * @param object le second objet de la comparaison
	 */
	//protected abstract void compareJUnit(T t1, T t2);

	/**
	 * Permet de définir un objet dans la base de donnée
	 * @return l'objet dans la base
	 */
	protected abstract T getObjectInBase();
	
	/**
	 * Permet de définir un objet créé a ajouté dans la base
	 * @return l'objet dans la base
	 */
	protected abstract T getNewObject();
	
	/**
	 * Méthode modifiant t
	 * @param t l'objet T a modifier
	 */
	protected abstract void modificationObject(T t);
}
