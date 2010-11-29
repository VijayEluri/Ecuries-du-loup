package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Test;

import fr.ecurie_du_loup.generique_util.dao.DaoIdStringUtil;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoAndStringId;
import fr.ecurie_du_loup.generique_util.type.DataWithStringId;



public abstract class DataBaseServiceWithDaoAndStringIdUnitariTest<T extends DataWithStringId> extends DataBaseServiceWithDaoUtilUnitaryTest<T> {


	@Test
	public void testGetById() {
		T t = this.getNewObject();

		EasyMock.expect(((DaoIdStringUtil<T>) this.dao).findById(t.getId())).andReturn(t);

		EasyMock.replay(this.dao);

		T tRecuperer = ((DataBaseServiceWithDaoAndStringId<T>) this.service).getById(t.getId());

		assertEquals(tRecuperer, t);
		EasyMock.verify(this.dao);
	}

	@Test
	public void testGetByIdWithTUnknow() {
		String id = "id Non existant";
		
		EasyMock.expect(((DaoIdStringUtil<T>) this.dao).findById(id)).andReturn(null);

		EasyMock.replay(this.dao);

		T tRecuperer = ((DataBaseServiceWithDaoAndStringId<T>) this.service).getById(id);

		assertNull(tRecuperer);
		EasyMock.verify(this.dao);
	}
	
	@Test
	public void testCanBeAddedWithNoUseId() {
		T t = this.getNewObject();
		t.setId("idNonUtilisé");
		
		EasyMock.expect(((DaoIdStringUtil<T>) this.dao).findById(t.getId())).andReturn(null);

		EasyMock.replay(this.dao);

		boolean canBeAdded = ((DataBaseServiceWithDaoAndStringId<T>) this.service).canBeAdded(t);

		assertTrue(canBeAdded);
		EasyMock.verify(this.dao);
	}
	
	@Test
	public void testCanBeAddedWithUseId() {
		T t = this.getNewObject();
		t.setId("idUtilisé");
		
		EasyMock.expect(((DaoIdStringUtil<T>) this.dao).findById(t.getId())).andReturn(t);

		EasyMock.replay(this.dao);

		boolean canBeAdded = ((DataBaseServiceWithDaoAndStringId<T>) this.service).canBeAdded(t);

		assertFalse(canBeAdded);
		EasyMock.verify(this.dao);
	}
}
