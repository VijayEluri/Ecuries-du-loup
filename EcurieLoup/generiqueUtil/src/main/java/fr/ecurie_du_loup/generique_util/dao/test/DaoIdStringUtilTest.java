package fr.ecurie_du_loup.generique_util.dao.test;

import org.junit.Test;

import fr.ecurie_du_loup.generique_util.dao.DaoIdStringUtil;
import fr.ecurie_du_loup.generique_util.type.DataWithStringId;


public abstract class DaoIdStringUtilTest<T extends DataWithStringId> extends DaoUtilTest<T>{
	//TODO : voir avec cousin sur c'est possible de ne pas avoir a caster dans toutes les méthdeos
	@Test
	public void testFindById() {
		T objectTestInBase =this.getObjectInBase();
		T objetRecuperer = ((DaoIdStringUtil<T>) this.dao).findById(objectTestInBase.getId());
		this.compareJUnit(objectTestInBase, objetRecuperer);
	}

}
