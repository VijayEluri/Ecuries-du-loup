package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithStringId;
import fr.ecurie_du_loup.generique_util.type.DataWithStringId;


public abstract class DataBaseServiceWithStringIdIntegrationTest<T extends DataWithStringId> extends DataBaseServiceIntegrationTest<T>{

	@Test
	public void testGetById() {
		T objectTestInBase =this.getObjectInBase();
		T objetRecuperer = ((DataBaseServiceWithStringId<T>) this.service).getById(objectTestInBase.getId());
		this.compareJUnit(objectTestInBase, objetRecuperer);
	}
	
	@Test
	public void testGetByIdNull() {
		T objectTestNotInBase =this.getNewObject();
		objectTestNotInBase.setId("ID inexistant");
		T objetRecuperer = ((DataBaseServiceWithStringId<T>) this.service).getById(objectTestNotInBase.getId());
		assertNull(objetRecuperer);
	}
	
	
}
