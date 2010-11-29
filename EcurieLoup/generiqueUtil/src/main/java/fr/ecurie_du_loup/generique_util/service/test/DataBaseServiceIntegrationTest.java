package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fr.ecurie_du_loup.generique_util.service.DataBaseService;
import fr.ecurie_du_loup.generique_util.test.GeneriqueTest;

public abstract class DataBaseServiceIntegrationTest<T> extends GeneriqueTest<T>{
	protected  DataBaseService<T> service;
	
	private void testPresenceEqualsInBase(T t) {
		List<T> listGetAll = this.service.getAll();
		assertTrue(listGetAll.contains(t));
		for(T object : listGetAll){
			if(object.equals(t)){
				this.compareJUnit(t, object);
			}
		}
	}
	

	@Test
	public void testAdd() {
		
		T t = this.getNewObject();
		
		this.service.add(t);
		
		this.testPresenceEqualsInBase(t);
	}

	@Test
	public void testGetAll() {
		T objectTestInBase =this.getObjectInBase();
		this.testPresenceEqualsInBase(objectTestInBase);
	}
	
	

	@Test
	public void testRemove() {
		T t = this.getNewObject();
		this.service.add(t);

		this.service.delete(t);

		List<T> listGetAll = this.service.getAll();
		assertFalse(listGetAll.contains(t));
	}
	
	
	
	@Test
	public void testUpdate() {
		T t = this.getNewObject();
		this.service.add(t);

		this.modificationObject(t);

		this.service.update(t);
		this.testPresenceEqualsInBase(t);

	}

	
}
