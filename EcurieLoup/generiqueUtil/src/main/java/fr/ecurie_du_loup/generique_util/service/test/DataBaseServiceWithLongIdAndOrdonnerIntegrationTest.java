package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongIdAndOrdonner;
import fr.ecurie_du_loup.generique_util.type.DataOrdonner;

public abstract class DataBaseServiceWithLongIdAndOrdonnerIntegrationTest<T extends DataOrdonner> extends DataBaseServiceWithLongIdIntegrationTest<T>{

	
	
	@Test
	public void testDeleteAndCheckOrder() {
		T tAtDelete= this.getNewObject();
		tAtDelete.setOrdre(2);
		this.service.add(tAtDelete);
		
		T tMoveOrder= this.getNewObject();
		tMoveOrder.setOrdre(3);
		

		this.service.add(tMoveOrder);
		int ordreOfMoveT = tMoveOrder.getOrdre();



		this.service.delete(tAtDelete);

		T tRecuperer = ((DataBaseServiceWithLongId<T>) this.service).getById(tAtDelete.getId());
		assertNull(tRecuperer);
		
		T tRecupererMove = ((DataBaseServiceWithLongId<T>) this.service).getById(tMoveOrder.getId());
		assertNotNull(tRecupererMove);
		assertEquals(ordreOfMoveT-1, tRecupererMove.getOrdre());
		

	}
	
	
	@Test
	public void testModifierOrdre() {

		
		T tInBase = this.getNewObject();
		this.service.add(tInBase);
		int ordreTInBase = tInBase.getOrdre();
		
		T tSouhaitee = this.getNewObject();
		this.service.add(tSouhaitee);
		int ordreTSouhaitee = tSouhaitee.getOrdre();
		
		T tInBaseR = ((DataBaseServiceWithLongId<T>) this.service).getById(tInBase.getId());
		T tSouhaiteeR = ((DataBaseServiceWithLongId<T>) this.service).getById(tSouhaitee.getId());

		this.compareJUnit(tInBaseR, tInBase);
		this.compareJUnit(tSouhaiteeR, tSouhaitee);
		
		((DataBaseServiceWithLongIdAndOrdonner<T>) this.service).changeOrdre(tSouhaitee, ordreTInBase);
		
		tSouhaitee.setOrdre(ordreTInBase);
		tInBase.setOrdre(ordreTSouhaitee);
		
		
		tInBaseR = ((DataBaseServiceWithLongId<T>) this.service).getById(tInBase.getId());
		tSouhaiteeR = ((DataBaseServiceWithLongId<T>) this.service).getById(tSouhaitee.getId());
		
		this.compareJUnit(tInBaseR, tInBase);
		this.compareJUnit(tSouhaiteeR, tSouhaitee);
		
		
		this.service.delete(tSouhaitee);
		
		//le page 1 récupéré a l'ordre 1
		tInBase.setOrdre(ordreTInBase);
		tInBaseR = ((DataBaseServiceWithLongId<T>) this.service).getById(tInBase.getId());
		this.compareJUnit(tInBaseR, tInBase);
		
	}
}
