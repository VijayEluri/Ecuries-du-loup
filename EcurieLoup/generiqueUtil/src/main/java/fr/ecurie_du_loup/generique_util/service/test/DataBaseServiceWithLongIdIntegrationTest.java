package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;
import fr.ecurie_du_loup.generique_util.test.Comparator;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;


public abstract class DataBaseServiceWithLongIdIntegrationTest<T extends DataWithLongId> extends DataBaseServiceIntegrationTest<T>{

	@Test
	public void testGetById() {
		T objectTestInBase =this.getObjectInBase();
		T objetRecuperer = ((DataBaseServiceWithLongId<T>) this.service).getById(objectTestInBase.getId());
		Comparator.compareJUnit(objectTestInBase, objetRecuperer, this.notCheckedValue);
	}
	
	@Test
	public void testDeleteByIdLong() {
		T t = this.getNewObject();
		this.service.add(t);

		((DataBaseServiceWithLongId<T>)this.service).delete(t.getId());

		List<T> listGetAll = this.service.getAll();
		assertFalse(listGetAll.contains(t));
	}
}
