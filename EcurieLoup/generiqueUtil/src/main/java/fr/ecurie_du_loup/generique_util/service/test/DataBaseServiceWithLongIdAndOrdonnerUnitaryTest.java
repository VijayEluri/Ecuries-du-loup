package fr.ecurie_du_loup.generique_util.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongIdAndOrdonner;
import fr.ecurie_du_loup.generique_util.type.DataOrdonner;

public abstract class DataBaseServiceWithLongIdAndOrdonnerUnitaryTest<T extends DataOrdonner>  extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<T>{


	protected List<T> getListObjectOrdonner(){
		List<T> listT = new ArrayList<T>();
		int[] ordres = {10, 5, 2, 1, 8, 6, 7, 3, 9, 4};
		for(int i = 0 ; i < 10; i++){
			T t = this.getNewObject();
			t.setOrdre(ordres[i]);

			listT.add(t);
		}

		return listT;
	}
	
	
	@Override
	public void testAdd() {
		List<T> listT = this.getListObjectOrdonner();
		EasyMock.expect(this.dao.findAll()).andReturn(listT);
		super.testAdd();
	}



	@Override
	public void testDelete() {
		T t = this.getNewObject();
		t.setOrdre(2);

		//liste retourné
		List<T> listT = new ArrayList<T>();
		T tAdding = this.getNewObject();
		t.setOrdre(1);
		listT.add(tAdding);

		this.dao.remove(t);
		EasyMock.expect(this.dao.findAll()).andReturn(listT);

		EasyMock.replay(this.dao);

		this.service.delete(t);

		EasyMock.verify(this.dao);
	}
	
	@Test
	public void testCreationFirstElement() throws Throwable{

		T t = this.getNewObject();
		List<T> listT = new ArrayList<T>();

		this.dao.add(t);
		EasyMock.expect(this.dao.findAll()).andReturn(listT);
		EasyMock.replay(this.dao);

		this.service.add(t);

		assertFalse(t.getOrdre() == 0);
		assertTrue(t.getOrdre() == 1);

		EasyMock.verify(this.dao);
	}

	@Test
	public void testCreationSecondeElement() throws Throwable{

		T t = this.getNewObject();

		List<T> listT = new ArrayList<T>();
		T tAdding = this.getNewObject();
		tAdding.setOrdre(1);
		listT.add(tAdding);

		this.dao.add(t);
		EasyMock.expect(this.dao.findAll()).andReturn(listT);
		EasyMock.replay(this.dao);

		this.service.add(t);

		assertFalse(t.getOrdre() == 0);
		assertTrue(t.getOrdre() == 2);
		EasyMock.verify(this.dao);
	}

	@Test
	public void testDeteleWithElementAfter() throws Throwable{
		//TODO: checker a esprit reposé de l'interet de se test
		T t = this.getNewObject();
		t.setOrdre(1);
		
		//liste retourné
		List<T> listT = new ArrayList<T>();

		T tAdding = this.getNewObject();
		tAdding.setOrdre(2);
		listT.add(tAdding);

		this.dao.remove(t);
		
		//la liste contient la page
		EasyMock.expect(this.dao.findAll()).andReturn(listT);
		//on update la page avec le nouveauid

		//TODO : checker la valeur ordre du pageAjout
		this.dao.update(tAdding);

		EasyMock.replay(this.dao);

		this.service.delete(t);
		assertEquals(tAdding.getOrdre(), 1);
		EasyMock.verify(this.dao);
	}

	
	

	@Test
	public void testChangeOrdre() throws Throwable{

		List<T> listT = this.getListObjectOrdonner();

		EasyMock.expect(this.dao.findAll()).andReturn(listT);

		T t = listT.get(1);

		this.dao.update(t);
		this.dao.update(listT.get(7));
		this.dao.update(listT.get(9));

		EasyMock.replay(this.dao);

		((DataBaseServiceWithLongIdAndOrdonner<T>) this.service).changeOrdre(t, 3);

		//{10, 5, 2, 1, 8, 6, 7, 3, 9, 4}
		int[] ordre = {10, 3, 2, 1, 8, 6, 7, 4, 9, 5};

		for(int i = 0 ; i < 10; i++){
			assertEquals( i+" - "+listT.get(i).getOrdre()+" "+ordre[i], listT.get(i).getOrdre(), ordre[i]);
		}
		EasyMock.verify(this.dao);
	}
	@Test
	public void testModificationOrdreAvant() throws Throwable{

		List<T> listT = this.getListObjectOrdonner();


		EasyMock.expect(this.dao.findAll()).andReturn(listT);

		T t = listT.get(3);

		this.dao.update(t);
		this.dao.update(listT.get(0));
		this.dao.update(listT.get(1));
		this.dao.update(listT.get(2));
		this.dao.update(listT.get(4));
		this.dao.update(listT.get(5));
		this.dao.update(listT.get(6));
		this.dao.update(listT.get(7));
		this.dao.update(listT.get(8));
		this.dao.update(listT.get(9));


		EasyMock.replay(this.dao);

		((DataBaseServiceWithLongIdAndOrdonner<T>) this.service).changeOrdre(t, 10);

		//{10, 5, 2, 1, 8, 6, 7, 3, 9, 4}
		int[] ordre = {9, 4, 1, 10, 7, 5, 6, 2, 8, 3};

		for(int i = 0 ; i < 10; i++){
			assertEquals( i+" - "+listT.get(i).getOrdre()+" "+ordre[i], listT.get(i).getOrdre(), ordre[i]);
		}
		EasyMock.verify(this.dao);
	}

}
