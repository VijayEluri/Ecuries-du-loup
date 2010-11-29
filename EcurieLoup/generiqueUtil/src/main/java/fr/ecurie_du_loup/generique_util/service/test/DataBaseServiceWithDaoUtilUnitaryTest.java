package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import fr.ecurie_du_loup.generique_util.dao.DaoUtil;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoUtil;

public abstract class DataBaseServiceWithDaoUtilUnitaryTest<T> {
	protected DaoUtil<T> dao;
	protected DataBaseServiceWithDaoUtil<T> service;
	
	protected abstract T getNewObject();

	@Test
	public void testGetAll() {
		List<T> listT = new ArrayList<T>();
		for(int i = 0; i < 10; i++){
			T t = this.getNewObject();
			listT.add(t);
		}
		EasyMock.expect(this.dao.findAll()).andReturn(listT);

		EasyMock.replay(this.dao);

		List<T> listTRecuperer = this.service.getAll();

		assertEquals(listTRecuperer, listT);
		EasyMock.verify(this.dao);
	}

	@Test
	public void testAdd() {
		T t = this.getNewObject();
		
		this.dao.add(t);
		EasyMock.replay(this.dao);

		this.service.add(t);

		EasyMock.verify(this.dao);
	}

	@Test
	public void testUpdate() {
		T t = this.getNewObject();

		this.dao.update(t);
		EasyMock.replay(this.dao);

		this.service.update(t);

		EasyMock.verify(this.dao);
	}

	@Test
	public void testDelete() {
		T t = this.getNewObject();

		this.dao.remove(t);

		EasyMock.replay(this.dao);

		this.service.delete(t);

		EasyMock.verify(this.dao);
	}

}
