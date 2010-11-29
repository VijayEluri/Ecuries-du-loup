package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.easymock.EasyMock;
import org.junit.Test;

import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;


public abstract class DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<T extends DataWithLongId> extends DataBaseServiceWithDaoUtilUnitaryTest<T>{

	@Test
	public void testGetById() {
		T t = this.getNewObject();

		EasyMock.expect(((DaoIdLongUtil<T>) this.dao).findById(t.getId())).andReturn(t);

		EasyMock.replay(this.dao);

		T tRecuperer = ((DataBaseServiceWithDaoIdLongUtilAndLongId<T>) this.service).getById(t.getId());

		assertEquals(tRecuperer, t);
		EasyMock.verify(this.dao);
	}

	@Test
	public void testGetByIdWithTUnknow() {
		long id = -10;
		
		EasyMock.expect(((DaoIdLongUtil<T>) this.dao).findById(id)).andReturn(null);

		EasyMock.replay(this.dao);

		T tRecuperer = ((DataBaseServiceWithDaoIdLongUtilAndLongId<T>) this.service).getById(id);

		assertNull(tRecuperer);
		EasyMock.verify(this.dao);
	}
	
	@Test
	public void testDelete() {
		T t = this.getNewObject();

		EasyMock.expect(((DaoIdLongUtil<T>) this.dao).findById(t.getId())).andReturn(t);
		this.dao.remove(t);

		EasyMock.replay(this.dao);

		((DataBaseServiceWithDaoIdLongUtilAndLongId<T>)this.service).delete(t.getId());

		EasyMock.verify(this.dao);
	}
	
	

}
