package fr.ecurie_du_loup.generique_util.dao.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fr.ecurie_du_loup.generique_util.dao.DaoUtil;
import fr.ecurie_du_loup.generique_util.test.GeneriqueTest;

public abstract class DaoUtilTest<T> extends GeneriqueTest<T>{
	protected DaoUtil<T> dao;
	
	
	
	@Test
	public void testAdd() {
		T t = this.getNewObject();
		this.dao.add(t);
		this.testPresenceEqualsInBase(t);
	}

	private void testPresenceEqualsInBase(T t) {
		List<T> listFindAll = this.dao.findAll();
		assertTrue(listFindAll.contains(t));
		for(T object : listFindAll){
			if(object.equals(t)){
				this.compareJUnit(t, object);
			}
		}
	}


	
	
	@Test
	public void testFindAll() {
		T objectTestInBase =this.getObjectInBase();
		this.testPresenceEqualsInBase(objectTestInBase);
	}
	
	@Test
	public void testRemove() {
		T t = this.getNewObject();
		this.dao.add(t);

		this.dao.remove(t);

		List<T> listFindAll = this.dao.findAll();
		assertFalse(listFindAll.contains(t));
	}
	
	@Test
	public void testUpdate() {
		T t = this.getNewObject();
		this.dao.add(t);

		this.modificationObject(t);

		this.dao.update(t);
		this.testPresenceEqualsInBase(t);

	}

}
